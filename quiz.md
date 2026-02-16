# Quiz StockMaster Pro - Réponses et Analyse Architecturelle

## Analyse de l'Architecture en Couches

**Question :** Avez-vous eu besoin de modifier la JSP ? Pourquoi est-ce un avantage majeur de l'architecture en couches ?

**Réponse :**
Non, la JSP (`catalogue.jsp`) n'a pas été modifiée lors de l'implémentation de la couche DAO. 

C'est un avantage majeur car cela illustre le **découplage** :
- La vue (JSP) est indépendante de la source de données.
- On peut modifier la logique d'accès aux données (passer de JDBC à une API REST ou un autre SGBD) dans le DAO sans impacter l'interface utilisateur.
- Cela facilite la maintenance et permet aux développeurs front-end et back-end de travailler en parallèle.

---

## Réponses au Quiz

1. **Dans le modèle MVC (Partie 1), quel est le rôle principal de la Servlet ?**
   - **B)** Servir d'aiguilleur en recevant la requête et en choisissant la vue.

2. **Pourquoi les JSPs du catalogue sont-elles placées dans /WEB-INF/ ?**
   - **B)** Pour empêcher un utilisateur d'y accéder directement via une URL sans passer par la Servlet.

3. **Lors de l'authentification (Partie 2), quelle méthode permet de conserver l'identité de l'utilisateur durant toute sa navigation ?**
   - **C)** `session.setAttribute()`

4. **Quel composant est le plus adapté pour vérifier systématiquement si un utilisateur est connecté avant d'afficher le catalogue (Partie 3) ?**
   - **B)** Un Filter (Filtre) qui intercepte les requêtes.

5. **Dans un filtre de sécurité, que permet de faire l'instruction chain.doFilter(request, response) ?**
   - **C)** Laisser la requête continuer son chemin vers la Servlet ou la JSP cible.

6. **Quelle est la particularité d'un Cookie par rapport à une Session (Partie 4) ?**
   - **B)** Le cookie peut survivre à la fermeture du navigateur si une durée de vie (maxAge) est définie.

7. **Quel est l'avantage principal d'utiliser la couche DAO (Partie 5) ?**
   - **B)** Isoler le code SQL pour que le reste de l'application ne dépende pas de la structure de la base de données.

8. **En JDBC, pourquoi privilégie-t-on PreparedStatement au lieu de Statement ?**
   - **B)** Pour protéger l'application contre les injections SQL grâce au paramétrage des requêtes.

9. **Dans la JSP, que se passe-t-il si vous écrivez ${produit.nom} ?**
   - **B)** L'EL appelle automatiquement la méthode getNom() du bean produit.

10. **Si vous modifiez la structure de votre base de données SQL, quels composants du TP devrez-vous modifier en priorité ?**
    - **B)** Uniquement le Bean et le DAO.
