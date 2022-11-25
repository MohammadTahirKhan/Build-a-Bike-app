
package Order;

import Product.Product;

import java.util.HashMap;
import java.util.Map;

public class OrderDetails {
    Map<Product, Integer> itemMap = new HashMap<>();
    public OrderDetails(Map<Product, Integer> itemMap){
        this.itemMap = itemMap;
    }

    public Map<Product, Integer> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Product, Integer> itemMap) {
        this.itemMap = itemMap;
    }
}
