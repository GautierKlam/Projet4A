<html>
<?php include("entete.php");?>
<link rel="stylesheet" href="styleConnexion.css" type="text/css">
	<body>
	<title>Connexion</title>
		<form method="post" >
		    <p>
			<label>Pseudo ou e-mail :</label>
			<input type="text" name="pseudo"  value="">
			</p>

			<p>
			<label>Mot de passe:</label>
			<input type="password", name="mdp", value="">
		    </p>

            <p>
            <input class:'boutons' type="submit" value="Connexion" name="connecter">
            <a class:'boutons' href="creationCompte.php"><input type="button" value="Créer un compte"></a>
            </p>

        <?php
        $page = file_get_contents("http://localhost:8888/projetrecettes/utilisateurs");
        $obj=json_decode($page,true);
        $test = $obj['_embedded'];

        if(isset($_POST['connecter']))
        {
            foreach ($test['utilisateurs'] as $v)
            {
                $pseudo = $v['pseudo'];
                $mdp = $v['mdp'];
                if ($_POST['pseudo']==$pseudo AND $_POST['mdp']==$mdp)
                {
                    $v['isconnected']=true;
                    header("Location: accueil.php");
                }
            }
            echo 'Identifiant ou mot de passe incorrect';
        }
        ?>

		</form>
	</body>
</html>