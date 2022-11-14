package gui.Frames;

import gui.Panels.HeaderPanel;

import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame {
    private final JPanel HeaderBar;
    private JPanel Content;

    public BaseFrame(){
        super("Bikes Ltd");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        this.HeaderBar = new HeaderPanel();
        this.add(HeaderBar, BorderLayout.NORTH);
    }
}
