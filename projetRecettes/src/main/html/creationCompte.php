<!DOCTYPE html>
<html>
    <head>
        <?php include("connexion.php");?>
        <title>Création de compte</title>
        <link rel="stylesheet" href="styleConnexion.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <?php include("entete.php");?>
	<body>
	    <title>Inscription</title>
		<form method="post">
            <div id=baniere>
                <div id=baniere_gauche>
                    <p>
                        <label>Nom :  &nbsp; </label>
                    </p>
                    <p>
                        <label>Prénom :  &nbsp; </label>
                    </p>
                    <p>
                        <label>Pseudo :  &nbsp; </label>
                    </p>
                    <p>
                        <label>Mot de passe :  &nbsp; </label>
                    </p>
                    <p>
                        <label>&nbsp;Confirmez le mot de passe :  &nbsp; </label>
                    </p>
                    <p>
                        <label>Adresse de courriel : &nbsp; </label>
                    </p>
                </div>
                <div id=baniere_droite>
                    <p>
                        <input type="text", name="nom", value="<?php if (isset($_POST['nom'])){echo $_POST['nom'];} ?>">&nbsp;
                    </p>
                    <p>
                        <input type="text", name="prenom", value="<?php if (isset($_POST['prenom'])){echo $_POST['prenom'];} ?>">&nbsp;
                    </p>
                    <p>
                        <input type="text" name="pseudo"  value="<?php if (isset($_POST['pseudo'])){echo $_POST['pseudo'];} ?>">&nbsp;
                    </p>
                    <p>
                        <input type="password", name="mdp", value="">&nbsp;
                    </p>
                    <p>
                        <input type="password", name="mdp2", value="">&nbsp;
                    </p>
                    <p>
                        <input type="text", name="mail", value="<?php if (isset($_POST['mail'])){echo $_POST['mail'];} ?>">&nbsp;
                    </p>
                    <div id=btnValider>
                       <input type="submit" value="Créer votre compte" name="creationcompte" class="button">
                    </div>
                    <p>
                        <label>&nbsp;</label>
                    </p>
                </div>
            </div>
            <?php
                $page = file_get_contents("http://localhost:8888/projetrecettes/utilisateurs");
                $obj = json_decode($page,true);
                $test = $obj['_embedded'];

                if(isset($_POST['creationcompte'])){
                    $validation = true;
                    foreach ($test['utilisateurs'] as $v){
                        $pseudo = $v['pseudo'];
                        $mail = $v['mail'];
                        if ($_POST['pseudo']==$pseudo){
                            $message = 'Ce pseudo est déjà utilisé';
                            $validation = false;
                        }
                        else if ($_POST['mail']==$mail){
                            $message = 'Cette adresse mail est déjà utilisée';
                            $validation = false;
                        }
                        else if ($_POST['mdp']!= $_POST['mdp2']){
                            $message = 'Les mots de passe sont différents';
                            $validation = false;
                        }
                    }

                    if(empty($_POST['nom']) || empty($_POST['prenom']) || empty($_POST['pseudo']) || empty($_POST['mdp']) || empty($_POST['mdp2']) || empty($_POST['mail']) ){
                        $validation = false;
                        $message = 'Veuillez remplir tout les champs !';
                    }

                    if($validation){
                        $ch = curl_init();
                        curl_setopt($ch, CURLOPT_URL, "http://localhost:8888/saveUtilisateur");
                        curl_setopt($ch, CURLOPT_POST, 1);
                        $datas = array("nom"=>$_POST['nom'], "prenom"=>$_POST['prenom'], "pseudo"=>$_POST['pseudo'],"mdp"=>password_hash($_POST['mdp'],PASSWORD_DEFAULT),"mail"=>$_POST['mail']);
                        curl_setopt($ch, CURLOPT_POSTFIELDS,$datas);

                        $result = curl_exec($ch);
                        print_r($result);
                        curl_close($ch);
                        header("Location: pageConnexion.php");
                    }
                    else echo $message;
                }
            ?>
		</form>
	</body>
</html>