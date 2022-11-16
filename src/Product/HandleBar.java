package Product;

public class HandleBar extends Product{

//    Declating ENUM
    public enum Style {
        STRAIGHT,
        HIGH,
        DROPPED,
        ALL
    }

//    Declaring variable(s)
    protected Style style;

//    Constructor
    public HandleBar(String style, String name, int serialNumber, double itemCost, String brandName, int stock) {
        setStyle(style);
        this.setProductDetails(name, serialNumber, itemCost, brandName, stock);
    }

//    Getter
    public Style getStyle() {
        return style;
    }
    public String getStyleString() {
        return style.toString();
    }

//    Private Setters
    private void setStyle(String style) {
        this.style = Style.valueOf(style);
    }
}
