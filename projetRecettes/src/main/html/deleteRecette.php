<?php 
    session_start(); 
    if(!isset($_SESSION['pseudo'])){
        header('Location: accueil.php');
        exit;
    }

    $id = $_GET['id'];

    /*$ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, "http://localhost:8888/saveAvis");
    curl_setopt($ch, CURLOPT_POST, 1);
    $datas = array("commentaire"=>$commentaire, "note"=>(int)$note, "id_recette"=>$_GET['id'],"id_utilisateur"=>$user);
    curl_setopt($ch, CURLOPT_POSTFIELDS,$datas);
    $result = curl_exec($ch);
    print_r($result);
    curl_close($ch);*/
?>