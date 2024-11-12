package controller.wishList;

import dao.OrderDao;
import dto.Member;
import dto.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ConfirmBookingController handles the confirmation of booking orders.
 *
 */
public class ConfirmBookingController extends HttpServlet {

    private final String WISH_LIST_PAGE = "viewWishList.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        int table = Integer.parseInt(request.getParameter("tableNumber"));
        HttpSession session = request.getSession();

        Member member = (Member) session.getAttribute("memberInfor");
        OrderDao orderDao = new OrderDao();
        HashMap<Integer, Order> orderList = (HashMap<Integer, Order>) session.getAttribute("order");

        if (orderList != null) {
            ArrayList<Order> orders = new ArrayList<>(orderList.values());
            int memberId = (member != null) ? member.getMember_id() : 0;

            // Submit all orders in a single batch transaction
            boolean success = orderDao.submitOrders(orders, memberId, table);

            if (success) {
                request.setAttribute("success", "Order placed successfully.");
            } else {
                request.setAttribute("error", "There was an issue placing the order.");
            }
            request.getRequestDispatcher(WISH_LIST_PAGE).forward(request, response);

        } else {
            request.setAttribute("error", "No orders found to place.");
            request.getRequestDispatcher(WISH_LIST_PAGE).forward(request, response);
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
        return "Servlet for confirming bookings in the wishlist";
    }
}
