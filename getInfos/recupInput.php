<?php

if(isset($_GET['date']) AND isset($_GET['taux']) AND isset($_GET['id_patient']))
{
	//connexion à la base de donnée des logins:
	try
	{
	$bddlog = new PDO('mysql:host=webprogdfvakio.mysql.db;dbname=webprogdfvakio;charset=utf8', 'webprogdfvakio', 'AntAurEl9');
	}
	catch (Exception $e)
	{
		die('Erreur : ' . $e->getMessage());
	}
	$login = $bddlog->query('SELECT MAX(id_mesure) AS idmesure FROM Mesures');

	$id = $login->fetch();
	$nid = 1 + $id['idmesure'];

	$login = $bddlog->query("INSERT INTO Mesures(id_mesure, date_prise, niveau_glycemine, id_patient) VALUES ('".$nid."','". htmlspecialchars($_GET['date'])."','".htmlspecialchars($_GET['taux'])."','".htmlspecialchars($_GET['id_patient'])."')");

	echo(htmlspecialchars($_GET['date'])." - ".htmlspecialchars($_GET['taux'])." - ".htmlspecialchars($_GET['id_patient'])." : ajoute");
}
?>