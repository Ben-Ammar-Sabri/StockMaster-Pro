<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="fr">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Connexion - StockMaster Pro</title>
        <link rel="stylesheet" href="css/style.css">
        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .login-card {
                width: 100%;
                max-width: 400px;
                padding: 2.5rem;
                margin: 1rem;
            }

            .login-header {
                text-align: center;
                margin-bottom: 2rem;
            }

            .login-header h1 {
                font-size: 1.875rem;
                font-weight: 800;
                color: var(--primary);
                margin-bottom: 0.5rem;
            }

            .login-header p {
                color: var(--text-muted);
                font-size: 0.875rem;
            }

            .error-box {
                background: #fee2e2;
                border-left: 4px solid #ef4444;
                color: #b91c1c;
                padding: 0.75rem;
                border-radius: 4px;
                margin-bottom: 1.5rem;
                font-size: 0.875rem;
                text-align: center;
            }

            .form-label {
                display: block;
                font-size: 0.875rem;
                font-weight: 500;
                color: var(--text-main);
                margin-bottom: 0.5rem;
            }

            .login-btn {
                width: 100%;
                padding: 12px;
                margin-top: 1rem;
                font-size: 1rem;
            }
        </style>
    </head>

    <body>
        <div class="glass-card login-card">
            <div class="login-header">
                <h1>StockMaster Pro</h1>
                <p>Gérez votre inventaire avec élégance</p>
            </div>

            <% if (request.getAttribute("erreur") !=null) { %>
                <div class="error-box">
                    <%= request.getAttribute("erreur") %>
                </div>
                <% } %>

                    <form action="connexion" method="POST">
                        <div class="form-group">
                            <label class="form-label" for="login">Identifiant</label>
                            <input class="input-field" type="text" id="login" name="login" placeholder="Ex: sabri"
                                required>
                        </div>
                        <div class="form-group">
                            <label class="form-label" for="pass">Mot de passe</label>
                            <input class="input-field" type="password" id="pass" name="pass" placeholder="••••••••"
                                required>
                        </div>
                        <button class="btn-primary login-btn" type="submit">Se connecter</button>
                    </form>

                    <div style="margin-top: 2rem; text-align: center; font-size: 0.75rem; color: var(--text-muted);">
                        © 2026 StockMaster Pro Inc.
                    </div>
        </div>
    </body>

    </html>