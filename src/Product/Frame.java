package Product;

public class Frame extends Product{

//    Declaring variable(s)
    protected int frameSize;
    protected String gears;
    protected boolean containsShocks;

//    Constructor
    public Frame(int frameSize, String gears, boolean containsShocks, String name, int serialNumber, double itemCost, String brandName, int stock){
        this.frameSize = frameSize;
        this.gears = gears;
        this.containsShocks = containsShocks;
        this.setProductDetails(name, serialNumber, itemCost, brandName, stock);
    }

//    Getters
    public int getFrameSize() {
        return frameSize;
    }
    public boolean isContainsShocks() {
        return containsShocks;
    }
}
