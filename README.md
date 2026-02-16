# StockMaster Pro - JEE Web Application

StockMaster Pro est une application web de gestion de stock développée en Java avec Jakarta EE, suivant le design pattern MVC et une architecture DAO.

## 🚀 Fonctionnalités
- **Authentification** : Système de login sécurisé par session.
- **Sécurité** : Filtre Jakarta Servlet pour protéger l'accès au catalogue.
- **Catalogue** : Affichage dynamique des produits depuis une base de données.
- **Gestion des Cookies** : Suivi et affichage de la date/heure de dernière visite.
- **Architecture DAO** : Séparation de la logique d'accès aux données.

## 🛠 Technologies
- **Java 17+**
- **Jakarta EE 10+** (Servlet, JSP, JSTL)
- **Maven** (Build et dépendances)
- **Microsoft SQL Server** (Base de données)
- **Tomcat 10+** (Serveur d'application)

## 📁 Structure du Projet
- `com.stock.model` : Objets métier (POJO).
- `com.stock.dao` : Accès aux données (JDBC).
- `com.stock.controller` : Servlets de pilotage.
- `com.stock.filter` : Sécurité (Filtres).
- `webapp/WEB-INF/vues` : Vues JSP.

## ⚙️ Configuration SQL Server
Pour que l'application puisse se connecter, SQL Server doit être configuré :
1. **Activer TCP/IP** : Dans "SQL Server Configuration Manager", activez TCP/IP et fixez le port sur `1433` (section IPAll).
2. **Mode Mixte** : Activez l'authentification "SQL Server and Windows" dans SSMS.
3. **Utilisateur** : Créez ou activez l'utilisateur `sabri` avec le mot de passe `sabri123`.
4. **Base de données** : Créez une base `stockdb` avec une table `produit` (colonnes `id`, `nom`, `prix`).

## 📥 Installation
1. Clonez ou importez le projet dans IntelliJ IDEA.
2. Configurez un serveur Tomcat 10.
3. Exécutez le build Maven : `mvn clean install`.
4. Démarrez le serveur.
