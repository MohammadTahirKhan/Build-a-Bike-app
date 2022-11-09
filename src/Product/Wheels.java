package Product;

public class Wheels extends Product{

//    Declaring ENUM's
    public enum Style {
        ROAD,
        MOUNTAIN,
        HYBRID
    }
    public enum BrakeType{
        DISKBRAKE,
        RIM
    }

//    Declaring variables
    protected int diameter;
    protected Style style;
    protected BrakeType brakeType;

//    Constructor
    public Wheels(int diameter, String style, String brakeType , String name, int serialNumber, float itemCost, String brandName) {
        this.diameter = diameter;
        setStyle(style);
        setBrakeType(brakeType);
        this.setProductDetails(name, serialNumber, itemCost, brandName);
    }

//    Getters
    public int getDiameter() {
        return diameter;
    }
    public Style getStyle() {
        return style;
    }
    public String getStyleString() {
        return style.toString();
    }
    public BrakeType getBrakeType() {
        return brakeType;
    }
    public String getBrakeTypeString() {
        return brakeType.toString();
    }


//    Private Setters
    private void setStyle(String style){
        this.style = Style.valueOf(style);
    }
    private void setBrakeType(String brakeType){
        this.brakeType = BrakeType.valueOf(brakeType);
    }

}