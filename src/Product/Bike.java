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
    public Bike(int pKey, Wheels wheels, Frame frame, HandleBar handleBar, String name, int serialNumber, double unitCost, String brandName, int stock) {
        this.wheels = wheels;
        this.frame = frame;
        this.handleBar = handleBar;
        this.setProductDetails(pKey, name, serialNumber, unitCost, brandName, stock);
    }
    public Bike(Wheels wheels, Frame frame, HandleBar handleBar) {
        this.wheels = wheels;
        this.frame = frame;
        this.handleBar = handleBar;
        this.setValues();
    }
    public Bike(){

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

//    Setters
    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }
    public void setFrame(Frame frame) {
        this.frame = frame;
    }
    public void setHandleBar(HandleBar handleBar) {
        this.handleBar = handleBar;
    }

//    Sets all the values
    public void setValues(){
        String wSerial = String.valueOf(this.wheels.getSerialNumber());
        String fSerial = String.valueOf(this.frame.getSerialNumber());
        String hSerial = String.valueOf(this.handleBar.getSerialNumber());
        int serialNumber = Integer.parseInt(wSerial + fSerial + hSerial);
//        double totalCost = this.wheels.getItemCost() + this.frame.getItemCost() + this.handleBar.getItemCost() + ASSEMBLY_COST;
        //this.setProductDetails(-1, (frame.getBrandName() + " " + serialNumber), serialNumber, totalCost, frame.getBrandName(), 1);
        this.setProductDetails(-1, (frame.getBrandName() + " " + serialNumber), serialNumber, ASSEMBLY_COST, frame.getBrandName(), 1);
    }
}



