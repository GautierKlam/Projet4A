<?php 
    session_start(); 
    if(!isset($_SESSION['pseudo'])){
        header('Location: accueil.php');
        exit;
    }?>

<html>
    <head>
        <?php include("connexion.php");?>
        <title>Votre compte</title>
        <link rel="stylesheet" href="menu.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
</html>

<?php
    include('entete.php');
    $id = $_GET['id'];
    $id_avis = $_GET['id_avis'];

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, "http://localhost:8888/deleteAvis");
    curl_setopt($ch, CURLOPT_POST, 1);
    $datas = array("id_recette"=>$id, "id_avis"=>$id_avis);
    curl_setopt($ch, CURLOPT_POSTFIELDS,$datas);
    $result = curl_exec($ch);
    print_r($result);
    curl_close($ch);
    echo "<script language='Javascript'>

    document.location.replace('voirrecette.php?id=$id');

    </script>";
?>