<?php session_start(); ?>
<html>
    <head>
        <?php include("connexion.php");
        $admin=false;
        if(isset($_SESSION['pseudo'])){
            $pseudo=$_SESSION['pseudo'];
            $page1 = file_get_contents('http://localhost:8888/projetrecettes/utilisateurs');
            $obj1 = json_decode($page1,true);
            $test1 = $obj1['_embedded'];
            foreach ($test1['utilisateurs'] as $m) {
                if ($pseudo==$m['pseudo']){
                    if ($m['admin']==true) $admin=true;
                    else $admin=false;
                }
            }
        }
        ?>
        <title>Accueil Recette</title>
        <link rel="stylesheet" href="menu.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>

    <?php include ('entete.php');?>

    <body>
        <h1>Bienvenue sur notre site de recette collaboratif !</h1>
        <h2 class='centre'>Voici l'ensemble des recettes disponibles, cliquez sur leur nom pour les afficher en entier</h2>

        <div class='centre'>
            <form method='GET'>
                <input size='40%' type='search' name='recherche' placeholder='Rechercher une recette...'/>
                <input type='submit' value='Valider'/>
            </form>
        </div>

        <?php
            if(isset($_GET['recherche'])){
                $recherche = $_GET['recherche'];
                $recherches = explode(' ',$recherche);
                $test=[];
                foreach($recherches as $v){
                    if(strlen($v)>2){
                        $page = file_get_contents('http://localhost:8888/projetrecettes/recettes/search/findByNomContaining?nom='.$v);
                        $obj = json_decode($page,true);
                        foreach($obj['_embedded']['recettes'] as $u){
                            if(!in_array($u,$test)) array_push($test,$u);
                        }
                    }
                }
            }

            else{
                $page = file_get_contents('http://localhost:8888/projetrecettes/recettes');
                $obj = json_decode($page,true);
                $test = $obj['_embedded']['recettes'];
            }

            if(count($test)==0 && isset($_GET['recherche'])) echo "<h4 class='centre'>Aucun résultat pour la recherche : \"$recherche\"</h4>";

            else if(count($test)==0) echo "<h4 class='centre'>Il n'y a pas encore de recettes publiées sur le site</h4>";

            else{
                echo"<table>
                <caption>Liste des recettes (nom, petite description et type)</caption>";

                foreach ($test as $v) {
                    $id = substr($v['_links']['self']['href'], -1);
                    $nom = $v['nom'];
                    $intr = $v['introduction'];
                    $typerecette = $v['recetteType'];
                    if ($admin==true) $phrase="<td><a href='ajoutRecette.php?modif=$id&loc=accueil'><img title='Modifier la recette' src='modifier.png' width='20px' ></a></td><td><a href='deleteRecette.php?id=$id&loc=accueil'><img title='Supprimer la recette' src='delete.png' width='20px' ></a></td>";
                    else $phrase="";
                    echo"<tr><td><a href='voirrecette.php?id=$id'>$nom</td><td>$intr</td><td>$typerecette</td>$phrase</tr>";
                }
                echo "</table>";
            }
        ?>
    </body>
</html>
