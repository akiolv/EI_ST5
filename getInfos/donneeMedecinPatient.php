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
	$statement = $bddlog->prepare("SELECT * FROM Medecin AS me JOIN medecin_patient AS mp JOIN Patient AS pa ON me.id_medecin = mp.id_medecin AND pa.id_patient = mp.id_patient WHERE pa.id_patient = ?");
	$statement->execute($_GET['id_patient']);
	$results = $statement->fetchAll(PDO::FETCH_ASSOC);
	$json = json_encode($results);

	echo($json);
}

?>