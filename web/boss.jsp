<%-- 
    Document   : boss
    Created on : Oct 30, 2024, 12:53:11 PM
    Author     : penpen1112003
--%>

<%@page import="dto.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Admin admin = (Admin) request.getAttribute("boss");
        %>
        <h1>Hello Boss <%= admin.getFullName() %></h1>
    </body>
</html>
