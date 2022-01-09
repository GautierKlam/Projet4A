<?php session_start(); ?>

<html>
    <head>
        <?php include("connexion.php");?>
        <title>Accueil Recette</title>
        <link rel="stylesheet" href="accueil.css" type="text/css">
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

            echo "<div style='text-align:center'>
                <h2>$introduction</h2>
                <h2>Ingrédients<hr width=10%></h2>";

                foreach($ingredients as $v){
                    $nom = $v['nom'];
                    $quantite = $v['quantite'];
                    echo"<div width=60%>
                        <h4>$nom : $quantite</h4>
                    </div>";
                }

                echo "<br><h2>Préparation<hr width=10%></h2>";
                $desc = explode('<br>',$description);
                $index=1;

                foreach($desc as $v){
                    echo "<p>";
                    echo "<div class='cercle'>$index</div>$v";
                    $index+=1;
                }
                echo "<br><br><br>

                <br><h2>Avis<hr width=10%></h2>";
                foreach($avis as $v){
                    $note = $v['note'];
                    $commentaire = $v['commentaire'];

                    echo "<div>";
                        for ($i = 1; $i <= 5; $i++) {
                            if($i<=$note) echo "<img id='etoile_$i' src='etoile2.png' height=20px; width=20px; cursor=pointer;/>";
                            else echo "<img id='etoile_$i' src='etoile.png' height=20px; width=20px; cursor=pointer;/>";
                    }
                    echo "<p>$commentaire</p>
                    </div>";
                }
             echo "</div>";
        ?>
    </body>
</html>