package gui.Panels;

import gui.Utils.BorderUtils;
import gui.Utils.FontUtils;

import javax.swing.*;
import java.awt.*;

public class FindExistingOrder extends JPanel {
    public FindExistingOrder() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderUtils.createBorder("Find Existing Order"));

        JLabel reviewOrder = new JLabel("Review Order");
        reviewOrder.setFont(FontUtils.DEFAULT_FONT);
        this.add(reviewOrder, createGbc(0, 0));

        JTextField orderID = new JTextField("Order ID");
        reviewOrder.setFont(FontUtils.DEFAULT_FONT);
        this.add(orderID, createGbc(0, 1));

        JButton findOrder = new JButton("Find Order");
        reviewOrder.setFont(FontUtils.DEFAULT_FONT);
        this.add(findOrder, createGbc(0, 2));

//        JButton backButton = new JButton("Back");
//        this.add(backButton, createGbc(0,3));

        this.setVisible(true);
    }

    private static GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }
}
