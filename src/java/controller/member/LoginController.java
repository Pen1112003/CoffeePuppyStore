package controller.member;

import dao.MemberDao;
import dto.Member;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

    private final String LOGIN_PAGE = "login.jsp";
    private final String HOME = "MainController?btn=Home";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String link = LOGIN_PAGE;
        String phone = request.getParameter("txtPhone");
        HttpSession session = request.getSession();
        MemberDao dao = new MemberDao();
        Member member = dao.getMembers(phone);
        if (member.getPhone() != null) {
            session.setAttribute("memberInfor", member);
            link = HOME;
        } else {
            request.setAttribute("error", "Your phone number is incorrect. Please try again!");
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
        return "LoginController handles member login.";
    }
}
