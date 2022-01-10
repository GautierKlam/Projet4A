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
                    foreach($avis as $v){
                        $note = $v['note'];
                        $commentaire = $v['commentaire'];
                        $id_user = substr($v['_links']['utilisateur']['href'], -1);
                        if(isset($_SESSION['identifiant']))$user = $_SESSION['identifiant'];
                        
                    
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
                                echo "&emsp;<a><img title='Votre avis' src='etoile2.png' width='15px' ></a>";
                            } 
                            echo "</strong>
                            <p>$commentaire</p>
                        </div>";
                    }

                    if(!isset($_SESSION['pseudo'])) echo "<br><h4>Veuillez vous connecter pour poster un avis</h4>";
                    else if(!$publication){
                        echo "<br><h2>Poster un avis<hr class='barre'></h2>
                        <form method='post' action='voirrecette.php?id=$id'>";?>
                            <div>
                                <div class='total'>
                                    <p class='centre'><input type="number", min='1', max='5', name="note", placeholder="Note (Entre 1 et 5)", value="<?php if (isset($_POST['note'])){echo $_POST['note'];} ?>"></p>
                                    <p><textarea class='total' rows="5", maxlength="250", placeholder="Rédigez votre commentaire...", name="commentaire", value="<?php if (isset($_POST['commentaire'])){echo $_POST['commentaire'];} ?>"></textarea></p>
                                </div>
                                <input type="submit" value="Poster l'avis" name="creationavis">
                            </div>
                            <?php
                            if(isset($_POST['creationavis'])){     
                                $note = $_POST['note'];
                                $commentaire = $_POST['commentaire'];               
                                if(empty($note) || empty($commentaire))echo '<br>Veuillez remplir tout les champs !';
                                else{
                                    /*$ch = curl_init();
                                    curl_setopt($ch, CURLOPT_URL, "http://localhost:8888/saveAvis");
                                    curl_setopt($ch, CURLOPT_POST, 1);
                                    $datas = array("commentaire"=>$commentaire, "note"=>(int)$note, "id_recette"=>$_GET['id'],"id_utilisateur"=>$user);
                                    curl_setopt($ch, CURLOPT_POSTFIELDS,$datas);
                                    $result = curl_exec($ch);
                                    print_r($result);
                                    curl_close($ch);*/
                                }
                            }
		                echo "</form>";
                    }
                echo "</div><br><br><br>";?>
            </div>
        </div>
    </body>
</html>