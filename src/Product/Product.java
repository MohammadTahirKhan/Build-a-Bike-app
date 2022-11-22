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
    protected double itemCost;
    protected String brandName;
    protected int stock;

    /**
     * Constructor for a Product
     * @param name Name of the Product
     * @param serialNumber Serial number of the Product
     * @param itemCost Cost of the Product
     * @param brandName Brand name
     * @param stock Stock available
     */
    protected void setProductDetails(String name, int serialNumber, double itemCost, String brandName, int stock){
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
    public double getItemCost() {
        return itemCost;
    }
    public String getBrandName() {
        return brandName;
    }
    public int getStock() {
        return stock;
    }
}
