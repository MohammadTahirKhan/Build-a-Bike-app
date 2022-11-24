package Order;

import Actors.Customer;
import Product.Bike;
import java.util.Date;

public class Order {

//    Enum(s)
    public enum Status {
        PENDING,
        CONFIRMED,
        FULFILLED,
        All
    }

//    Variables
    private int ID;
    private Date date;
    private double cost;
    private Status status;
    private OrderDetails details;
    private Customer customer;
    private Bike bike;


    public Order(int orderNumber, Date orderDate, Status orderStatus, OrderDetails orderDetails,
                 Customer orderCustomer, Bike orderBike) {
        this.ID = orderNumber;
        this.date = orderDate;
        this.cost = orderBike.getItemCost();
        this.status = orderStatus;
        this.details = orderDetails;
        this.customer = orderCustomer;
        this.bike = orderBike;
    }
    public Order(Date orderDate, Status orderStatus, OrderDetails orderDetails,
                 Customer orderCustomer, Bike orderBike) {
        this.ID = -1;
        this.date = orderDate;
        this.cost = orderBike.getItemCost();
        this.status = orderStatus;
        this.details = orderDetails;
        this.customer = orderCustomer;
        this.bike = orderBike;
    }


//    Getters
    public int getID() {
        return ID;
    }
    public Date getDate() {
        return date;
    }
    public double getCost() {
        return cost;
    }
    public Status getStatus() {
        return status;
    }
    public String getDetails() {
        return details.toString();
    }
    public Customer getCustomer() {
        return customer;
    }
    public Bike getBike() {
        return bike;
    }

//    Setters
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setDetails(OrderDetails details) {
        this.details = details;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setBike(Bike bike) {
        this.bike = bike;
    }
}