<%-- 
    Document   : viewWishList
    Created on : Oct 15, 2024, 10:57:29 PM
    Author     : penpen1112003
--%>

<%@page import="dao.ItemDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Item"%>
<%@page import="java.util.HashMap"%>
<%@page import="dto.Order"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking and Bill Summary</title>
        <style>
            table {
                width: 60%;
                margin: 20px auto;
                border-collapse: collapse;
            }
            table, th, td {
                border: 1px solid black;
                text-align: center;
                padding: 8px;
            }
            th {
                background-color: #f2f2f2;
            }
            tfoot {
                font-weight: bold;
            }
            main {
                padding: 20px;
                text-align: center;
            }
            .table-selection {
                margin: 20px auto;
                width: 60%;
                text-align: left;
            }
            .table-selection select {
                width: 100%;
                padding: 10px;
            }
            .status {
                margin-top: 10px;
                color: green;
            }
            .occupied {
                color: red;
            }
        </style>
        <%@include file="header.jsp" %>

    </head>
    <body>
        <%
            HashMap<Integer, Order> orderList = (HashMap<Integer, Order>) session.getAttribute("order");
            String name = (String) session.getAttribute("name");
            int totalBill = 0;
            ItemDao itemDao = new ItemDao();
            ArrayList<Item> itemList = itemDao.getAllItems();
            String message = (String) request.getAttribute("success");
        %>
        <main>
            <h2><%= (message != null && !message.isEmpty()) ? message : "" %></h2>

            <h1>Your Booking Details for <%= name%>, We're Excited to Serve You!</h1>
            <table>
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (orderList != null && !orderList.isEmpty()) {
                            int orderNumber = 1;
                            for (Integer id : orderList.keySet()) {
                                Order order = orderList.get(id);
                                int orderTotal = order.getTotal_amount();
                                totalBill += orderTotal;
                    %>
                    <tr>     
                        <td><%= orderNumber++%></td>
                        <td><%= order.getProductName()%></td>
                        <td>
                            <form action="MainController" method="get" >
                                <input type="number" name="quantity" min="1" value="<%= order.getQuanlity()%>"/>
                                <input type="hidden" name="product_id" value="<%=order.getProduct_id()%>">
                                <button type="submit" name="btn" value="UpdateQuantity" style="font-size: small; padding: 5px 10px;">Yes</button>
                            </form>
                        </td>
                        <td><%= order.getPrice()%> VND</td>
                        <td><%= orderTotal%> VND</td>
                        <td>
                            <form action="MainController" method="get" >
                                <button type="submit" name="btn" value="Remove" style="font-size: small; padding: 5px 10px;">Remove</button>
                                <input type="hidden" name="product_id" value="<%=order.getProduct_id() %>">
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    } else { %>
                    <tr>
                        <td colspan="6">No orders available.</td>
                    </tr>
                    <% }%>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="5">Total Bill</td>
                        <td><%= totalBill%> VND</td>
                    </tr>
                </tfoot>
            </table>

            <div class="table-selection">
                <h2>Select a Table to Sit</h2>
                <form action="MainController" method="get">
                    <label for="tableNumber">Choose your table:</label>
                    <select name="tableNumber" id="tableNumber">
                        <!-- Dynamic table options -->
                        <% for (int i = 1; i <= 10; i++) { %>
                            <option name="table" value="<%= i %>" <%= Integer.toString(i).equals(request.getAttribute("selectedTable")) ? "selected" : ""%>>Table <%= i %> (Available)</option>
                        <% } %>
                    </select>
                    <br><br>
                    <button type="submit" name="btn" value="Confirm_Booking"> Confirm Booking </button>
                </form>

                <div class="status">
                    <% String selectedTable = (String) request.getAttribute("selectedTable");%>
                    <p>
                        <%= selectedTable != null ? "You have selected Table " + selectedTable : "<span class='occupied'>No table selected yet!</span>"%>
                    </p>
                </div>
            </div>
        </main>
        <%@include file="footer.jsp" %>
    </body>
</html>
