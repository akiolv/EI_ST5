# BackEnd de notre application mobile

Ce projet consiste à récupérer des demandes par des requetes HTML et le page php renvoie un json décodable par l'appli.

## liste des pages webs:

- http://webprog-dev.com/getInfos/recupMesure.php?id_patient=? : Permet de récupérer les mesures pour le patient ?
- http://webprog-dev.com/getInfos/recupProche.php?id_patient=? : Liste les proches du patient ?
- http://webprog-dev.com/getInfos/recupInput.php?date=?&taux=?&id_patient=? : Insert une nouvelle ligne dans la bdd
- http://webprog-dev.com/getInfos/listePatient.php?id_medecin=? : Liste les patients d'un medecin
- http://webprog-dev.com/getInfos/infoMedecin.php?id_medecin=? : Permet de récupérer les informations du medecins
- http://webprog-dev.com/getInfos/infoMedecin.php?id_patient=? : Permet de récupérer les informations du patients
- http://webprog-dev.com/getInfos/connexion.php?email=?&mdp=? : Permet de vérifier les identifiants de connexion d'un utilisateur