package gui.Panels;

import javax.swing.*;
import java.awt.*;

public class FindExistingOrder extends JPanel {
    public FindExistingOrder(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridheight = 3;
//        gbc.gridwidth = 3;
        gbc.weightx = 0;

        JLabel reviewOrder = new JLabel("Review Order");
        gbc.anchor = GridBagConstraints.CENTER;
        reviewOrder.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 5, 10, 5);
        this.add(reviewOrder, gbc);
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;

        JTextField orderID = new JTextField("Order ID");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.7;
        this.add(orderID, gbc);
        gbc.weightx = 0;

        JButton findOrder = new JButton("Find Order");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        this.add(findOrder, gbc);
        gbc.gridwidth = 1;

        JButton backButton = new JButton("Back");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.ipadx = 10;
        gbc.insets = new Insets(0, 10, 5, 5);
        this.add(backButton, gbc);

        this.setVisible(true);
    }
}
