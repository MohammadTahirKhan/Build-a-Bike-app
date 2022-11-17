package Order;

public class Order {
    public int orderNumber;

    public OrderDetails itemDetail;
    public double totalCost;
    public enum Status {
        PENDING,
        CONFIRMED,
        FULFILLED
    }
    public Status status;

    public Order (int orderNumber ,OrderDetails itemDetail, double totalCost, Status status){
        this.orderNumber=orderNumber;
        this.totalCost=totalCost;
        this.status=status;
        this.itemDetail = itemDetail;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public OrderDetails getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(OrderDetails itemDetail) {
        this.itemDetail = itemDetail;
    }
}