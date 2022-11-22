package Order;

import java.util.Date;

public class Order {

//    Enum(s)
    public enum Status {
        PENDING,
        CONFIRMED,
        FULFILLED
    }

//    Variables
    private int orderId;
    private Date orderDate;
    private OrderDetails orderContents;
    private double orderCost;
    private Status orderStatus;


    /**
     * Constructor for an Order
     * @param orderDate Date of the order
     * @param orderId Orders number
     * @param orderContents Details of item ordered
     * @param orderCost Total cost of the order
     * @param orderStatus Status of the order
     */
    public Order (Date orderDate, int orderId ,OrderDetails orderContents, double orderCost, Status orderStatus){
        this.orderDate = orderDate;
        this.orderId =orderId;
        this.orderCost =orderCost;
        this.orderStatus =orderStatus;
        this.orderContents = orderContents;
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
    public OrderDetails getOrderContents() {
        return orderContents;
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
    public void setOrderContents(OrderDetails orderContents) {
        this.orderContents = orderContents;
    }




}