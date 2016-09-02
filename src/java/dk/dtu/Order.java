package dk.dtu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stefan
 */
public class Order {
    private String orderNumber, customer, product;
    private boolean isPaid;
    private int amount;

    public Order(String orderNumber, String customer, String product, boolean isPaid, int amount) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.product = product;
        this.isPaid = isPaid;
        this.amount = amount;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        String payStatus;
        if(this.isPaid()) {
            payStatus = "Is Paid";
        } else {
            payStatus = "Not yet paid";
        }
        return "Order number " + this.getOrderNumber() + ": Customer " + this.getCustomer() + " has ordered " + this.getAmount() + " " + this.getProduct() + ". " + payStatus;
    }
    
    
    
    
}
