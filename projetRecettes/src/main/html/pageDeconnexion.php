<html>
	<header>
		<title>Déconnexion</title>
		<link rel="stylesheet" href="deconnexion.css" type="text/css">
	</header>
	<body>
		<form method="post">
			<?php
				echo "Voulez-vous vraiment vous déconnecter ?";
				echo"<br/><br/>"."<a href='accueil.php'><input type='button' value='Annuler' name='annul'></a>"."<input type='submit' value='Déconnexion' name='deco'>";
			    if(isset($_POST['connecter']))
                {
                    header("Location: pageConnexion.php");
                }
			?>
		</form>
	</body>
</html>