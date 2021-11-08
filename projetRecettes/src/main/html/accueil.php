
<html>
    <head>
    <?php
    include("connexion.php");
    ?>
        <title>Accueil Recette</title>
    </head>
    <body>
    <?php
      $sth = $conn->query("SELECT * FROM recette");
      $sth->execute();
      while($row = $sth->fetch()) {
        echo  $row['description'].' '.$row['introduction'].' '.$row['nom'].' '.$row['recette_type']."<br>";
      }
    ?>
    </body>
</html>
