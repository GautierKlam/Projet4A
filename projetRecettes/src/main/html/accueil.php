<html>
    <head>
        <title>Accueil Recette<title>
    </head>
    <body>
    <?php
      $sth = $dbco->prepare("SELECT prenom, mail FROM users");
      $sth->execute();
    ?>
    </body>
</html>