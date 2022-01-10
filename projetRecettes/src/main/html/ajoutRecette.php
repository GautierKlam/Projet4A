<?php session_start(); ?>
<html>
    <head>
        <?php include("connexion.php");?>
        <title>Ajout d'une recette</title>
        <link rel="stylesheet" href="menu.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <?php include("entete.php");?>
	<body>
		<form method="post">
            <div id=baniere>
                <div id=baniere_gauche>
                    <p>
                        <label>Nom de la recette :  &nbsp; </label>
                    </p>
                    <p>
                        <label>Nombre de personne :  &nbsp; </label>
                    </p>
                    <p>
                        <label>Description de la recette :  &nbsp; </label>
                    </p>
                    <p>
                        <label>Etape de préparation :  &nbsp; </label>
                    </p>
                    <p>
                        <label>Type de la recette :  &nbsp; </label>
                    </p>
                    <p>
                        <label>Ingrédient : &nbsp; </label>
                    </p>
                </div>
                <div id=baniere_droite>
                    <p>
                        <input type="text", name="nom", value="<?php if (isset($_POST['nom'])){echo $_POST['nom'];} ?>">&nbsp;
                    </p>
                    <p>
                        <input type="text", name="nb_personnes", value="<?php if (isset($_POST['nb_personnes'])){echo $_POST['nb_personnes'];} ?>">&nbsp;
                    </p>
                    <p>
                        <input type="text" name="introduction"  value="<?php if (isset($_POST['introduction'])){echo $_POST['introduction'];} ?>">&nbsp;
                    </p>
                    <p>
                        <input type="text", name="description", value="<?php if (isset($_POST['description'])){echo $_POST['description'];} ?>">&nbsp;
                    </p>
                    <p>
                        <input type="text", name="recetteType", value="<?php if (isset($_POST['recetteType'])){echo $_POST['recetteType'];} ?>">&nbsp;
                    </p>
                    <p>
                        <input type="text", name="ingredients", value="<?php if (isset($_POST['ingredients'])){echo $_POST['ingredients'];} ?>">&nbsp;
                    </p>
                       <input type="submit" value="Ajouter la recette" name="ajoutrecette" class="button">
                    <p>
                        <label>&nbsp;</label>
                    </p>
                </div>
            </div>
            <?php
                if(isset($_POST['ajoutrecette']))
                {
                    $validation = true;
                    if(empty($_POST['nom']) || empty($_POST['nb_personnes']) || empty($_POST['introduction']) || empty($_POST['description']) || empty($_POST['recetteType']) || empty($_POST['ingredients']) )
                    {
                        $validation = false;
                        $message = 'Veuillez remplir tout les champs !';
                    }

                    if($validation==true)
                    {
                        $ch = curl_init();
                        curl_setopt($ch, CURLOPT_URL, "http://localhost:8888/saveRecette");
                        curl_setopt($ch, CURLOPT_POST, 1);
                        $datas = array("nom"=>$_POST['nom'], "nb_personnes"=>$_POST['nb_personnes'], "introduction"=>$_POST['introduction'],"description"=>$_POST['description'],"recetteType"=>$_POST['recetteType'],"ingredients"=>$_POST['ingredients']);
                        curl_setopt($ch, CURLOPT_POSTFIELDS,$datas);

                        $result = curl_exec($ch);
                        print_r($result);
                        curl_close($ch);
                    }
                    else
                    {
                        echo $message;
                    }
                }
            ?>
		</form>
	</body>
</html>