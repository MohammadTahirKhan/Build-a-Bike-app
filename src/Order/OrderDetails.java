package Order;

public class OrderDetails extends Order{
    public String orderedItemName;
    public int orderedItemQuantity;
    public double itemCost;


    public OrderDetails(int orderNumber, double totalCost, Status status, String orderedItemName, int orderedItemQuantity, double itemCost) {
        super(orderNumber, totalCost, status);
        this.orderedItemName=orderedItemName;
        this.orderedItemQuantity=orderedItemQuantity;
        this.itemCost=itemCost;
    }

    public String getOrderedItemName() {
        return orderedItemName;
    }

    public void setOrderedItemName(String orderedItemName) {
        this.orderedItemName = orderedItemName;
    }

    public int getOrderedItemQuantity() {
        return orderedItemQuantity;
    }

    public void setOrderedItemQuantity(int orderedItemQuantity) {
        this.orderedItemQuantity = orderedItemQuantity;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }
}

