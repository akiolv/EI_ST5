<?php

if(isset($_GET['id_patient']))
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
	$statement = $bddlog->prepare("SELECT nom, prenom FROM Medecin AS me JOIN medecin_patient AS mp JOIN Patients AS pa ON me.id_medecin = pp.id_medecin AND pa.id_patient = pp.id_patient WHERE id_patient = ".$_GET['id_patient']);
	$statement->execute();
	$results = $statement->fetchAll(PDO::FETCH_ASSOC);
	$json = json_encode($results);

	echo($json);
}

?>