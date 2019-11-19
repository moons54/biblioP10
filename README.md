# biblioP7
 ** Creation d’une application de gestion de pret de livre. 

Commencer

composition :

Web-Service
l'application est crée en 6 sous-modules :
biblio-webapp
biblio-model
biblio-consumer
biblio-business
biblio-technical
biblio-batch

Partie Cliente
cli-webapp
cli-technical

Partie Batch
batchlibrairie


Conditions préalables :

utilisation : un serveur Apache Tomcat 9.0.101, 
une base de donnée dans notre exemple : PostgreSQL version 10


L'installation

Vous trouverez un fichier backup de la base de données dans le répertoire script  :

Presence de trois fichiers :
-backupBiblio_AMI
-StructureBiblio_AMI.sql ( structure des données)
-DataBiblio_AMI.sql ( enregistrement d'un jeu de donnée)

Le serveur PostgreSQL est configuré avec les paramètres par défaut : Host name/address : localhost Port : 5432 Username : root


Déploiement

Créer une database sous PostgreSQL :

Nommer la database : librairieP7 ( en respectant majuscule minuscule)

Utiliser le compte par default postgres. Importer les fichiers SQL:


Construit avec

Bootstrap 4- Le framework web 

JDK Version 1.8 ( IMPORTANT UTILISER CETTE VERSION SINON VOUS AUREZ DES ERREURS DE COMPILATION)

SOAP 5.5.0 : Gestion des webServices

Appache CXF 3.3.2

Maven version 4.0.0  - Gestion de la dépendance

Struts 2- Utilisé pour gérer les Actions de l’applications

Spring version 1.5.1- Utilisé pour la gestion des dépendances

Visual Paradigm : élaboration des schemas (wireframe), création du MPD, Use case, Schéma de dépoiement.

Gestion des versions

_Nous utilisons Ghitub pour la gestion des versions. _

