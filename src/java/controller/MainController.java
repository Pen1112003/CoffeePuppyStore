package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

    // Define constants for page navigation
    private static final String WELCOME_PAGE = "welcome.jsp";
    private static final String LOGIN_PAGE = "login.jsp";
    private static final String MEMBER_PAGE = "member.jsp";
    private static final String GET_ALL_CONTROLLER = "Get_All_Item_Controller";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String ORDER_CONTROLLER = "OrderController";
    private static final String WISH_LIST_PAGE = "viewWishList.jsp";
    private static final String CONFIRM_BOOKING_CONTROLLER = "ConfirmBookingController";
    private static final String SEARCH_CONTROLLER = "SearchController";
    private static final String EMAIL_CONTROLLER = "EmailServlet";
    private static final String DELETE_CONTROLLER = "DeleteController";
    private static final String UPDATE_CONTROLLER = "UpdateController";
    private static final String ADMIN_PAGE = "admin.jsp";
    private static final String ADMIN_CONTROLLER = "AdminLoginController";
    private static final String UPDATE_STATUS_CONTROLLER = "UpdateStatusController";
    private static final String PAYMENT_PAGE = "payment.jsp";
    private  static final String LOGOUT_CONTROLLER = "LogoutController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String btn = request.getParameter("btn");
        String link = WELCOME_PAGE; // Default page

        try {
            if (btn != null) {
                // Using if-else statements for navigation
                if (btn.equalsIgnoreCase("Continue")) {
                    link = MEMBER_PAGE;
                } else if (btn.equalsIgnoreCase("Go") || btn.equalsIgnoreCase("Home")) {
                    link = GET_ALL_CONTROLLER;
                } else if (btn.equalsIgnoreCase("Login")) {
                    link = LOGIN_PAGE;
                } else if (btn.equalsIgnoreCase("Next")) {
                    link = LOGIN_CONTROLLER;
                } else if (btn.equalsIgnoreCase("Order")) {
                    link = ORDER_CONTROLLER;
                } else if (btn.equalsIgnoreCase("viewWishList")) {
                    link = WISH_LIST_PAGE;
                } else if (btn.equalsIgnoreCase("Confirm_Booking")) {
                    link = CONFIRM_BOOKING_CONTROLLER;
                } else if (btn.equalsIgnoreCase("Search")) {
                    link = SEARCH_CONTROLLER;
                } else if (btn.equalsIgnoreCase("Terms")) {
                    link = "terms.jsp";
                } else if (btn.equalsIgnoreCase("Contact")) {
                    link = "contact.jsp";
                } else if (btn.equalsIgnoreCase("About")) {
                    link = "about.jsp";
                } else if (btn.equalsIgnoreCase("Privacy")) {
                    link = "privacy.jsp";
                } else if (btn.equalsIgnoreCase("Email")) {
                    link = EMAIL_CONTROLLER;
                } else if (btn.equalsIgnoreCase("Remove")) {
                    link = DELETE_CONTROLLER;
                } else if (btn.equalsIgnoreCase("UpdateQuantity")) {
                    link = UPDATE_CONTROLLER;
                }else if (btn.equalsIgnoreCase("Admin")){
                    link = ADMIN_CONTROLLER;
                }else if (btn.equalsIgnoreCase("Update")){
                    link = UPDATE_STATUS_CONTROLLER;
                }else if(btn.equalsIgnoreCase("Payment")){
                    link = PAYMENT_PAGE;
                }else if(btn.equalsIgnoreCase("Logout")){
                    link = LOGOUT_CONTROLLER;
                }else {
                    link = WELCOME_PAGE;
                }
            }
            request.getRequestDispatcher(link).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); // For debugging; consider using a logging framework
            throw new ServletException("Error forwarding to " + link, e);
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
        return "MainController handles navigation between pages and controllers.";
    }
}
