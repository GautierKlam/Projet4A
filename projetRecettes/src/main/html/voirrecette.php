<?php session_start(); ?>

<html>
    <head>
        <?php include("connexion.php");?>
        <title>Accueil Recette</title>
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
                    
                        echo "<div class='avis'>";
                            for ($i = 1; $i <= 5; $i++) {
                                if($i<=$note) echo "<img src='etoile2.png' class='etoile'/>";
                                else echo "<img src='etoile.png' class='etoile'/>";
                            }
                            echo "<p>$commentaire</p>
                        </div>";
                    }
                    echo "<br><form method='GET'>
                        <img src='etoile.png' class='etoile-avis'/>
                        <img src='etoile.png' class='etoile-avis'/>
                        <img src='etoile.png' class='etoile-avis'/>
                        <img src='etoile.png' class='etoile-avis'/>
                        <img src='etoile.png' class='etoile-avis'/>
                        <input size='50%' type='search' name='commentaire' placeholder='Ajouter un commentaire...' />
                        <input type='submit' value='Soumettre'/>
                    </form>
                </div><br><br><br>";?>
            </div>
        </div>
    </body>
</html>