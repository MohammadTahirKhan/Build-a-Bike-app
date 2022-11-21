package gui.Panels;

import javax.swing.*;

public class Product extends JPanel{
    public String name;
    public Double cost;

    public Product() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }
}
