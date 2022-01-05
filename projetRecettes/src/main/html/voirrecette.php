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

            if($nb_personnes == 1) echo "<h1>$nom ($nb_personnes personne)</h1>";

            else echo "<h1>$nom ($nb_personnes personnes)</h1>";

            echo "<h2 style='text-align:center'>$introduction</h2>";
        ?>
    </body>
</html>