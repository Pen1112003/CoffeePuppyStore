<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Welcome to Coffee Puppy Store</title>
        <script async src="https://www.googletagmanager.com/gtag/js?id=G-TC7EY8QP13"></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag() {
                dataLayer.push(arguments);
            }
            gtag('js', new Date());
            gtag('config', 'G-TC7EY8QP13');
        </script>
        <style>
            html, body {
                height: 100%;
                margin: 0;
            }
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                text-align: center;
                background-image: url('background/background.jpg');
                background-size: cover;
                background-position: center;
                color: #ffffff;
            }
            .container {
                padding: 20px;
                border-radius: 10px;
                margin-top: 50px;
                max-width: 600px;
                margin-bottom: 100px;
            }
            h1 {
                font-size: 48px;
                font-weight: bold;
                text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
            }
            img {
                max-width: 150px;
                height: auto;
            }
            input[type="submit"] {
                background-color: #ffcc00;
                border: none;
                border-radius: 5px;
                color: #000;
                padding: 10px 20px;
                font-size: 16px;
                cursor: pointer;
                transition: background-color 0.3s ease;
                margin-top: 20px;
            }
            input[type="submit"]:hover {
                background-color: #ffc107;
            }
            .slogan {
                font-size: 22px;
                margin-top: 15px;
                font-weight: bold;
                text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
                color: #ffcc00;
            }
        </style>
    </head>
    <body>
        <main> 
            <div class="container">
                <h1>Welcome to Coffee Puppy Store!</h1>
                <img src="Icon/CoffeePuppyStore.jpg" alt="Welcome Icon"><br/>
                <form action="MainController" method="get">
                    <input type="submit" name="btn" value="Continue" />
                </form>
                <p class="slogan">Enjoy our freshly brewed coffee and pastries.</p>
            </div>
        </main>
        <%@include file="footer.jsp" %>
    </body>
</html>
