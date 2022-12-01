package Product;

public class HandleBar extends Product{

//    Declaring ENUM
    public enum Style {
        STRAIGHT,
        HIGH,
        DROPPED,
        ALL
    }

//    Declaring variable(s)
    protected Style style;

    /**
     * Constructor for a HandleBar
     * @param style Style of the Handle Bar
     * @param name Name of the Handle Bar
     * @param serialNumber Serial number of the Handle Bar
     * @param itemCost Cost of the Handle Bar
     * @param brandName Brand name
     * @param stock Stock available
     */
    public HandleBar(int pKey, Style style, String name, int serialNumber, double itemCost, String brandName, int stock) {
        setStyle(style);
        this.setProductDetails(pKey, name, serialNumber, itemCost, brandName, stock);
    }
    public HandleBar(Style style, String name, int serialNumber, double itemCost, String brandName, int stock) {
        setStyle(style);
        this.setProductDetails(-1, name, serialNumber, itemCost, brandName, stock);
    }

//    Getter
    public Style getStyle() {
        return style;
    }

//    Private Setters
    public void setStyle(Style style) {
        this.style = style;
    }
}
