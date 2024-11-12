<%--<!-- comment -->
    member
    Penpen
--%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Order Form</title>
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
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            main {
                background-color: white;
                padding: 2em;
                border-radius: 8px;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
                max-width: 400px;
                width: 100%;
            }
            h1 {
                text-align: center;
                color: #333;
                font-size: 1.5em;
                margin-bottom: 1.5em;
            }
            form {
                display: flex;
                flex-direction: column;
            }
            input[type="text"], input[type="tel"], input[type="email"], select {
                padding: 12px;
                margin-bottom: 1em;
                border: 1px solid #ddd;
                border-radius: 4px;
                font-size: 1em;
                outline: none;
                transition: border-color 0.3s;
            }
            input[type="text"]:focus, input[type="tel"]:focus, input[type="email"]:focus, select:focus {
                border-color: #007bff;
            }
            input[type="submit"] {
                padding: 12px;
                background-color: #007bff;
                color: white;
                border: none;
                border-radius: 4px;
                font-size: 1em;
                cursor: pointer;
                transition: background-color 0.3s;
            }
            input[type="submit"]:hover {
                background-color: #0056b3;
            }
            p {
                margin-top: 1em;
                color: #666;
                text-align: center;
            }
            .error{
                color: red;
                text-align: center;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>

        <main>
            <div class="error">
                <%
                    String error = (String) request.getAttribute("already");
                    if (error != null) {
                        out.print(error);
                    }
                %>
            </div>
            <h1>Order Your Drinks and Foods</h1>
            <form action="MainController" method="get">
                <input type="tel" name="txtPhone" placeholder="Your phone number" maxlength="10" required pattern="\d{10}">
                <input type="text" name="txtName" placeholder="Your full name" required>
                <input type="email" name="txtEmail" placeholder="Your email" required>
                <label for="membership">Become a member?</label>
                <select name="membership" id="membership">
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
                </select>
                <input type="submit" name="btn" value="Go"/>
            </form>
            <p>Already a member? <a href="MainController?btn=Login">Sign in here</a>.</p>
        </main>

    </body>

</html>
