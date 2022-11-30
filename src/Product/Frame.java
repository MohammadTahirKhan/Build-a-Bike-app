package Product;

public class Frame extends Product{

//    Declaring variable(s)
    protected int frameSize;
    protected int gears;
    protected boolean containsShocks;

    /**
     * Constructor for a Frame
     * @param frameSize Size of the frame
     * @param gears Gears in frame
     * @param containsShocks If frame contains shocks
     * @param name Name of the frame
     * @param serialNumber Serial number of the frame
     * @param itemCost Cost of the frame
     * @param brandName Brand name
     * @param stock Stock available
     */
    public Frame(int pKey, int frameSize, int gears, boolean containsShocks, String name, int serialNumber, double itemCost, String brandName, int stock){
        this.frameSize = frameSize;
        this.gears = gears;
        this.containsShocks = containsShocks;
        this.setProductDetails(pKey, name, serialNumber, itemCost, brandName, stock);
    }
    public Frame(int frameSize, int gears, boolean containsShocks, String name, int serialNumber, double itemCost, String brandName, int stock){
        this.frameSize = frameSize;
        this.gears = gears;
        this.containsShocks = containsShocks;
        this.setProductDetails(-1, name, serialNumber, itemCost, brandName, stock);
    }


    public int getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(int frameSize) {
        this.frameSize = frameSize;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public boolean isContainsShocks() {
        return containsShocks;
    }

    public void setContainsShocks(boolean containsShocks) {
        this.containsShocks = containsShocks;
    }
}
