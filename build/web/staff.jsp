<%@page import="java.io.IOException"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.File"%>
<%@page import="javax.security.auth.login.Configuration"%>
<%@page import="java.nio.file.FileSystem"%>
<%@page import="java.net.URI"%>
<%@page import="java.nio.file.Path"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="dto.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Admin" %>
<%@ page import="java.time.LocalTime" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đơn Hàng của Nhân Viên</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f9f9f9;
                margin: 0;
                padding: 20px;
            }
            h1 {
                text-align: center;
                color: #333;
                margin-bottom: 20px;
            }
            .status-message {
                text-align: center;
                font-weight: bold;
                font-size: 18px;
                margin: 20px 0;
            }
            .off-hours {
                color: #FF0000; /* Đỏ cho ngoài giờ làm việc */
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            th, td {
                border: 1px solid #ccc;
                padding: 10px;
                text-align: center;
            }
            th {
                background-color: #f2f2f2;
            }
            tr:nth-child(even) {
                background-color: #f9f9f9;
            }
            .update-button {
                padding: 5px 10px;
                background-color: #4CAF50; /* Xanh lá */
                color: white;
                border: none;
                cursor: pointer;
            }
            .update-button:hover {
                background-color: #45a049; /* Xanh lá đậm */
            }
        </style>
    </head>
    <body>
        <%
            Admin admin = (Admin) request.getAttribute("staff");
            ArrayList<Order> orderList = (ArrayList<Order>) request.getAttribute("orderList");
            String phone_guest = (String) session.getAttribute("guest");

            // Lấy thời gian hiện tại
            LocalTime currentTime = LocalTime.now();
            LocalTime startTime = LocalTime.of(9, 0); // 9:00 sáng
            LocalTime endTime = LocalTime.of(17, 0);  // 5:00 chiều

            // Kiểm tra xem có trong giờ làm việc không
            boolean isWorkingHours = !currentTime.isBefore(startTime) && !currentTime.isAfter(endTime);
        %>
        <%
            // Define the file path to save the TXT file
            String txtFilePath = application.getRealPath("/") + "order_data.txt";
            File txtFile = new File(txtFilePath);

            // Write data to the TXT file
            try (FileWriter writer = new FileWriter(txtFile)) {
                // Write header
                writer.write("STT\tSố Điện Thoại\tSố Lượng\tThời Gian Đặt Hàng\tTổng Giá\tTrạng Thái\tSố Bàn\n");

                if (orderList != null) {
                    int orderNumber = 1; // Khởi tạo số thứ tự đơn hàng
                    for (Order order : orderList) {
                        String phone = order.getPhone().equalsIgnoreCase("none")
                                ? (phone_guest == null ? "Khách" : phone_guest) : order.getPhone();
                        int orderTotal = order.getTotal_amount();

                        // Write each order detail to the file
                        writer.write(orderNumber++ + "\t" + phone + "\t" + order.getQuanlity() + "\t"
                                + order.getOrderDate() + "\t" + orderTotal + " VND\t"
                                + order.getOrder_status() + "\t" + order.getTable_number() + "\n");
                    }
                } else {
                    writer.write("Không có đơn hàng nào.\n");
                }
            } catch (IOException e) {
                e.printStackTrace(); // Handle exceptions properly in production code
            }
        %>

        <h1>Chào mừng nhân viên, <%= (admin != null ? admin.getFullName() : "Nhân viên")%>!</h1>

        <!-- Trạng thái giờ làm việc -->
        <div class="status-message <%= isWorkingHours ? "" : "off-hours"%>">
            <%
                if (isWorkingHours) {
                    out.println("Bạn đang trong giờ làm việc.");
                } else {
                    out.println("Bạn đang ngoài giờ làm việc.");
                }
            %>
        </div>

        <h2>Giờ Làm Việc</h2>
        <p>Giờ Bắt Đầu: 9:00 Sáng</p>
        <p>Giờ Kết Thúc: 5:00 Chiều</p>

        <table>
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Số Điện Thoại</th>
                    <th>Số Lượng</th>
                    <th>Thời Gian Đặt Hàng</th>
                    <th>Tổng Giá</th>
                    <th>Trạng Thái</th>
                    <th>Số Bàn</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Map để lưu tổng số tiền theo từng số điện thoại
                    HashMap<String, Integer> phoneTotalMap = new HashMap<>();

                    // Tính tổng số tiền cho từng số điện thoại
                    if (orderList != null) {
                        int orderNumber = 1; // Khởi tạo số thứ tự đơn hàng
                        for (Order order : orderList) {
                            String phone = order.getPhone().equalsIgnoreCase("none")
                                    ? (phone_guest == null ? "Khách" : phone_guest) : order.getPhone();
                            int orderTotal = order.getTotal_amount();
                            phoneTotalMap.put(phone, phoneTotalMap.getOrDefault(phone, 0) + orderTotal);
                %>
                <tr>
                    <td><%= orderNumber++%></td>
                    <td><%= phone%></td>
                    <td><%= order.getQuanlity()%></td>
                    <td><%= order.getOrderDate()%></td>
                    <td><%= orderTotal%> VND</td>
                    <td><%= order.getOrder_status()%></td>
                    <td><%= order.getTable_number()%></td>
                    <td>
                        <form action="MainController" method="get">
                            <input type="hidden" name="orderId" value="<%= order.getOrderID()%>">
                            <select name="status">
                                <option value="Pending" <%= order.getOrder_status().equals("Pending") ? "selected" : ""%>>Đang Chờ</option>
                                <option value="Completed" <%= order.getOrder_status().equals("Completed") ? "selected" : ""%>>Đã Hoàn Thành</option>
<!--                                <option value="Cancelled" <%= order.getOrder_status().equals("Cancelled") ? "selected" : ""%>>Đã Hủy</option>-->
                            </select>
                            <button type="submit" name="btn" value="Update" class="update-button">Cập Nhật</button>
                        </form>
                    </td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="8">Không có đơn hàng nào.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="6">Tổng Hóa Đơn Theo Số Điện Thoại</td>
                    <td colspan="2">
                        <ul>
                            <%
                                for (String phone : phoneTotalMap.keySet()) {
                            %>
                            <li><%= phone%>: <%= phoneTotalMap.get(phone)%> VND</li>
                                <%
                                    }
                                %>
                        </ul>
                    </td>
                </tr>
            </tfoot>
        </table>
    </body>
</html>
