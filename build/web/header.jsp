<%-- 
    Document   : header
    Created on : Oct 12, 2024, 2:42:18 PM
    Author     : penpen1112003
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Coffee Puppy Store</title>
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
            /* Basic styles for the header */
            body {
                font-family: Arial, sans-serif;
                margin: 0; /* Remove default margin */
            }
            header {
                background-color: blanchedalmond;
                color: #8B4513; /* Change text color to a coffee-like brown */
                padding: 20px;
                display: flex; /* Use flexbox for layout */
                align-items: center; /* Center items vertically */
                justify-content: space-between; /* Space between image+title and nav */
                width: 100%;
            }
            h1 {
                margin: 0; /* Remove default margin */
                padding-left: 20px; /* Add padding to separate from image */
                font-size: 2em; /* Adjust title font size */
                white-space: nowrap; /* Prevent line break */
            }
            .logo img {
                width: 100px; /* Set image width */
                height: auto; /* Maintain aspect ratio */
                border-radius: 20px; /* Rounded corners */
                padding-left: 20px; /* Add space between image and text */
            }

            nav {
                flex-grow: 1; /* Allow navigation to grow and take available space */
                display: flex; /* Flexbox for nav items */
                justify-content: center; /* Center navigation items */
            }
            nav form {
                display: flex; /* Align buttons horizontally */
            }

            button {
                color: #8B4513; /* Match button text color to header text */
                padding: 14px 20px;
                text-decoration: none;
                text-align: center;
                margin: 0 10px;
                border: 1px solid transparent; /* Add border for effect */
                transition: background-color 0.3s, border-color 0.3s; /* Smooth transition */
                background-color: transparent; /* Background color */
                cursor: pointer; /* Change cursor on hover */
                font-weight: bold; /* Làm đậm văn bản */
                font-size: 1em; /* Tăng kích thước văn bản lên 1em */
                border-radius: 5px; /* Bo tròn góc nút */
            }
            button:hover {
                background-color: #45a049; /* Màu nền khi di chuột */
                border-color: #45a049; /* Màu viền khi di chuột */
            }
        </style>
    </head>
    <body>

        <header>
            <div style="display: flex; align-items: center;" class="logo">
                <img src="Icon/CoffeePuppyStore.jpg" alt="Coffee Puppy Store"/> <!-- Image on the left -->
                <h1>Coffee Puppy Store</h1> <!-- Title next to the image -->
            </div>
            <nav>
                <form  action="MainController" method="get"> <!-- Thay đổi action tùy thuộc vào cách xử lý -->
                    <button type="submit" name="btn" value="Home">Home</button>
                    <button type="submit" name="btn" value="viewWishList">Wishlist</button>
                    <button type="submit" name="btn" value="About">About Us</button>
                    <button type="submit" name="btn" value="Payment">Payment</button> <!-- Điều chỉnh dựa trên xác thực -->
                </form>
            </nav>
        </header>

    </body>
</html>
