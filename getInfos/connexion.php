<?php

$id = -1;

if(isset($_GET['email']) && isset($_GET['mdp']))
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
	$login = $bddlog->query("SELECT * FROM Patient WHERE email = '".htmlspecialchars($_GET['email'])."' AND mdp = '".htmlspecialchars($_GET['mdp'])."'");

	while($donnee = $login->fetch())
	{
		if($donnee['email']==$_GET['email'])
		{
			if($donnee['mdp']==$_GET['mdp'])
			{
				$id = $donnee['id_patient'];
			}
	    }
	}
}
echo(json_encode($id));		
?>