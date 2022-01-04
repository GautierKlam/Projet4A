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
		<title>Déconnexion</title>
		<link rel="stylesheet" href="deconnexion.css" type="text/css">
	</head>

	<?php include ('entete.php');?>

	<body>
		<form method="post">
			<div>Voulez-vous vraiment vous déconnecter ?<div>
			<a class:'boutons' href="accueil.php"> <input type="button" value="Annuler"></a>
			<a class:'boutons'><input type="submit" value="Déconnexion" name="deconnecter"></a>

		    <?php
            	if(isset($_POST['deconnecter']))
                {
					session_destroy();
					header('Location: accueil.php');
					exit;
                }
			?>
		</form>
	</body>
</html>