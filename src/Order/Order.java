package Order;

public class Order {

//    Enum(s)
    public enum Status {
        PENDING,
        CONFIRMED,
        FULFILLED
    }

//    Variables
    private int orderNumber;
    private OrderDetails itemDetail;
    private double totalCost;
    private Status status;


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
        this.status=status;
        this.itemDetail = itemDetail;
    }

//    Getters
    public int getOrderNumber() {
        return orderNumber;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public Status getStatus() {
        return status;
    }
    public OrderDetails getItemDetail() {
        return itemDetail;
    }

//    Setters
    public void setOrderNumber(int orderNumber) {
    this.orderNumber = orderNumber;
}
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setItemDetail(OrderDetails itemDetail) {
        this.itemDetail = itemDetail;
    }




}