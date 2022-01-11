<?php session_start(); ?>

<html>
    <head>
        <?php include("connexion.php");?>
        <title>Recette</title>
        <link rel="stylesheet" href="styleVoirRecette.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>

    <?php include ('entete.php');?>

    <body>
        <?php
        $id = $_GET['id'];
        $page = file_get_contents("http://localhost:8888/projetrecettes/recettes/$id");
        $obj = json_decode($page,true);

        $nom = $obj['nom'];
        $nb_personnes = $obj['nb_personnes'];
        $introduction = $obj['introduction'];
        $description = $obj['description'];
        $ingredients = $obj['ingredients'];
        $avis = $obj['avis'];
        $publication = false;
        if(isset($_SESSION['identifiant']))$user = $_SESSION['identifiant'];

        if($nb_personnes == 1) echo "<h1>$nom ($nb_personnes personne)</h1>";

        else echo "<h1>$nom ($nb_personnes personnes)</h1>";

        echo "<div class='cote'>
            <div class='voirRecette'>
                <div class='centre'>
                    <h2>$introduction</h2>
                    <h2>Ingrédients<hr class='barre'></h2>";

                    foreach($ingredients as $v){
                        $nom = $v['nom'];
                        $quantite = $v['quantite'];
                        echo"<h4>
                            <div class='total'>
                                <div class='gauche'>
                                    $nom
                                </div>
                                <div class='droite'>
                                    $quantite
                                </div>
                            </div>
                        </h4>";
                    }

                    echo "<br><h2>Préparation<hr class='barre'></h2>";
                    $desc = explode('<br>',$description);
                    $index=1;

                    echo "<div class='description'>";
                        foreach($desc as $v){
                            echo "<p class:'left'><div class='cercle'>$index</div>$v</p>";
                            $index+=1;
                        }
                    echo "</div><br><br><br>

                    <br><h2>Avis<hr class='barre'></h2>";
                    $index=0;
                    foreach($avis as $v){
                        $note = $v['note'];
                        $commentaire = $v['commentaire'];
                        $id_user = substr($v['_links']['utilisateur']['href'], -1);                        
                    
                        echo "<div class='avis'>";

                            for ($i = 1; $i <= 5; $i++) {
                                if($i<=$note) echo "<img src='etoile2.png' class='etoile'/>";
                                else echo "<img src='etoile.png' class='etoile'/>";
                            }

                            echo "<strong>&emsp;";

                            switch($note){
                                case 1 :
                                    echo "Mauvais...";
                                    break;
                                case 2 :
                                    echo "Pas terrible...";
                                    break;
                                case 3 :
                                    echo "Moyen";
                                    break;
                                case 4 :
                                    echo "Super !";
                                    break;
                                case 5 :
                                    echo "Parfait !";
                                    break;
                            }

                            if(isset($_SESSION['identifiant']) && $id_user == $user){
                                $publication = true;
                                echo "&emsp;<a href='voirrecette.php?id=$id&modif=1&avis=$index'><img title='Modifier votre avis' src='modifier.png' width='15px'></a>
                                &emsp;<a href='deleteAvis?id=$id&id_avis=$index'><img title='Supprimer votre avis' src='delete.png' width='15px'></a>";
                                $user_comm = $commentaire;
                                $user_note = $note;
                            } 

                            echo "</strong>
                            <p>$commentaire</p>
                        </div>";
                        $index++;
                    }

                    if(!isset($_SESSION['pseudo'])) echo "<br><h4>Veuillez vous connecter pour poster un avis</h4>";

                    else if(!$publication){
                        echo "<br><h2>Poster un avis<hr class='barre'></h2>
                        <form method='post'";?>
                            <div>
                                <div class='total'>
                                    <p class='centre'><input type="number", min='1', max='5', name="note", placeholder="Note (Entre 1 et 5)", value="<?php if (isset($_POST['note'])){echo $_POST['note'];} ?>"></p>
                                    <p><textarea class='total' rows="5", maxlength="250", placeholder="Rédigez votre commentaire...", name="commentaire"><?php if (isset($_POST['commentaire'])){echo $_POST['commentaire'];} ?></textarea></p>
                                </div>
                                <input type="submit" value="Poster l'avis" name="creationavis">
                            </div>
                        </form>

                        <?php
                        if(isset($_POST['creationavis'])){     
                            $note = $_POST['note'];
                            $commentaire = $_POST['commentaire'];               

                            if(empty($note) || empty($commentaire))echo "<div class='centre'><br>Veuillez remplir tous les champs !</div>";

                            else{
                                $ch = curl_init();
                                curl_setopt($ch, CURLOPT_URL, "http://localhost:8888/saveAvis");
                                curl_setopt($ch, CURLOPT_POST, 1);
                                $datas = array("id_recette"=>$id,"commentaire"=>$commentaire, "note"=>(int)$note,"id_utilisateur"=>$user);
                                curl_setopt($ch, CURLOPT_POSTFIELDS,$datas);
                                $result = curl_exec($ch);
                                curl_close($ch);
                                echo "<script language='Javascript'>

                                document.location.replace('voirrecette.php?id=$id');

                                </script>";
                            }
                        }
                    }

                    else if(isset($_GET['modif'])){
                        echo "<br><h2>Modifier votre avis<hr class='barre'></h2>
                        <form method='post'>
                            <div>
                                <div class='total'>
                                    <p class='centre'><input type='number', min='1', max='5', name='note', placeholder='Note (Entre 1 et 5)'', value=$user_note></p>
                                    <p><textarea class='total' rows='5', maxlength='250', placeholder='Rédigez votre commentaire...', name='commentaire'>$user_comm</textarea></p>
                                </div>
                                <input href='voirrecette.php?id=$id' type='submit' value='Annuler' name='annuler'> <input type='submit' value='Publier' name='modifavis'>
                            </div>";

                            if(isset($_POST['modifavis'])){
                                $note = $_POST['note'];
                                $commentaire = $_POST['commentaire'];             

                                if(empty($note) || empty($commentaire))echo '<br>Veuillez remplir tous les champs !';
                                
                                else{
                                    $ch = curl_init();
                                    curl_setopt($ch, CURLOPT_URL, "http://localhost:8888/modifAvis");
                                    curl_setopt($ch, CURLOPT_POST, 1);
                                    $datas = array("id_recette"=>$id,"commentaire"=>$commentaire, "note"=>(int)$note,"id_avis"=>$_GET['avis']);
                                    curl_setopt($ch, CURLOPT_POSTFIELDS,$datas);
                                    $result = curl_exec($ch);
                                    print_r($result);
                                    curl_close($ch);
                                    echo "<script language='Javascript'>

                                    document.location.replace('voirrecette.php?id=$id');

                                    </script>";
                                }
                            }
		                echo "</form>";
                    }
                echo "</div><br><br><br>";?>
            </div>
        </div>
    </body>
</html>