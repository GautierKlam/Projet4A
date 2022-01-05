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
        <h1>Bienvenue sur notre site de recette collaboratif !</h1>
        <h2>Voici l'ensemble des recettes disponibles, cliquez sur le nom pour voir ses avis et sa description entière</h2>

        <?php
            $page = file_get_contents('http://localhost:8888/projetrecettes/recettes');
            $obj = json_decode($page,true);
            $test = $obj['_embedded'];
      
      
            echo "<table>";
            echo "<caption>Liste des recettes (nom, petite description et type)</caption>";
            $id = 0;
            foreach ($test['recettes'] as $v) {
                $id++;
                echo "<tr>";
                $intr=$v['introduction'];
                $nom=$v['nom'];
                $typerecette=$v['recetteType'];
                echo"<td><a href='voirrecette.php?id=$id'>".$nom."</a></td><td>".$intr."</td><td>".$typerecette."</td></tr>";
            }  
            echo "</table>";
        ?>
    </body>
</html>