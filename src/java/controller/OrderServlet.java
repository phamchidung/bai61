/*
 * Coppy right(C) 2021, Le Dai Duong 
 * Meal Order: 
 * J3.L.P0061-SimpleApp-MealOrderList 
 * 
 * Record of change: 
 * DATE          Version     AUTHOR      DESCRIPTION 
 * 2021-09-06     1.0        DuongLD     First Implement
 */
package controller;

import dao.ComboFoodBaseDAO;
import dao.FoodBaseDAO;
import dao.OrderBaseDAO;
import dao.ServiceBaseDAO;
import dao.StatusBaseDAO;
import config.Constants;
import dao.impl.ComboFoodDAOImpl;
import dao.impl.FoodDAOImpl;
import dao.impl.OrderDAOImpl;
import dao.impl.ServiceDAOImpl;
import dao.impl.StatusDAOImpl;
import entity.Order;
import entity.Status;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import validator.Validator;

/**
 * The class contains HTTP <code>GET</code> method and HTTP <code>POST</code>
 * method to handle request, response from client (<code> OrderPage.jsp</code>)
 * <br>
 * All data will be normalized (trim space) before update/insert into database
 * <br>
 * The method will throw an object of <code>java.lang.Exception</code> class if
 * there is any error occurring when finding, inserting, or updating data. <br>
 *
 * @author Le Dai Duong
 */
public class OrderServlet extends HttpServlet {

    private static final int NUMBER_ORDER_EACH_PAGE = 4;        // Number order each page

    /**
     * This method is called only once, it is called only when the Servlet is
     * created <br>
     * This method get list <code>Status</code> from database and set to
     * <code>HM_STATUS</code> is hash map object of
     * <code>java.util.HashMap</code> <br>
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        try {
            StatusBaseDAO statusDAO = new StatusDAOImpl();

            /*
             * Add value for hash map status if it is empty
             */
            if (Constants.HM_STATUS.isEmpty()) {
                // Get status list from database
                ArrayList<Status> statusList = statusDAO.getStatus();

                for (Status status : statusList) {
                    Constants.HM_STATUS.put(status.getStatusCode(), status.getStatusContent());
                }
            }
        } catch (Exception e) {

        }
    }

    /**
     * - Handles the HTTP <code>GET</code> method <br>
     * - This method get code from parameter and count total orders by code
     * <br>
     * - From total orders we count max page size and send information of code,
     * max page size to <code>OrderPage.jsp</code> <br>
     * - This page also get exactly index of page that user selected, the
     * default is 1 <br>
     * - If index greater than max page size we set index equal max page size
     * <br>
     * - If index less than 1 we set index equal 1 <br>
     * - Later send index value to <code>OrderPage.jsp</code> <br>
     * - After that we get orders by code, index page and number order each page
     * <br>
     * - Set values such as foods, comboFoods total money, deposit for each
     * order <br>
     * - Finally get request dispatcher to <code>OrderPage.jsp</code> <br>
     * - This method provided data of list order after paging for
     * <code>OrderPage.jsp</code> <br>
     * - This method using some methods such as: <br>
     * + Method getParameter of <code>HttpServletRequest</code> to get params
     * from <code> OrderPage.jsp </code> <br>
     * + Method count of <code> OrderDAOImpl </code> to count amount order when
     * searching by code <br>
     * + Method setAttribute of <code> HttpServletRequest </code> to send object
     * from this method to <code> OrderPage.jsp </code> <br>
     * + Method search of <code> OrderDAOImpl </code> to find all order searched
     * by code and pagination<br>
     * + Method getEndPage of this class to get max of page when searching <br>
     * + Method getFoodsByOrderId of <code> FoodDAOImpl </code> to get all food
     * of particular order <br>
     * + Method getComboFoodsByOrderId of <code> ComboFoodDAOImpl </code> to get
     * all combo food of particular order <br>
     * + Method getServicesByOrderId of <code> ServiceDAOImpl </code> to get all
     * services of particular order <br>
     *
     * @param request is used to send attributes: code, endPage, err_index,
     * index, listOrderSize, listOrder, err_search+paging from this method to
     * <code>OrderPage.jsp</code>. It's the object of
     * <code>HttpServletRequest</code>
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            OrderBaseDAO orderDAO = new OrderDAOImpl();

            // Order code searching
            String code = request.getParameter("code");
            code = Validator.formatString(code);        // validate code

            request.setAttribute("code", code);

            /*
             * Count total orders when search
             */
            int count = orderDAO.count(code);

            int endPage = getEndPage(count);        // get max page
            request.setAttribute("endPage", endPage);

            int index;          //default index of page user selected

            /*
             * Get exactly index of page user selected
             */
            try {
                index = Integer.parseInt(request.getParameter("index"));
            } catch (NumberFormatException e) {
                index = 1;
            }

            // Check and set index page when index page illegal
            if (index > endPage) {
                index = endPage;
            } else if (index < 1) {
                index = 1;
            }

            request.setAttribute("index", index);

            /*  
             * Get list Order by code, index page and number order each page 
             */
            ArrayList<Order> orders = orderDAO.search(code, index, NUMBER_ORDER_EACH_PAGE);
            setAdditionalInfoForListOrder(orders);

            request.setAttribute("listOrderSize", orders.size());
            request.setAttribute("listOrder", orders);

            request.getRequestDispatcher("/view/OrderPage.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("/view/Error.jsp").forward(request, response);
        }
    }

    /**
     * This method used to set total money, total combo food money, total
     * service money and list of <code>ComboFood<code>, list <code>Food</code>,
     * list <code>Service</code> for each <code>Order</code> object in list <br>
     *
     * @param orders is list of <code>Order</code>. It's a
     * <code>java.util.List</code> object
     */
    private void setAdditionalInfoForListOrder(ArrayList<Order> orders) throws Exception {
        FoodBaseDAO foodDAO = new FoodDAOImpl();
        ServiceBaseDAO serviceDAO = new ServiceDAOImpl();
        ComboFoodBaseDAO comboFoodDAO = new ComboFoodDAOImpl();

        /*
         * Loop to calculate total money, total combo food money,
         * total service money then set those information to all orders in list
         * then set foods, comboFoods total money, deposit of each order object
         */
        for (Order order : orders) {
            Order tempFoodOrder = foodDAO.getFoodOrder(order);
            Order tempComboFoodOrder = comboFoodDAO.getComboFoodOrder(order);
            Order tempServiceOrder = serviceDAO.getServiceOrder(order);

            // Total money
            float totalMoney = order.getTotalFoodsMoney()
                    + order.getTotalComboFoodsMoney()
                    + order.getTotalServicesesMoney();

            /*
             * Set information such as foods, comboFoods, total combo 
             * food money,total food money,total service money, total
             * money, deposit to attribute of each Order object
             */
            order.setTotalFoodsMoney(tempFoodOrder.getTotalFoodsMoney());
            order.setTotalComboFoodsMoney(tempComboFoodOrder.getTotalComboFoodsMoney());
            order.setTotalServicesesMoney(tempServiceOrder.getTotalServicesesMoney());
            order.setFoods(tempFoodOrder.getFoods());
            order.setComboFoods(tempComboFoodOrder.getComboFoods());
            order.setServiceses(tempServiceOrder.getServiceses());

            order.setTotalMoney(totalMoney);
            order.setDeposit(totalMoney / 10);
        }
    }

    /**
     * Calculate max of page when searching <br>
     *
     * @param count is total orders searched by code
     * @return max of page. <code>int</code>
     */
    private int getEndPage(int count) {
        int endPage = count / NUMBER_ORDER_EACH_PAGE;       // Max of paging

        // Increse endPage when total order don't divisible for number order each page
        if (count % NUMBER_ORDER_EACH_PAGE != 0) {
            endPage++;
        }

        return endPage;
    }

    /**
     * - Handles the HTTP <code>POST</code> method.<br>
     * - This method get id of particular order, index of page user want to see
     * when paging, order code user want to search, status of order after user
     * modified from parameter<br>
     * - Update status of order by id <br>
     * - Count total orders by code then get max page size from that code <br>
     * - Set values such as foods, comboFoods, total combo food money,total food
     * money, total service money, total money, deposit for each order <br>
     * - Send list orders, list order size to <code>OrderPage.jsp</code> <br>
     * - Finally get request dispatcher to <code>OrderPage.jsp</code> <br>
     * - This method provided data of list order after paging for
     * <code>OrderPage.jsp</code> <br>
     * - This method forward data of list order that send from
     * <code>OrderPage.jsp</code> and update order status after user change
     * status of order <code>OrderPage.jsp</code> <br>
     * - This method using some methods such as: <br>
     * + Method getEndPage of <code>OrderServlet</code> to get max of page when
     * searching <br>
     * + Method count of <code> OrderDAOImpl </code> to count amount order when
     * searching by code <br>
     * + Method search of <code> OrderDAOImpl </code> to find all order searched
     * by code and pagination<br>
     * + Method getEndPage of this class to get max of page when searching <br>
     * + Method getFoodsByOrderId of <code> FoodDAOImpl </code> to get all food
     * of particular order <br>
     * + Method getComboFoodsByOrderId of <code> ComboFoodDAOImpl </code> to get
     * all combo food of particular order <br>
     * + Method getServicesByOrderId of <code> ServiceDAOImpl </code> to get all
     * services of particular order <br>
     *
     * @param request is used to send attributes: code, endPage, err_index,
     * index, listOrderSize, listOrder, err_search+paging, orderId,
     * status,err_update_status from this method to <code>OrderPage.jsp</code>.
     * It's the object of <code>HttpServletRequest</code> <br>
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            OrderBaseDAO orderDAO = new OrderDAOImpl();

            // Id of particular order
            int id = Integer.parseInt(request.getParameter("id"));

            // Index of page user want to see when paging
            int index = Integer.parseInt(request.getParameter("index"));

            // Order code user want to search
            String code = request.getParameter("code");

            // Status code of order after user modified
            String statusCode = request.getParameter("statusCode");

            orderDAO.updateStatus(id, statusCode);

            // Count total orders when search
            int count = orderDAO.count(code);

            int endPage = getEndPage(count);
            request.setAttribute("endPage", endPage);

            /*  
             * Get list Order by code, index page and number order each page 
             */
            ArrayList<Order> orders = orderDAO.search(code, index, NUMBER_ORDER_EACH_PAGE);

            setAdditionalInfoForListOrder(orders);

            request.setAttribute("listOrderSize", orders.size());
            request.setAttribute("listOrder", orders);

            request.setAttribute("index", index);
            request.setAttribute("code", code);
            request.setAttribute("orderId", id);
            request.setAttribute("status", new Status(statusCode, Constants.HM_STATUS.get(statusCode)));
            request.setAttribute("showMess", "showMess");

            request.getRequestDispatcher("/view/OrderPage.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("/view/Error.jsp").forward(request, response);
        }
    }
}
