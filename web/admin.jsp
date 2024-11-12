<%@page import="dto.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Coffee Puppy Store Official</title>
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
            input[type="password"], input[type="text"], select {
                padding: 12px;
                margin-bottom: 1em;
                border: 1px solid #ddd;
                border-radius: 4px;
                font-size: 1em;
                outline: none;
                transition: border-color 0.3s;
            }
            input[type="password"]:focus, input[type="text"]:focus, select:focus {
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
            .error {
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
                    String error = (String) request.getAttribute("error");
                    if (error != null) {
                        out.print(error);
                    }
                    Admin admin = (Admin) session.getAttribute("login");
                    if (admin == null) {
                        admin = new Admin(); // Initialize to avoid NullPointerException
                    }
                %>
            </div>
            <h1>Coffee Puppy Store Official</h1>
            <form action="MainController" method="post">
                <input type="text" name="txtEmail" placeholder="Your email" required value="<%= admin.getEmail() == null ? "" : admin.getEmail()%>" />
                <input type="password" name="txtPassword" placeholder="Your password" required>
                <input type="submit" name="btn" value="Admin"/>
            </form>
        </main>

    </body>
</html>
