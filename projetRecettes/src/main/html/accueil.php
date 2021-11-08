
<html>
    <head>
    <?php
    include("connexion.php");
    ?>
        <title>Accueil Recette</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <body>
    <?php

      $sth = $conn->query("SELECT * FROM recette");

      $sth->execute();
      while($row = $sth->fetch()) {
        echo  utf8_encode($row['description']).' '. utf8_encode($row['introduction']).' '.utf8_encode($row['nom']).' '.utf8_encode($row['recette_type'])."<br>";
      }
    ?>
    </body>
</html>
