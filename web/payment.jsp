<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Payment Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f4;
                padding: 20px;
                margin: 0;
            }
            .container {
                max-width: 400px;
                margin: auto;
                background: #fff;
                padding: 30px;
                border-radius: 8px;
                box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            }
            h2 {
                text-align: center;
                color: #333;
                margin-bottom: 20px;
            }
            label {
                margin: 10px 0 5px;
                display: block;
                font-weight: bold;
            }
            input[type="text"],
            input[type="number"],
            select {
                width: 100%;
                padding: 10px;
                margin: 5px 0 20px;
                border: 1px solid #ccc;
                border-radius: 4px;
                font-size: 16px;
            }
            button {
                background-color: #28a745;
                color: white;
                border: none;
                padding: 10px;
                border-radius: 5px;
                cursor: pointer;
                width: 100%;
                font-size: 16px;
                transition: background-color 0.3s ease;
            }
            button:hover {
                background-color: #218838;
            }
            .payment-method {
                display: flex;
                align-items: center;
                margin: 10px 0;
            }
            .payment-method i {
                margin-right: 10px;
                font-size: 24px;
            }
            .footer {
                text-align: center; /* Centers the text horizontally */
                margin-top: 20px; /* Optional: space above the footer */
                font-size: 14px; /* Optional: adjust font size */
                color: #777; /* Optional: change text color */
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Payment</h2>
            <form action="MainController" method="post">
                <label for="amount">Payment Amount (VND):</label>
                <input type="number" id="amount" name="amount" required>
                <label for="paymentMethod">Payment Method:</label>
                <div class="payment-method">
                    <input type="radio" id="creditCard" name="paymentMethod" value="creditCard" required>
                    <i class="fas fa-credit-card"></i>
                    <label for="creditCard">Credit Card</label>
                </div>
                <div class="payment-method">
                    <input type="radio" id="paypal" name="paymentMethod" value="paypal" required>
                    <i class="fab fa-paypal"></i>
                    <label for="paypal">PayPal</label>
                </div>
                <div class="payment-method">
                    <input type="radio" id="bankTransfer" name="paymentMethod" value="bankTransfer" required>
                    <i class="fas fa-university"></i>
                    <label for="bankTransfer">Bank Transfer</label>
                </div>
                <button type="submit" >Proceed to Payment</button><!-- comment -->
                
            </form><br><!-- comment -->
            
            <form action="MainController">
                <button type="submit" name="btn"  value="Logout">Logout </button><!-- comment -->
            </form>
            
            <div class="footer">
                <p>&copy; 2024 Coffee Puppy Store. All rights reserved.</p>
            </div>
        </div>
    </body>
</html>
