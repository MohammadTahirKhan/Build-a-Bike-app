package Order;

import Actors.Customer;
import Product.Bike;

import java.util.Date;

public class Order {

//    Enum(s)
    public enum Status {
        PENDING,
        CONFIRMED,
        FULFILLED
    }

//    Variables
    private int orderNumber;
    private Date orderDate;
    private double totalCost;
    private Status orderStatus;
    private OrderDetails orderDetails;
    private Customer orderCustomer;
    private Bike orderBike;


    public Order(int orderNumber, Date orderDate, double totalCost, Status orderStatus, OrderDetails orderDetails,
                 Customer orderCustomer, Bike orderBike) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.totalCost = totalCost;
        this.orderStatus = orderStatus;
        this.orderDetails = orderDetails;
        this.orderCustomer = orderCustomer;
        this.orderBike = orderBike;
    }


//    Getters
    public int getOrderNumber() {
        return orderNumber;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public Status getOrderStatus() {
        return orderStatus;
    }
    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

//    Setters
    public void setOrderNumber(int orderNumber) {
    this.orderNumber = orderNumber;
}
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }
    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}