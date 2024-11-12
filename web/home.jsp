<%@page import="dto.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Item"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
        <jsp:include page="header.jsp"/> <!-- Including the header -->
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                display: flex;
                flex-direction: column;
                align-items: center;
                background-color: #f4f4f4; /* Added background for better contrast */
            }

            main {
                display: flex;
                flex-wrap: wrap;
                justify-content: center;
                margin: 20px;
                width: 100%;
                max-width: 1200px;
            }

            .item {
                border: 1px solid #ccc;
                border-radius: 5px;
                padding: 10px;
                margin: 15px;
                text-align: center;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                background-color: #fff;
                width: 250px; /* Added fixed width for better alignment */
                transition: background-color 0.3s ease, transform 0.3s ease; /* Smooth hover effect */
            }

            .item img {
                width: 200px;
                height: 200px;
                object-fit: cover;
                margin-bottom: 10px;
            }

            .item:hover {
                background-color: #8B4513;
                color: white;
                transform: translateY(-5px);
            }

            main h2 {
                width: 100%;
                text-align: center;
                margin-bottom: 20px;
                font-size: 1.5em;
                color: #333;
            }

            form input[type="number"] {
                width: 60px;
                padding: 5px;
                margin-bottom: 10px;
            }

            form input[type="submit"] {
                background-color: #007bff;
                color: white;
                border: none;
                padding: 5px 15px;
                cursor: pointer;
                border-radius: 3px;
                transition: background-color 0.3s ease;
            }

            form input[type="submit"]:hover {
                background-color: #0056b3;
            }

        </style>

    </head>
    <body>
        <%
            ArrayList<Item> list = (ArrayList<Item>) request.getAttribute("itemList");

            // Redirect if item list is empty or null
            if (list == null || list.isEmpty()) {
                response.sendRedirect("MainController");
                return;
            }

            Member member = (Member) session.getAttribute("memberInfor");
            Member guest = (Member) session.getAttribute("guest");
        %>

        <h2>
            <% if (member != null) {%>
            Welcome, <%= member.getFullName()%>! Please place your order below.
            <% } else if (guest != null) {%>
            Welcome, <%= guest.getFullName()%>! Please place your order below.
            <% } %>
        </h2>

        <main>
            <jsp:include page="search.jsp"/>
        </main>
        <main>
            <% for (Item item : list) {
                    String previousQuantity = (String) request.getAttribute("quantity");%>

            <div class="item">
                <img src="<%= item.getImage()%>" alt="Item Image" />
                <br /><strong><%= item.getItemName()%></strong>
                <br />Price: <%= item.getPrice()%> VND
                <form action="MainController" method="get" >
                    <input type="hidden" name="idOrder" value="<%= item.getIdItem()%>" />
                    <input type="number" name="quantity" min="1" max="10" 
                           value="<%= (previousQuantity != null) ? previousQuantity : "1"%>" />
                    <% if (member != null) {%>
                    <input type="hidden" name="memberPhone" value="<%= member.getPhone()%>" />
                    <input type="hidden" name="name" value="<%= member.getFullName()%>" />
                    <% } else if (guest != null) {%>
                    <input type="hidden" name="guestPhone" value="<%= guest.getPhone()%>" />
                    <input type="hidden" name="name" value="<%= guest.getFullName()%>" />
                    <% } %>
                    <input type="submit" name="btn" value="Order" />
                </form>
            </div>
            <% }%>
        </main>

        <jsp:include page="footer.jsp"/>
    </body>
</html>
