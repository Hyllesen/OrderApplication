/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.dtu;

import java.util.HashMap;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author stefan
 */
@WebService(serviceName = "OrderWebService")
public class OrderWebService {
    
    private HashMap<String, Order> orders;
    
    public OrderWebService() {
        orders = new HashMap<>();
    }

    /**
     * Adds a product order to orders.
     * orderProduct takes an order number (string), customer name (string), an
        amount (integer), and a product (string) and returns the order number as
        a string
     */
    @WebMethod(operationName = "orderProduct")
    public String orderProduct(@WebParam(name = "orderNumber") String orderNumber, @WebParam(name = "customerName") String customerName, @WebParam(name = "amount") int amount, @WebParam(name = "productName") String productName) {
        boolean paid = false;
        Order order = new Order(orderNumber, customerName, productName, paid, amount);
        //Add the order to all orders
        orders.put(orderNumber, order);
        return order.getOrderNumber();
    }

    /**
     *  returns a string with the
        information of the order, e.g., ”Order number 2: Customer Peter has ordered
        10 pencil. Is paid” for an order made with order number 2 by customer Peter
        who has ordered 10 amount of product ”pencil” and where payment was okay.
        If the order is not yet paid, then ”Not yet paid” should be returned instead of
        ”Is paid”
     * @param orderNumber
     * @return order status text
     */
    @WebMethod(operationName = "getOrderInfo")
    public String getOrderInfo(@WebParam(name = "orderNumber") String orderNumber) {
        Order order = orders.get(orderNumber);
        return order.toString();
    }

    /**
     * Initiates payment by taking as argument a credit
       card number (string), e.g. ”12345”, and an order number (string).
     */
    @WebMethod(operationName = "payOrder")
    @Oneway
    public void payOrder(@WebParam(name = "ccNumber") String ccNumber, @WebParam(name = "orderNumber") String orderNumber) {
    }

    /**
     * Returns order object from orders, argument is order number
     */
    @WebMethod(operationName = "getOrderObject")
    public Order getOrderObject(@WebParam(name = "orderNumber") String orderNumber) {        
        return orders.get(orderNumber);
    }
}
