<%-- 
    Document   : contact
    Created on : Oct 14, 2024, 2:07:28 PM
    Author     : penpen1112003
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Contact Us - Coffee Puppy Store</title>

        <!-- Google Analytics -->
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
                margin: 0;
                padding: 0;
                background-color: white;
                display: flex;
                flex-direction: column;
                align-items: center;
            }
            main {
                margin: 30px;
                padding: 30px;
                max-width: 600px;
                width: 100%;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }
            h1, h2 {
                color: #8B4513;
            }
            input, textarea {
                width: 100%;
                padding: 10px;
                margin: 10px 0;
                border: 1px solid #ccc;
                border-radius: 5px;
            }
            button {
                background-color: #8B4513;
                color: white;
                padding: 10px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }
            button:hover {
                background-color: #6f3e11;
            }
            p {
                margin: 10px 0;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <main>
            <h2>Contact Us</h2>
            <p>If you have any questions or inquiries, please fill out the form below or reach us directly using the contact information provided.</p>

            <!-- Form to send message via EmailServlet -->
            <form action="MainController" method="post">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>

                <label for="message">Message:</label>
                <textarea id="message" name="message" rows="4" required></textarea>

                <button type="submit" name="btn" value="Email">Send Message</button>
            </form>

            <h2>Contact Information</h2>
            <p><strong>Email:</strong> <a href="mailto:nguyenductuan11012003@gmail.com">Nguyen Duc Tuan - nguyenductuan11012003@gmail.com</a></p>
            <p><strong>Phone:</strong> 0992374665</p>
            <p><strong>Address:</strong> 54, 1ST, Tang Nhon Phu B, Thu Duc City, Ho Chi Minh City</p>
        </main>

        <jsp:include page="footer.jsp"/>
    </body>
</html>
