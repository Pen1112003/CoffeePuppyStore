<%-- 
    Document   : search
    Created on : Oct 23, 2024, 11:13:02 AM
    Author     : penpen1112003
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <style>
            .search-container {
                text-align: center;
                margin: 50px auto;
                max-width: 400px;
            }

            input[type="text"] {
                padding: 10px;
                width: 70%;
                font-size: 1em;
                border: 2px solid #8B4513;
                border-radius: 5px;
                margin-right: 10px;
            }

            button {
                padding: 10px 20px;
                background-color: #8B4513;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            button:hover {
                background-color: #5a3410;
            }

        </style>
    </head>
    <body>
        <%
            String name = (String) request.getAttribute("name");
        %>
        <div class="search-container">
            <form action="MainController" style="display: flex; align-items: center;" method="get">
                <input type="text" name="searchQuery" placeholder="Enter search term..." required style="flex-grow: 1; padding: 10px; margin-right: 10px;" value="<%= (name == null ? "" : name)%>" />
                <button type="submit" name="btn" value="Search" style="padding: 10px 20px;">Search</button>
            </form>

        </div>

    </body>
</html>
