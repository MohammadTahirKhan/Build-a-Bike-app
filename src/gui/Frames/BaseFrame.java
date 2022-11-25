package gui.Frames;

import gui.Panels.ReviewExistingOrder;

import javax.swing.*;

public class BaseFrame extends JFrame {

    public BaseFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(new ReviewExistingOrder(this));
    }
}
