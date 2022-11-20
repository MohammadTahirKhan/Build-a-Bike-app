package Product;

public class Bike extends Product{

//    Declaring Variables
    protected final int ASSEMBLYCOST = 10;
    protected Wheels wheels;
    protected Frame frame;
    protected HandleBar handleBar;

//    Constructor
//    itemCost is calculated automatically
    public Bike(Wheels wheels, Frame frame, HandleBar handleBar, String name, int serialNumber, String brandName, int stock) {
        this.wheels = wheels;
        this.frame = frame;
        this.handleBar = handleBar;
        double bikePrice = wheels.getItemCost() + frame.getItemCost() + handleBar.getItemCost() + ASSEMBLYCOST;
        this.setProductDetails(name, serialNumber, bikePrice, brandName, stock);
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
