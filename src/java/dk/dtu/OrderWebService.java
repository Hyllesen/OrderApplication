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
     * Web service operation
     */
    @WebMethod(operationName = "getOrderInfo")
    public String getOrderInfo(@WebParam(name = "orderNumber") String orderNumber) {
        Order order = orders.get(orderNumber);
        String payStatus = "";
        if(order.isPaid()) {
            payStatus = "Is Paid";
        } else {
            payStatus = "Not yet paid";
        }
        return "Order number " + order.getOrderNumber() + ": Customer " + order.getCustomer() + " has ordered " + order.getAmount() + " " + order.getProduct() + ". " + payStatus;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "payOrder")
    @Oneway
    public void payOrder(@WebParam(name = "ccNumber") String ccNumber, @WebParam(name = "orderNumber") String orderNumber) {
    }
}
