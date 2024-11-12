package controller.delete;

import dto.Order;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<Integer, Order> orderList = (HashMap<Integer, Order>) session.getAttribute("order");
        response.setContentType("text/html;charset=UTF-8");
        if (orderList != null && request.getParameter("product_id") != null) {

            try {
                int orderID = Integer.parseInt(request.getParameter("product_id"));
                for (Order i : orderList.values()) {
                    if(i.getProduct_id() == orderID){
                        orderList.values().remove(i);
                        break;
                    }
                }
                session.setAttribute("order", orderList);
                request.getRequestDispatcher("viewWishList.jsp").forward(request, response);

            } catch (NumberFormatException e) {
                response.getWriter().println("Invalid order ID format.");
            }
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
        return "Delete order by orderID from the session order list.";
    }
}
