package gui.Panels;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {
    public HeaderPanel(){
        JLabel companyName = new JLabel("Bikes Ltd");
        companyName.setToolTipText("Bikes Ltd");
        companyName.setFont(new Font("Arial", Font.BOLD, 20));

        this.setBackground(Color.GRAY);
        this.setLayout(new GridLayout(1, 1));
        this.add(companyName);
    }
}
