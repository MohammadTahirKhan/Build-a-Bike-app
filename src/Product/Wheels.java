package Product;

public class Wheels extends Product{

//    Declaring ENUM's
    public enum Style {
        ROAD,
        MOUNTAIN,
        HYBRID,
        ALL
    }
    public enum BrakeType{
        DISKBRAKE,
        RIM,
        ALL
    }

//    Declaring variables
    protected double diameter;
    protected Style style;
    protected BrakeType brakeType;

    /**
     * Constructor for a Wheels
     * @param diameter Diameter of the Wheels
     * @param style Style of the Wheels
     * @param brakeType Type of brakes in Wheels
     * @param name Name of the Wheels
     * @param serialNumber Serial number of the Wheels
     * @param itemCost Cost of the Wheels
     * @param brandName Brand name
     * @param stock Stock available
     */
    public Wheels(int pKey, double diameter, String style, String brakeType , String name, int serialNumber, double itemCost, String brandName, int stock) {
        this.diameter = diameter;
        setStyle(style);
        setBrakeType(brakeType);
        this.setProductDetails(pKey, name, serialNumber, itemCost, brandName, stock);
    }
    public Wheels(double diameter, String style, String brakeType , String name, int serialNumber, double itemCost, String brandName, int stock) {
        this.diameter = diameter;
        setStyle(style);
        setBrakeType(brakeType);
        this.setProductDetails(-1, name, serialNumber, itemCost, brandName, stock);
    }
    public Wheels(double diameter, Style style, BrakeType brakeType , String name, int serialNumber, double itemCost, String brandName, int stock) {
        this.diameter = diameter;
        setStyle(style);
        setBrakeType(brakeType);
        this.setProductDetails(-1, name, serialNumber, itemCost, brandName, stock);
    }

//    Getters
    public double getDiameter() {
        return diameter;
    }
    public Style getStyle() {
        return style;
    }
    public BrakeType getBrakeType() {
        return brakeType;
    }


//    Private Setters
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }
    public void setStyle(Style style) {
        this.style = style;
    }
    public void setStyle(String style) {
        this.style = Style.valueOf(style);
    }
    public void setBrakeType(BrakeType brakeType) {
        this.brakeType = brakeType;
    }
    public void setBrakeType(String brakeType) {
        this.brakeType = BrakeType.valueOf(brakeType);
    }


//    SQL Get wheels

//    public static Wheels[] pullWheels(){
//        return Queries.getWheels();
//    }

}
