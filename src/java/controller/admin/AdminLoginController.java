/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license 
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template 
 */
package controller.admin;

import custome.FileGenerator;
import dao.AdminDao;
import dto.Admin;
import dto.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * AdminLoginController handles the login and routing of Admin users.
 *
 * @author penpen1112003
 */
public class AdminLoginController extends HttpServlet {

    private static final String BOSS_PAGE = "boss.jsp";
    private static final String STAFF_PAGE = "staff.jsp";
    private static final String LOGIN_PAGE = "admin.jsp";
    private static final Logger LOGGER = Logger.getLogger(AdminLoginController.class.getName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("txtEmail");
        String pass = request.getParameter("txtPassword");
        String link = LOGIN_PAGE;

        // Input validation
        if (email == null || email.isEmpty() || pass == null || pass.isEmpty()) {
            request.setAttribute("error", "Error: Email and Password cannot be empty.");
            request.getRequestDispatcher(link).forward(request, response);
            return;
        }

        try (PrintWriter out = response.getWriter()) {
            AdminDao dao = new AdminDao();
            Admin admin = dao.loginAdmin(email, pass);
            ArrayList<Order> orderlist = dao.getOrder();

            if (admin != null && admin.isStatus()) {
                link = STAFF_PAGE;
                request.setAttribute("staff", admin);
                FileGenerator.main(new String[]{});

            } else if (admin != null) {
                link = BOSS_PAGE;
                request.setAttribute("boss", admin);
            } else {
                request.setAttribute("error", "Error: Invalid Password or Email. Please enter again!");
            }

            HttpSession session = request.getSession();
            session.setAttribute("login", admin);
            request.setAttribute("orderList", orderlist);
            request.getRequestDispatcher(link).forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Admin Login Controller handles the login and role-based redirection of admin users.";
    }
}
