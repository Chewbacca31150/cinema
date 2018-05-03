# CINEMA

## ACCEDER A L'APPLICATION

 ``http://localhost:4200``

Pour tester : 

USER
* username : user
* password : user

ADMIN
* username : admin
* password : admin

## DESCRIPTION

CINEMA

## LANCEMENT DE L'APPLICATION...

### SERVEUR

mvn install sur le pom.xml
lancer Application.java

### CLIENT

DOSSIER : covoiturage-client

Si vous n'avez pas node, un dossier node est présent dans le client.

``npm install``
``npm start``

Ensuite, accéder à l'applicaition en allant sur un navigateur et en tapant ``https://localhost:4300``

## ERREUR SI LE SERVEUR NE FONCTIONNE PAS

DOSSIER : covoiturage-server

``mvn install``

``mvn package``

Puis : 

``java -jar target\cinema-0.0.1.jar``
