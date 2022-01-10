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
        <title>Ajout d'une recette</title>
        <link rel="stylesheet" href="styleAjoutRecette.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <?php include("entete.php");?>
	<body>
		<form method="post">
            <div id=baniere>
                <br>
                <p>
                    <label>Nom de la recette :  &nbsp; </label>
                    <input type="text", name="nom", value="<?php if (isset($_POST['nom'])){echo $_POST['nom'];} ?>">&nbsp;
                </p>
                <br>
                <p>
                    <label for="nb">Nombre de personne :  &nbsp; </label>
                    <input type="number" id="nb" name="nb_personnes" value="<?php if (isset($_POST['nb_personnes'])){echo $_POST['nb_personnes'];} ?>">&nbsp;
                </p>
                <br>
                <p>
                    <label>Description de la recette :  &nbsp; </label>
                    <input type="text" name="introduction" value="<?php if (isset($_POST['introduction'])){echo $_POST['introduction'];} ?>">&nbsp;
                </p>
                <br>
                <p>
                    <label>Etape de préparation :  &nbsp; </label>
                    <input type="text", name="description", value="<?php if (isset($_POST['description'])){echo $_POST['description'];} ?>">&nbsp;
                </p>
                <br>
                <p>
                    <label>Type de la recette :  &nbsp; </label>
                    <select name="recetteType" id="typeSelect">
                        <option value="ENTREE">Entrée</option>
                        <option value="PLAT" selected>Plat</option>
                        <option value="DESSERT">Dessert</option>
                    </select>
                </p>
                <br>
                <p>
                    <label>Ingrédient : &nbsp;  (nom - quantité)</label>
                    <input type="text" id="nI" name="nomIngredient", value="<?php if (isset($_POST['ingredients'])){echo $_POST['ingredients'];} ?>">&nbsp;
                    <input type="text" id='qI' name="quantiteIngredient", value="<?php if (isset($_POST['ingredients'])){echo $_POST['ingredients'];} ?>">&nbsp;
                </p>
                <br>
                <p>
                    <input type="submit" value="Ajouter la recette" name="ajoutrecette" class="button">
                 </p>
                <br>
            </div>
            <?php
                if(isset($_POST['ajoutrecette']))
                {
                    $validation = true;
                    if(empty($_POST['nom']) || empty($_POST['nb_personnes']) || empty($_POST['introduction']) || empty($_POST['description']) || empty($_POST['recetteType']) || empty($_POST['nomIngredient']) || empty($_POST['quantiteIngredient']))
                    {
                        $validation = false;
                        $message = 'Veuillez remplir tous les champs !';
                    }

                    if($validation==true)
                    {
                        $ch = curl_init();
                        curl_setopt($ch, CURLOPT_URL, "http://localhost:8888/saveRecette");
                        curl_setopt($ch, CURLOPT_POST, 1);
                        $datas = array("nom"=>$_POST['nom'], "nb_personnes"=>$_POST['nb_personnes'], "introduction"=>$_POST['introduction'],"description"=>$_POST['description'],"recetteType"=>$_POST['recetteType'],"utilisateur"=> $_SESSION['identifiant']);
                        curl_setopt($ch, CURLOPT_POSTFIELDS,$datas);
                        $result = curl_exec($ch);
                        curl_close($ch);

                        header("Location: pageConnexion.php");
    //  MARCHE PO //
                        /*$page = file_get_contents('http://localhost:8888/projetrecettes/recettes');
                        $obj = json_decode($page,true);
                        $test = $obj['_embedded']['recettes'];
                        foreach ($test as $v) {
                            $nom = $v['nom'];
                            if ($nom==$_POST['nom'])
                            {
                                $id = substr($v['_links']['self']['href'], -1);
                            }
                        }
                        $ch = curl_init();
                        curl_setopt($ch, CURLOPT_URL, "http://localhost:8888/saveIngredient");
                        curl_setopt($ch, CURLOPT_POST, 1);
                        $datas = array("nom"=>$_POST['nomIngredient'], "quantite"=>$_POST['quantiteIngredient']);
                        curl_setopt($ch, CURLOPT_POSTFIELDS,$datas);
                        $result = curl_exec($ch);
                        curl_close($ch);*/
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