package controller.status;

import dao.OrderDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller to handle updating order status.
 * Author: penpen1112003
 */
public class UpdateStatusController extends HttpServlet {

    private final String STAFF_PAGE = "staff.jsp";
    private final String ADMIN_PAGE = "admin.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String orderId = request.getParameter("orderId");
        String status = request.getParameter("status");
        OrderDao orderDAO = new OrderDao();
        String link = STAFF_PAGE; // Set default page; update if needed based on conditio
        try {
            boolean updateSuccess = orderDAO.updateOrderStatus(orderId, status);
            if (updateSuccess) {
                link = ADMIN_PAGE; 
            } else {
                response.getWriter().println("<h2>Failed to update order status.</h2>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>An error occurred while updating the order status. Please try again later.</h2>");
        }
        
        request.getRequestDispatcher(link).forward(request, response);
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
        return "Servlet for updating order status";
    }
}
