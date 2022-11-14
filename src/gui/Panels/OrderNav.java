package gui.Panels;

import javax.swing.*;
import java.awt.*;

public class OrderNav extends JPanel {
    public OrderNav(){
        JButton selectWheels = new JButton("Select Wheels");
        JButton selectFrame = new JButton("Select Frame");
        JButton selectHandleBars = new JButton("Select Handle-Bars");
        JButton viewOrder = new JButton("View Order");

        this.setLayout(new GridLayout(1, 4));
        this.add(selectWheels);
        this.add(selectFrame);
        this.add(selectHandleBars);
        this.add(viewOrder);
    }
}
