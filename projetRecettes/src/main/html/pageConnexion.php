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
			<input  type="password", name="mdp", value="">

		</p>

		<p>
		<input class:'boutons' type="submit" value="Connexion" name="connecter">
		<a class:'boutons' href="creationCompte.php"><input type="button" value="Créer un compte"></a>

		</p>


		</form>



	</body>
</html>
