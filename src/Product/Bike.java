package Product;

public class Bike extends Product{

//    Declaring Variables
    protected Wheels wheels;
    protected Frame frame;
    protected HandleBar handleBar;

    /**
     * Constructor for a Bike
     * @param wheels Selected wheels
     * @param frame Selected frame
     * @param handleBar Selected handlebar
     * @param name Name of the Bike
     * @param serialNumber Serial number of the Bike
     * @param brandName Brand name
     * @param stock Stock available
     */
    //    itemCost is calculated automatically
    public Bike(Wheels wheels, Frame frame, HandleBar handleBar, String name, int serialNumber, double unitCost, String brandName, int stock) {
        this.wheels = wheels;
        this.frame = frame;
        this.handleBar = handleBar;
        this.setProductDetails(name, serialNumber, unitCost, brandName, stock);
    }

//    Getters
    public Wheels getWheels() {
        return wheels;
    }
    public Frame getFrame() {
        return frame;
    }
    public HandleBar getHandleBar() {
        return handleBar;
    }
}
