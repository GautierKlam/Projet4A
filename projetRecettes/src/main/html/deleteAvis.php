<?php 
    session_start(); 
    if(!isset($_SESSION['pseudo'])){
        header('Location: accueil.php');
        exit;
    }

    $id = $_GET['id'];
    $id_avis = $_GET['id_avis'];

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, "http://localhost:8888/deleteAvis");
    curl_setopt($ch, CURLOPT_POST, 1);
    $datas = array("id_recette"=>$id, "id"=>$id_avis);
    curl_setopt($ch, CURLOPT_POSTFIELDS,$datas);
    $result = curl_exec($ch);
    print_r($result);
    curl_close($ch);
    header("Location: voirrecette.php?id=$id");
?>