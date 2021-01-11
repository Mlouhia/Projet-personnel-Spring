# Test-technique

*Question 3: Bonnes pratiques pour garantir la qualité de code:
- Règles de nommage: Classes en upper Camel Case - Fonctions et variables en miniscule - Constantes en majuscule (dans la classe enumération TypeModification)
- Commentaires: toutes les déclarations de variables ou de fonctions et les bouts de code sont précédés par des commentaires pour expliquer l'objectif.
- Nom des variables: tous les noms de variables et de fonctions sont significatifs et décrivent bien l'objectif de la déclaration.
- Les tests automatisés testsNG et les tests Cucumber (approche BDD)
- Dans les classes modèles, les attributs sont privés et l'accès à ces variables est assuré par des getteurs et setteurs.



*Tutoriel de l'application:
La conception de l'application a sorti 3 grandes entités: un abonné, un contrat et un mouvement.
L'application est composée de 4 packages: controller, model, service et repository. Chacun de ces packages fait référence aux 3 entités. 

Le package Controller contient les controlleurs qui constituent les conteneurs d'APIs: AbonneController, ContratController et  MouvementController. Chaque controlleur contient les web services de l'entité en question.

Le package model contient les classes modèles de chacun des 3 entités: Abonne, Contrat et Mouvement avec les attributs correspondants et les jointures avec les autres entités. Les annotations dans ces classes modèles assurent le mapping JPA avec la base de données.

Le package service contient les classes services qui assurent le traitement appelé par les web services afin de leurs retourner le résultat demandé.

Le package repository contient les classes qui assurenent la communication avec la base de données H2.

Pour Utiliser l'application, il faut exécuter la classe GestionAbonneApplication qui lance l'application et crée l'application context de Spring Boot.

L'application présente 5 web services: 
Remarque: Le deuxième scénraio est traité dans le meme projet dans le web service modifierAdresseSC2 dans la classe AbonneController. LE web service modifierAdresseSC1 est destiné au premier scénario.

1- Création d'un abonné (méthode: creerAbonner, classe: AbonneController)
Exemple d'appel:
POST http://localhost:8080/abonne
Content-Type: application/json

{
  "adressePrincipale":"36 rue baudin Courbevoie",
  "nom": "Mlouhia",
  "prenom": "Yassine"
}

2- souscrire un contrat (méthode: creerContrat, classe: ContratController)
Exemple d'appel:
POST http://localhost:8080/contrat
Content-Type: application/json

{
  "adresse":"testAdresse1",
  "abonne" : {"id": 1}
}

3- Modifier l'adresse d'un abonné: 
Scénario 1 (méthode: modifierAdresseSC1, classe: AbonneController)
Exemple d'appel: 
POST http://localhost:8080/ModifierAdresseSC1
Content-Type: application/json

{
  "adressePrincipale":"23 Avenue de la sygrie Clamart",
  "id": 1
}

Scénario 2 (méthode: modifierAdresseSC2, classe: AbonneController)
Exemple d'appel: 
POST http://localhost:8080/ModifierAdresseSC2
Content-Type: application/json

{
  "adressePrincipale":"las Cortes Barcelona Spain",
  "id": 1
}

4- Récupérer les informations sur les contrats (méthode: getAbonneContrat, classe: ContratController):
Exemple d'appel:
GET http://localhost:8080/abonneGetContrat/1

5- Récupérer l’historique des mouvements de modification (méthode: getAbonneModifications, classe: MouvementController):
Exemple d'appel:
GET http://localhost:8080/abonneGetModifications/1


Les tests sont dans le répertoire src/test/java/com/testCanal/gestionAbonne.







