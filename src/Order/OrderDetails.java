
package Order;

import Product.Product;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class OrderDetails {
//    Map to store ordered products and their quantity
    private Map<Product, Integer> itemMap = new HashMap<>();

//    Constructor
//    public OrderDetails(Wheels wheels, HandleBar handleBar, Frame, frame){
//        this.itemMap = itemMap;
//    }

//    getter
    public Map<Product, Integer> getItemMap() {
        return itemMap;
    }

//    setter
    public void setItemMap(Map<Product, Integer> itemMap) {
        this.itemMap = itemMap;
    }

}
