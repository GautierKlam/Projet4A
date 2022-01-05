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
        <h2 style='text-align:center'>Voici l'ensemble des recettes disponibles, cliquez sur le nom pour voir ses avis et sa description entière</h2>
      
        <div style='text-align:center'>
            <form method='GET'>
                <input size='40%' type='search' name='recherche' placeholder='Rechercher une recette...' />
                <input type='submit' value='Valider' />
            </form>
        </div>

        <?php
            if(isset($_GET['recherche'])) $page = file_get_contents('http://localhost:8888/projetrecettes/recettes/search/findByNomContaining?nom='.$_GET['recherche']);

            else $page = file_get_contents('http://localhost:8888/projetrecettes/recettes');

            $obj = json_decode($page,true);
            $test = $obj['_embedded'];

            if(count($test['recettes'])==0) echo "<p style='text-align:center'>Aucun résultat pour la recherche : ".$_GET['recherche']."</p>";
            
            else{
                echo"<table>
                <caption>Liste des recettes (nom, petite description et type)</caption>";

                foreach ($test['recettes'] as $v) {
                    $id = substr($v['_links']['self']['href'], -1);
                    $nom = $v['nom'];
                    $intr = $v['introduction'];
                    $typerecette = $v['recetteType'];
                    echo"<tr><td><a href='voirrecette.php?id=$id'>".$nom."</a></td><td>".$intr."</td><td>".$typerecette."</td></tr>";
                }  
                echo "</table>";
            }
        ?>
    </body>
</html>