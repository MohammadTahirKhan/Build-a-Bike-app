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
    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getOrderCost() {
        return orderCost;
    }
    public Status getOrderStatus() {
        return orderStatus;
    }
    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

//    Setters
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public void setOrderCost(double orderCost) {
        this.orderCost = orderCost;
    }
    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }
    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}