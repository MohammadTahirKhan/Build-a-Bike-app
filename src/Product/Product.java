package Product;

public abstract class Product {

//    Declaring ENUM's
    public enum Products {
        BIKE,
        FRAME,
        HANDLEBAR,
        WHEELS
    }

//    Declaring Variables
    protected String name;
    protected int serialNumber;
    protected float itemCost;
    protected String brandName;
    protected int stock;

//    Sets Product variables
    protected void setProductDetails(String name, int serialNumber, float itemCost, String brandName, int stock){
        this.name = name;
        this.serialNumber = serialNumber;
        this.itemCost = itemCost;
        this.brandName = brandName;
        this.stock = stock;
    }

//    Getters
    public String getName() {
        return name;
    }
    public int getSerialNumber() {
        return serialNumber;
    }
    public float getItemCost() {
        return itemCost;
    }
    public String getBrandName() {
        return brandName;
    }
    public int getStock() {
        return stock;
    }
}
