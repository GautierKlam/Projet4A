# Rapport Projet 4A IA2R

## Site collaboratif de partage de recettes


Bernardelli Stéphane
Klam Gautier
Perrelle Romain

## Sommaire
##### [INTRODUCTION](#introduction)
##### I - [OBJECTIFS DU PROJET](#objectif)	
##### A - [Contexte](#contexte)	
##### B - [Objectifs](#objectifs)
##### C - [Enjeux](#enjeux)
##### II - [DEROULEMENT DU PROJET](#deroulement)
##### A - [Diagrammes](#diagrammes)
##### [Diagramme des cas d’utilisation :](#utilisation)	
##### [Diagramme de classes :](#classes)	
##### B - [Composition de l’équipe et répartition des tâches](#compo)
##### III - [DÉVELOPPEMENT DU PROJET](#dev)
##### A - [Développement du front end](#devfront)
##### B - [Développement du back end](#devback)
##### C - [Difficultées rencontrées](#difficulte)
##### [CONCLUSION](#ccl)
##### [BIBLIOGRAPHIE](#biblio)








## Introduction <a id="introduction"></a>

Dans le cadre de notre 4ème année du cycle d’ingénieur à Polytech Nancy, nous avons été amenés à réaliser un projet afin de mettre en pratique nos connaissances acquises durant les cours du premier semestre, prenant la forme du développement d’un site web collaboratif.
Pour la réalisation de ce projet, nous avons formé un groupe, composé de Perrelle Romain, Klam Gautier et Bernardelli Stéphane, et avons mis en commun nos passions pour la cuisine et le développement, sous l’encadrement de notre professeur responsable Samir Youcef. Notre projet a alors pris la forme d’une application collaborative de partage de recettes, où les utilisateurs sont capables de découvrir de nouvelles recettes, ou alors de partager les leurs pour en faire profiter les autres.

## I - OBJECTIFS DU PROJET <a id="objectif"></a>

### A - Contexte <a id="contexte"></a>

De nos jours, lorsque l’on ignore la manière de faire afin de réaliser un plat, notre premier réflexe est de chercher une recette correspondante sur le web. Étant fortement intéressés par la cuisine, nous avons donc décidé, afin de satisfaire ces utilisateurs, de développer une application web permettant de répondre à leurs besoins en regroupant une large gamme de recettes, allant des entrées aux desserts, sans oublier les plats. Ces recettes seront toujours plus nombreuses grâce à la possibilité donnée aux utilisateurs de publier leurs propres recettes, ce qui permet à notre site d’être évolutif et le plus documenté possible. Les utilisateurs ne sachant comment préparer leurs plats seront donc face à diverses façons de les préparer, et pourront choisir celle qui leur fait le plus envie. D’autres utilisateurs, à la recherche de nouvelles recettes, pourront eux aussi satisfaire leur curiosité en explorant notre site et toutes les recettes qu’il contient. 

### B - Objectifs <a id="objectifs"></a>

L'objectif principal de ce projet est de mettre en pratique les différentes compétences acquises lors de ce semestre ainsi que les différents langages que nous avons vu durant notre formation.
A l’aide des compétences déjà acquises et d’autres que nous apprendrons au cours du développement du projet, nous avons choisi de créer un site web le plus ergonomique possible pour l’utilisateur. Nous lui offrons pour cela un accès sans connexion pour la visualisation des recettes ainsi qu’un accès utilisateur afin de partager son expérience culinaire et prendre en compte les avis constructifs des autres utilisateurs, tout ça dans le but d’améliorer la qualité de sa recette.


### C - Enjeux <a id="enjeux"></a>

Le but de notre projet étant de mettre en pratique nos connaissances acquises durant le semestre, le principal enjeu était de réussir à correctement mettre en place les différentes technologies que nous avons pu découvrir durant les cours dispensés lors de cette période. Et pour ce faire, un des enjeux majeurs fût de parvenir à relier et faire communiquer les différentes technologies que nous avons utilisées dans ce projet, chose que, bien que la théorie nous ait été enseignée, nous n’avions pas pu mettre en pratique, et qui ne fut pas aussi simple que nous ne le pensions.


## II - DEROULEMENT DU PROJET <a id="deroulement"></a>

Le projet a commencé en novembre et a pris fin en janvier, nous avons d’abord commencé par énoncer les objectifs et les technologies que nous allons utiliser. Nous avons ensuite établi les diagrammes décrivant notre projet pour finalement finir sur le développement du site.

### A - Diagrammes <a id="diagrammes"></a>

##### Diagramme des cas d’utilisation : <a id="utilisation"></a>

![](https://github.com/GautierKlam/Projet4A/blob/main/utilisation.png?raw=true)

Le diagramme des cas d’utilisation est constitué de 3 principaux acteurs. Nous avons un visiteur, capable uniquement de visualiser les recettes présentes sur le site, sans interférer avec. Pour cela, le visiteur doit s’authentifier s' il possède un compte, ou bien en créer un.
Nous avons l’utilisateur connecté qui hérite des fonctionnalités du visiteur, et peut également créer une recette, gérer celles qu’il a créées ou encore gérer ses avis. Il a également accès à sa page personnelle.
Pour finir nous avons l’administrateur qui est capable de gérer l’ensemble du site, ayant la possibilité de modifier ou supprimer toutes les recettes et avis présents sur le site.



##### Diagramme de classes : <a id="classes"></a>
![](https://github.com/GautierKlam/Projet4A/blob/main/classe.png?raw=true)

Dans ce diagramme de classe, nous avons 4 entités distinctes caractérisées par leur identifiant. Nous avons la classe utilisateur qui a comme attributs son nom, prénom, pseudo, adresse mail et un booléen afin de savoir si l’utilisateur est administrateur ou non.
Nous avons une classe recette qui a comme attribut son nom et sa description. Elle donne accès à des méthodes pour créer, modifier et supprimer une recette. Chaque recette se compose d’un ou plusieurs ingrédients et avis. Un ingrédient peut être lié à plusieurs recettes mais un avis n’en concerne qu’une. 







### B - Composition de l’équipe et répartition des tâches <a id="compo"></a>

![](https://github.com/GautierKlam/Projet4A/blob/main/equipe.png?raw=true)

## III - DÉVELOPPEMENT DU PROJET <a id="dev"></a>

Notre application web créée avec Spring Boot respecte l’architecture MVC, Modèle - Vue - Contrôleur.

![](https://github.com/GautierKlam/Projet4A/blob/main/mvc.png?raw=true)
	
Dans la partie back-end, donc la partie serveur, qui implémente les parties Modèle (représente les données à manipuler) et Contrôleur (correspond aux classes Java annotées @RestController qui font du mapping URL), nous avons choisi une API Rest en Java avec IntelliJ comme IDE.
Pour la partie front-end, soit la partie client, qui représente la Vue (correspond aux fichiers HTML), nous nous sommes orientés vers du PHP, qui est un langage très utilisé pour les applications web, ainsi que du HTML et du CSS afin de réaliser le design de notre application. 
Afin de lancer notre code en PHP, nous avons utilisé WampServer, qui avait également pour rôle d’héberger la base de données en SQL, avec phpMyAdmin.




### A - Développement du front end <a id="devfront"></a>

Concernant le front-end, chaque interaction avec la base de données se fait au travers des méthodes Java en utilisant le framework Spring. Nous avons une page pour l’ajout d’une recette, sa modification ainsi que sa suppression. Nous avons également une page pour la déconnexion d’un utilisateur et une autre pour l’ajout, la modification et la suppression d’un avis. Par ailleurs, nous avons créé un en-tête afin d’alléger le code et éviter toute redondance.
Le développement se fait essentiellement autour de PHP pour la collecte des données du formulaire et la génération du contenu dynamique, HTML pour la structure du site et CSS pour sa mise en forme.
Les pages se composent toutes d’un en-tête dans lequel il est possible d'accéder à la page d’accueil, à la de création de recette, la page de l’utilisateur et la page de déconnection si l’utilisateur est connecté, et la page de connexion si il ne l’est pas.
La page d’accueil affiche toutes les recettes enregistrées dans la base de données à l’aide de la méthode: 
file_get_contents('http://localhost:8888/projetrecettes/recettes');
Cette méthode récupère les données écrites sur la page dont l’URL est entrée. Ces données proviennent de la partie serveur de notre application.
Afin de filtrer les résultats, une barre de recherche permet à l’utilisateur de chercher les recettes par leur nom.

Lors de l’appui sur le titre d’une recette, l’utilisateur accède à la page de cette recette, dans laquelle se trouvent toutes ses caractéristiques. 
On y trouve les différents ingrédients de la recette, accompagnés de leur quantité, le nombre de personnes adapté aux quantités indiquées, ainsi que la description des différentes étapes de préparation de la recette. Il est également possible de voir tous les avis laissés par les utilisateurs.
Le site met à disposition une page de connexion pour les utilisateurs, vérifiant que tous champs sont bien saisis et que le pseudo n’a pas déjà été utilisé. Une fois connecté, l’utilisateur peut laisser un avis à chaque recette mais aussi créer une nouvelle recette.
Les utilisateurs disposent d’une page dans laquelle ils peuvent ajouter une recette et visualiser toutes celles qu’ils ont ajoutées. Il leur est possible de les supprimer et de les modifier depuis cette page. 

### B - Développement du back end <a id="devback"></a>

Dans la partie back-end se trouvent les contrôleurs et les entités. Ils respectent l’architecture vue en cours et utilisent l’outil de gestion Maven intégré à intelliJ, ce qui permet d’inclure des dépendances et des plugins nécessaires à la construction du projet déclaré dans un fichier XML : pom.xml. Cette architecture permet également d’avoir accès aux annotations qui implémentent le RESTful web service tel que @Path, @Get ou encore @Post.
Il faut ensuite fournir des données à la vue, pour cela le framework Spring met à disposition des classes dont l’objectif est de nous faciliter la tâche. Elles sont liées aux annotations telles que @GetMapping (pour récupérer des données) ou encore @PostMapping (pour envoyer des données).

Chaque classe Java possède les attributs suivants :

Utilisateur	:
- identifiant
- nom
- prenom
- pseudo
- mot de passe
- mail
- admin

Recette :
- identifiant
- nom
- nombre de personnes
- introduction
- description
- ingrédients
- type de la recette
- avis
- utilisateur

Avis : 
- identifiant
- note
- commentaire
- recette
- utilisateur

Ingrédient :
- identifiant
- nom
- quantité
- recette

Dans les classes contrôleurs sont implémentées les méthodes permettant au front-end de communiquer avec la base de données, à savoir les méthodes permettant de créer, modifier, ainsi que supprimer les différentes entités évoquées plus haut. 
L’interface des recettes propose une méthode permettant aux utilisateurs de faire une recherche sur l’ensemble des recettes.


### C - Difficultées rencontrées <a id="difficulte"></a>

A travers le développement de notre application, nous avons fait face à diverses difficultés. La première d’entre elles fut de parvenir à accéder aux méthodes Java définies dans nos contrôleurs, donc nos méthodes d'ajout, modification et suppression des différentes entités. Suite à de nombreuses recherches, nous avons fini par découvrir l’existence des sessions cURL, que nous avons donc utilisées afin de transférer nos données via les URL définis dans nos contrôleurs.
Une fois que nous avons été capable de transmettre des données à notre back-end, nous avons rencontré une deuxième difficulté. En effet, il ne nous était pas possible d’ajouter des ingrédients lors de l’ajout d’une recette. Afin de pallier ce problème, nous avons dû injecter les ingrédients séparément du reste de la recette à l’aide d’une autre session cURL. 
Le dernier problème auquel nous avons fait face concerne un problème d’affichage. Bien que les entités soient correctement créées, un message d’erreur apparaît lors de l’ajout d’ingrédients ou encore lors de l’ajout, la modification ou la suppression d’un avis. Nous sommes parvenus à créer malgré tout nos entités, toutefois le message reste visible par les utilisateurs lorsqu’ils réalisent ces actions. Le message d’erreur semble suggérer que la définition des ingrédients dans les recettes provoque une boucle infinie, toutefois nous ne disposions pas du temps nécessaire à la résolution totale de ce problème.

Les difficultés que nous avons rencontré ne nous ont pas permis d’implémenter l’intégralité des fonctionnalités dont nous souhaitions doter notre application. 
Parmi celles-ci, il convient de remarquer que, lors de l’ajout ou la modification d’une recette, il n’est possible d’entrer qu’un unique ingrédient. De plus, en ce qui concerne les étapes de préparation, l’utilisateur ne peut entrer plusieurs lignes qu’en écrivant une balise <br>, ce qui n’est pas ergonomique ni instinctif. Ces modifications ne sont à faire qu’au niveau du front-end, leur implémentation dans le back-end est effective, nous avons seulement manqué de temps afin de les rendre accessibles aux utilisateurs.
Enfin, nous souhaitions permettre aux utilisateurs de modifier ou supprimer leur compte, toutefois nous avons encore une fois manqué de temps afin de l’implémenter.


## CONCLUSION <a id="ccl"></a>

Ce projet fut très enrichissant en découvrant de nouvelles technologies comme Spring Boot et l’api REST. Nous avons également pu approfondir nos connaissances des différents langages que nous avons utilisés, à savoir Java, PHP et HTML/CSS. 
De plus, nous avons eu la possibilité de renforcer notre esprit d’équipe, notamment à l’aide de notre dépôt git, qui nous a permis de partager nos avancements personnels et d’en discuter, ainsi que de nos difficultés, que nous pouvions nous partager, ce qui n’aurait pas été rendu possible sans l’existence de ce dépôt. De l’idée du site web à la fin de son développement.

## BIBLIOGRAPHIE <a id="biblio"></a>

Les différents sites que nous avons consulté :
https://tutorialsclass.com/php-rest-api-file_get_contents/
https://www.php.net/manual/fr/function.file-get-contents.php
https://stackoverflow.com/questions/25195010/json-decode-returning-error-notice-trying-to-get-property-of-non-object


