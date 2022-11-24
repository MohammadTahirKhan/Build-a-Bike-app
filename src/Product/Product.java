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
    private int pKey;
    private String name;
    private int serialNumber;
    private double itemCost;
    private String brandName;
    private int stock;

    /**
     * Constructor for a Product
     * @param name Name of the Product
     * @param serialNumber Serial number of the Product
     * @param itemCost Cost of the Product
     * @param brandName Brand name
     * @param stock Stock available
     */
    protected void setProductDetails(int pKey, String name, int serialNumber, double itemCost, String brandName, int stock){
        this.pKey = pKey;
        this.name = name;
        this.serialNumber = serialNumber;
        this.itemCost = itemCost;
        this.brandName = brandName;
        this.stock = stock;
    }

//    Getters
    public int getPKey(){
        return  pKey;
    }
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
    public Product getProduct(){
        return this;
    }

//    Setters
    public void setPKey(int pKey) {
        this.pKey = pKey;
    }
}
