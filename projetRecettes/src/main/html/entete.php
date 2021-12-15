<html>
<link rel="stylesheet" href="entete.css" type="text/css">
<!-- CSS only -->
<!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
-->
</html>
<?php
$page = file_get_contents("http://localhost:8888/projetrecettes/utilisateurs");
        $obj=json_decode($page,true);
        $test = $obj['_embedded'];
        foreach ($test['utilisateurs'] as $v)
                    {
                    if $v['isConnected']==1{

                        echo"<header>
                            <div class='entete'>
                            <a id='accueil' href='accueil.php'>Page d'accueil</a>

                            <a id='connexion' href='pageConnexion.php'>Connexion</a></div>
                        </header>";
                    }
                    else{
                        echo"<header>
                            <div class='entete'>
                            <a id='accueil' href='accueil.php'>Page d'accueil</a>

                            <a id='connexion' href='pageDeconnexion.php'>Déconnexion</a></div>
                            </header>";
                    }
        }
?>
