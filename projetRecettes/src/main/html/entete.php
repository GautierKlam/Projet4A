<html>
    <link rel="stylesheet" href="entete.css" type="text/css">
</html>

<?php
    if(isset($_SESSION['pseudo'])){
        $pseudo = $_SESSION['pseudo'];
        echo"<header>
            <div>
                <a id='accueil' href='accueil.php'>Page d'accueil</a>
                <a id='ajoutRecette' href='ajoutRecette.php'> Ajouter une recette</a>
                <a id='maPage' href='maPage.php'>$pseudo</a>
                <a id='connexion' href='pageDeconnexion.php'>Déconnexion</a>
            </div>
        </header>";
    }

    else{
        echo"<header>
            <div>
                <a id='accueil' href='accueil.php'>Page d'accueil</a>
                <a id='connexion' href='pageConnexion.php'>Connexion</a>
            </div>
        </header>";
    }
?>