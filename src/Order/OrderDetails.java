package Order;

import Product.*;

import java.util.HashMap;
import java.util.Map;

public class OrderDetails {
//    Map to store ordered products and their quantity
    private Map<Product, Integer> itemMap = new HashMap<>();


    public OrderDetails(Wheels wheels, HandleBar handleBar, Frame frame){
        this.itemMap.put(wheels, wheels.getStock());
        this.itemMap.put(handleBar, handleBar.getStock());
        this.itemMap.put(frame, frame.getStock());
    }

//    getter
    public Map<Product, Integer> getItemMap() {
        return itemMap;
    }

//    setter
    public void setItemMap(Map<Product, Integer> itemMap) {
        this.itemMap = itemMap;
    }

}
