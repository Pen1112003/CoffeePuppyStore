package controller.order;

import dao.ItemDao;
import dto.GetOrder;
import dto.Item;
import dto.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderController extends HttpServlet {

    private final String HOME_PAGE = "MainController?btn=Home";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String link = HOME_PAGE;
        ItemDao itemDao = new ItemDao();
        ArrayList<Item> itemList = itemDao.getAllItems();
        HttpSession session = request.getSession();

        String idOrderStr = request.getParameter("idOrder");
        String quantityStr = request.getParameter("quantity");

        if (idOrderStr == null || quantityStr == null) {
            request.setAttribute("errorMessage", "Invalid order details.");
            request.getRequestDispatcher(link).forward(request, response);
            return;
        }

        int id = Integer.parseInt(idOrderStr);
        int quantity = Integer.parseInt(quantityStr);
        String memberPhone = request.getParameter("memberPhone");
        String guestPhone = request.getParameter("guestPhone");
        String name = request.getParameter("name");

        HashMap<Integer, Order> orderList = (HashMap<Integer, Order>) session.getAttribute("order");
        if (orderList == null) {
            orderList = new HashMap<>();
        }

        for (Item item : itemList) {
            if (item.getIdItem() == id) {
                if (memberPhone != null && !memberPhone.isEmpty()) {
                    orderList.put(id, new Order(quantity * item.getPrice(), "none", memberPhone, id, quantity, item.getItemName(), item.getPrice()));
                } else if (guestPhone != null && !guestPhone.isEmpty()) {
                    orderList.put(id, new Order(quantity * item.getPrice(), guestPhone, "none", id, quantity, item.getItemName(), item.getPrice()));
                } else {
                    request.setAttribute("errorMessage", "Phone number is required.");
                    request.getRequestDispatcher(link).forward(request, response);
                    return;
                }
                break;
            }
        }

        session.setAttribute("name", name);
        session.setAttribute("order", orderList);
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
        return "Handles order processing for guests and members";
    }
}
