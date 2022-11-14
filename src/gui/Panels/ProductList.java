package gui.Panels;

import javax.swing.*;

public class ProductList extends JPanel {
    public ProductList(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    public void addProduct(JPanel product){
        this.add(product);
    }

    public void removeProduct(JPanel product){
        this.remove(product);
    }

    public void clearProducts(){
        this.removeAll();
    }

    public void updateProducts(){
        this.revalidate();
        this.repaint();
    }
}
