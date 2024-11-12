<%-- 
    Document   : about
    Created on : Oct 14, 2024, 2:12:44 PM
    Author     : penpen1112003
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>About Us - Coffee Puppy Store</title>
       
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0px;
                padding: 0px;
                display: flex;
                flex-direction: column;
                align-items: center;
            }
            main{
                margin: 30px;

                padding: 30px;
            }

            h1, h2 {
                color: #8B4513; /* Coffee-like brown */
            }
            p {
                line-height: 1.6; /* Improve readability */
                margin: 10px 0;
            }
            img {
                max-width: 100%; /* Responsive image */
                height: auto; /* Maintain aspect ratio */
                border-radius: 5px; /* Slightly rounded corners */
            }
            .mission {
                background-color: white; /* White background for mission section */
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0,0,0,0.1); /* Subtle shadow */
                margin-bottom: 20px; /* Space below the mission section */
            }
        </style>
        <jsp:include page="header.jsp"/>

    </head>
    <body>

        <main>
            <h2>About Us</h2>
            <div class="mission">
                <h2>Our Mission</h2>
                <p>At Coffee Puppy Store, our mission is to provide the highest quality coffee and pet products to enhance the lives of both coffee lovers and their furry companions. We believe in the joy that comes from sharing a great cup of coffee while spending time with your beloved pets.</p>
            </div>

            <h2>What We Offer</h2>
            <p>We offer a wide range of premium coffee blends sourced from the finest coffee-growing regions around the world. In addition, we provide an assortment of pet-friendly products that ensure your pets enjoy a delightful experience alongside your coffee ritual.</p>

            <h2>Our Story</h2>
            <p>Founded in 2024, Coffee Puppy Store started as a small coffee shop with a unique twist. Our love for coffee and animals inspired us to create a space where pet owners could enjoy their favorite brews while their pets were welcomed with open arms.</p>

            <h2>Join Us</h2>
            <p>We invite you to visit our store, explore our products, and become part of our community. Whether you're a coffee aficionado or a pet lover, there's something for everyone at Coffee Puppy Store!</p>
        </main>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
