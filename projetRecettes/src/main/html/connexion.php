<?php
$servername = 'localhost';
$username = 'root';
$password = '';
$dbname='projetrecettes';
//On établit la connexion
$conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);

?>