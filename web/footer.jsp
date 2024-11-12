<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            footer {
                background-color: #333; /* Dark background */
                color: #ffffff;
                text-align: center;
                padding: 15px; /* Padding for footer */
                width: 100%; /* Full width */
                margin-top: 20px; /* Add space above footer */
            }

            footer a {
                color: white;
                text-decoration: none;
                margin: 0 10px;
            }

            .social-icons {
                margin: 10px 0;
            }

            .social-icons img {
                width: 40px; /* Smaller size for social icons */
                margin: 0 5px; /* Add spacing between icons */
            }

            /* Added styles for the buttons */
            footer h4 button {
                background-color: white; /* White background */
                color: #333; /* Dark text */
                border: none; /* Remove default border */
                padding: 10px 20px; /* Add padding */
                margin: 0 5px; /* Add margin between buttons */
                cursor: pointer; /* Indicate it's clickable */
                border-radius: 5px; /* Add rounded corners */
            }
        </style>
    </head>
    <body>
        <footer>
            <div class="b">
                <p>&copy; <span id="year"></span> Coffee Puppy Store. All rights reserved.</p>
                <h4>
                    <form action="MainController" method="get">
                        <button type="submit" name="btn" value="Privacy">Privacy Policy</button>
                        <button type="submit" name="btn" value="Terms">Terms of Service</button>
                        <button type="submit" name="btn" value="Contact">Contact Us</button>
                    </form>
                </h4>


                <!-- Social media icons -->
                <div class="social-icons">
                    <a href="https://facebook.com" target="_blank">
                        <img src="Icon/facebook.png" alt="Facebook">
                    </a>
                    <a href="https://twitter.com" target="_blank">
                        <img src="Icon/twitter.png" alt="Twitter">
                    </a>
                    <a href="https://instagram.com" target="_blank">
                        <img src="Icon/Instagram.png" alt="Instagram"> <!-- Fixed alt to lowercase -->
                    </a>
                </div>
            </div>
        </footer>

        <script>
            // Dynamically set the current year in the footer
            document.getElementById('year').textContent = new Date().getFullYear();
        </script>
    </body>
</html>