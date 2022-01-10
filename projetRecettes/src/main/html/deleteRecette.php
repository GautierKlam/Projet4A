<?php 
    session_start(); 
    if(!isset($_SESSION['pseudo'])){
        header('Location: accueil.php');
        exit;
    }

    $id = $_GET['id'];
    $loc = $_GET['loc'];

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, "http://localhost:8888/deleteRecette");
    curl_setopt($ch, CURLOPT_POST, 1);
    $datas = array("id"=>$id);
    curl_setopt($ch, CURLOPT_POSTFIELDS,$datas);
    $result = curl_exec($ch);
    print_r($result);
    curl_close($ch);
    if($loc == "perso") header("Location: maPage.php");
    else header("Location: accueil.php");
?>