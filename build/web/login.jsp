<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Login</title>

        <style>
            /* CSS for styling the login page */
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
            }
            .login-container {
                width: 400px;
                margin: 100px auto;
                padding: 20px;
                background-color: white;
                box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
                border-radius: 8px;
            }
            .login-logo {
                text-align: center;
                margin-bottom: 20px;
            }
            .login-logo img {
                width: 150px; /* Adjust size as needed */
            }
            .login-container h1 {
                text-align: center;
                color: #333;
                margin-bottom: 30px;
            }
            .login-container form {
                display: flex;
                flex-direction: column;
            }
            .login-container input[type="tel"] {
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 4px;
                font-size: 16px;
            }
            .login-container input[type="submit"] {
                padding: 10px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 4px;
                font-size: 16px;
                cursor: pointer;
            }
            .login-container input[type="submit"]:hover {
                background-color: #45a049;
            }
            .error-message {
                color: red;
                text-align: center;
                margin-bottom: 20px;
            }
        </style>
        <!-- Google tag (gtag.js) -->
        <script async src="https://www.googletagmanager.com/gtag/js?id=G-TC7EY8QP13"></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag() {
                dataLayer.push(arguments);
            }
            gtag('js', new Date());

            gtag('config', 'G-TC7EY8QP13');
        </script>
    </head>
    <body>
        <div class="login-container">
            <div class="login-logo">
                <img src="Icon/CoffeePuppyStore.jpg" alt="Logo">
            </div>
            <h1>Login For Member</h1>

            <%
                String error = (String) request.getAttribute("error");
                if (error != null) {
            %>
            <div class="error-message"><%= error%></div>
            <%
                }
            %>
            <form action="LoginController" method="get">
                <input type="tel" name="txtPhone" placeholder="Your phone number" maxlength="10" required pattern="[0-9]{10}">
                <input type="submit" value="Next">
            </form>
        </div>
    </body>
</html>
