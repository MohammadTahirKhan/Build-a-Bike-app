package Product;

public class Bike extends Product{

//    Constants
    private final double ASSEMBLY_COST = 10;

//    Declaring Variables
    private Wheels wheels;
    private Frame frame;
    private HandleBar handleBar;

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
    public Bike(int pKey, Wheels wheels, Frame frame, HandleBar handleBar, String name, int serialNumber, String brandName, int stock) {
        this.wheels = wheels;
        this.frame = frame;
        this.handleBar = handleBar;
        double unitCost = wheels.getItemCost() + frame.getItemCost() + handleBar.getItemCost() + ASSEMBLY_COST;
        this.setProductDetails(pKey, name, serialNumber, unitCost, brandName, stock);
    }
    public Bike(Wheels wheels, Frame frame, HandleBar handleBar, String name, int serialNumber, String brandName, int stock) {
        this.wheels = wheels;
        this.frame = frame;
        this.handleBar = handleBar;
        double unitCost = wheels.getItemCost() + frame.getItemCost() + handleBar.getItemCost() + ASSEMBLY_COST;
        this.setProductDetails(-1, name, serialNumber, unitCost, brandName, stock);
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
