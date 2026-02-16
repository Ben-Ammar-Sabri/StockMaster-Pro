<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="fr">

    <head>
        <meta charset="UTF-8">
        <title>Connexion - StockMaster Pro</title>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-color: #f4f7f6;
                margin: 0;
            }

            .login-container {
                background: white;
                padding: 2rem;
                border-radius: 8px;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                width: 300px;
            }

            h2 {
                text-align: center;
                color: #333;
                margin-bottom: 1.5rem;
            }

            .form-group {
                margin-bottom: 1rem;
            }

            label {
                display: block;
                margin-bottom: 0.5rem;
                color: #666;
            }

            input {
                width: 100%;
                padding: 0.5rem;
                border: 1px solid #ddd;
                border-radius: 4px;
                box-sizing: border-box;
            }

            button {
                width: 100%;
                padding: 0.75rem;
                background-color: #007bff;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 1rem;
                margin-top: 1rem;
            }

            button:hover {
                background-color: #0056b3;
            }

            .error {
                color: #dc3545;
                text-align: center;
                margin-bottom: 1rem;
                font-size: 0.9rem;
            }
        </style>
    </head>

    <body>
        <div class="login-container">
            <h2>StockMaster Pro</h2>
            <% if (request.getAttribute("erreur") !=null) { %>
                <div class="error">
                    <%= request.getAttribute("erreur") %>
                </div>
                <% } %>
                    <form action="connexion" method="POST">
                        <div class="form-group">
                            <label for="login">Utilisateur</label>
                            <input type="text" id="login" name="login" required>
                        </div>
                        <div class="form-group">
                            <label for="pass">Mot de passe</label>
                            <input type="password" id="pass" name="pass" required>
                        </div>
                        <button type="submit">Se connecter</button>
                    </form>
        </div>
    </body>

    </html>