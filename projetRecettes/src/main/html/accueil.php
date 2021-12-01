
<html>
    <head>
    <?php
    include("connexion.php");
    ?>
        <title>Accueil Recette</title>
        	<link rel="stylesheet" href="accueil.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <?php include ('entete.php');?>
    <body>
      <h1>Bienvenue sur notre site de recette collaboratif !</h1>
      <h2>Voici l'ensemble des recettes disponibles, cliquez sur le nom pour voir ses avis et sa description entière</h2>
    <?php
      $sth = $conn->query("SELECT * FROM recette");
      $sth->execute();
      echo "<table>";
      echo "<caption>Liste des recettes (nom,petite description et type)</caption>";

      while($row = $sth->fetch()) {
          echo "<tr>";
          $id=$row['id_recette'];
        $intr= utf8_encode($row['introduction']);
        $nom=utf8_encode($row['nom']);
        $typerecette=utf8_encode($row['recette_type']);
        echo"<td><a href='voirrecette.php?id=$id'>".$nom."</a></td><td>".$intr."</td><td>".$typerecette."</td></tr>";
      }
        echo "</table>"
    ?>
    </body>
</html>
