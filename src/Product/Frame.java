package Product;

public class Frame extends Product{

//    Declaring variable(s)
    protected int frameSize;
    protected boolean containsShocks;

//    Constructor
    public Frame(int frameSize, boolean containsShocks, String name, int serialNumber, float itemCost, String brandName){
        this.frameSize = frameSize;
        this.containsShocks = containsShocks;
        this.setProductDetails(name, serialNumber, itemCost, brandName);
    }

//    Getters
    public int getFrameSize() {
        return frameSize;
    }
    public boolean isContainsShocks() {
        return containsShocks;
    }
}
