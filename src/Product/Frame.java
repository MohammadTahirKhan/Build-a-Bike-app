package Product;

public class Frame extends Product{

//    Declaring variable(s)
    protected int frameSize;
    protected String gears;
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
