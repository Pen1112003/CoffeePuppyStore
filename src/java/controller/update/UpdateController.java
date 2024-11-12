package controller.update;

import dto.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        HashMap<Integer, Order> orderList = (HashMap<Integer, Order>) session.getAttribute("order");

        String quantityStr = request.getParameter("quantity");
        String idStr = request.getParameter("product_id");

        try (PrintWriter out = response.getWriter()) {
            if (orderList != null && idStr != null && quantityStr != null) {
                int orderID = Integer.parseInt(idStr);
                int quantity = Integer.parseInt(quantityStr);
                for (Order order : orderList.values()) {
                    if (order.getProduct_id() == orderID) {
                        order.setQuanlity(quantity);
                        order.setTotal_amount(quantity*order.getPrice());
                        break;
                    }
                }

                session.setAttribute("order", orderList);
                request.getRequestDispatcher("viewWishList.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid input. Please enter numeric values for quantity and order ID.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Update order quantity in the session order list.";
    }
}
