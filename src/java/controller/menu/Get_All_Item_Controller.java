package controller.menu;

import dao.ItemDao;
import dao.MemberDao;
import dto.Item;
import dto.Member;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Controller to retrieve all items from the database and forward to the home
 * page.
 *
 * Author: penpen1112003
 */
public class Get_All_Item_Controller extends HttpServlet {

    private static final String HOME_PAGE = "home.jsp";
    private static final String MEMBER_PAGE = "member.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            HttpSession session = request.getSession();
            ItemDao itemDao = new ItemDao();
            ArrayList<Item> itemList = itemDao.getAllItems();

            String phone = request.getParameter("txtPhone");
            String fullName = request.getParameter("txtName");
            String email = request.getParameter("txtEmail");
            String button = request.getParameter("membership");

            if (phone != null && fullName != null && email != null && button != null) {
                MemberDao memberDao = new MemberDao();
                Member memberCheck = memberDao.getMembers(phone);

                if (button.equalsIgnoreCase("yes")) {
                    if (memberCheck.getPhone() == null) {
                        memberDao.insertMember(phone, fullName, email);
                    } else {
                        request.setAttribute("already", "You are already a member! Please sign in.");
                        request.getRequestDispatcher(MEMBER_PAGE).forward(request, response);
                        return; 
                    }
                }

                Member guest = new Member(phone, fullName, email);
                session.setAttribute("guest", guest);
            }

            ArrayList<Item> searchItem = (ArrayList<Item>) request.getAttribute("search");
            request.setAttribute("itemList", (searchItem != null && !searchItem.isEmpty()) ? searchItem : itemList);
            request.getRequestDispatcher(HOME_PAGE).forward(request, response);

        } catch (Exception e) {
            request.setAttribute("errorMessage", "An error occurred while retrieving items: " + e.getMessage());
            request.getRequestDispatcher(HOME_PAGE).forward(request, response);
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
        return "Servlet to retrieve all items for the Coffee Puppy Store.";
    }
}
