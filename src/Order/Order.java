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



    /**
     * Constructor for an Order
     * @param orderNumber Orders number
     * @param itemDetail Details of item ordered
     * @param totalCost Total cost of the order
     * @param status Status of the order
     */
    public Order (int orderNumber ,OrderDetails itemDetail, double totalCost, Status status){
        this.orderNumber=orderNumber;
        this.totalCost=totalCost;
        this.orderStatus =status;
        this.orderDetails = itemDetail;
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