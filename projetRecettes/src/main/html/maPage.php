<?php 
    session_start(); 
    if(!isset($_SESSION['pseudo'])){
        header('Location: accueil.php');
        exit;
    }
?>

<html>
    <head>
        <?php include("connexion.php");?>
        <title>Votre compte</title>
        <link rel="stylesheet" href="menu.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <?php include ('entete.php');?>

    <body>
        <h1>Voici les recettes que vous avez créés</h1>

<?php
        if(isset($_SESSION['pseudo'])){
            $pseudo=$_SESSION['pseudo'];
            $page = file_get_contents('http://localhost:8888/projetrecettes/recettes');
            $obj = json_decode($page,true);
            $test = $obj['_embedded'];
            $nb_recettes = 0;
            echo "<table>
                <caption>Listes de vos recettes</caption>";
            foreach ($test['recettes'] as $v) {
                $link=$v['_links'];
                $user=$link['utilisateur'];
                $user1=$user['href'];
                $page1=file_get_contents($user1);
                $obj1 = json_decode($page1,true);
                $vraiuser=$obj1['pseudo'];
                if ($vraiuser==$pseudo){
                    $nb_recettes++;
                    $id=substr($link['self']['href'], -1);
                    $intr=$v['introduction'];
                    $nom=$v['nom'];
                    $typerecette=$v['recetteType'];
                    echo "<td><a href='voirrecette.php?id=$id'>$nom</a></td><td>$intr</td><td>$typerecette</td><td><a href='ajoutRecette.php?modif=$id'><img title='Modifier la recette' src='modifier.png' width='20px' ></a></td><td><a href='deleteRecette.php?id=$id&loc=perso'><img title='Supprimer la recette' src='delete.png' width='20px'></a></td></tr>";
                }
            }
            echo "</table></br>";
            if($nb_recettes==0) echo "<h4><div class='centre'>Malheureusement vous n'avez pas encore de recettes à vous :(</div></h4><br>";
            echo "<div class='centre'> <a href='ajoutRecette.php' > <img width='50px' title='Ajouter une recette' src='add.png'></a></div>";
        }
        ?>
    </body>
</html>