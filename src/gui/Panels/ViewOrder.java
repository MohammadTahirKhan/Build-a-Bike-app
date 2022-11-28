package gui.Panels;

import javax.swing.*;

import java.awt.*;
public class ViewOrder extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private JButton backToBrowseButton;
    private JPanel itemsSelected;

    private JPanel orderOptions;
    private JButton placeOrderButton;
    private JButton restartButton;
    private JLabel yourSelection;

    //** TEMP FOR DESIGN */
    private ItemTile item1;
    private ItemTile item2;
    private ItemTile item3;
                  
    public ViewOrder() {
        itemsSelected = new JPanel();
        yourSelection = new JLabel();
        orderOptions = new JPanel();
        restartButton = new JButton();
        backToBrowseButton = new JButton();
        placeOrderButton = new JButton();

        //**TEMP */
        item1 = new ItemTile(false);
        item2 = new ItemTile(false);
        item3 = new ItemTile(false);

        GroupLayout itemsSelectedLayout = new GroupLayout(itemsSelected);
        itemsSelected.setLayout(itemsSelectedLayout);
        itemsSelectedLayout.setHorizontalGroup(
            itemsSelectedLayout.createParallelGroup(LEADING)
            .addGroup(itemsSelectedLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(item1, PREFERRED, DEFAULT, PREFERRED)
                .addGap(29, 29, 29)
                .addComponent(item2, PREFERRED, DEFAULT, PREFERRED) //todo still
                .addGap(29, 29, 29)
                .addComponent(item3, PREFERRED, DEFAULT, PREFERRED)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        itemsSelectedLayout.setVerticalGroup(
            itemsSelectedLayout.createParallelGroup(LEADING)
            .addComponent(item1, DEFAULT, DEFAULT, Short.MAX_VALUE)
            .addComponent(item2, DEFAULT, DEFAULT, Short.MAX_VALUE)
            .addComponent(item3, DEFAULT, DEFAULT, Short.MAX_VALUE)
        );

        yourSelection.setFont(new Font("Segoe UI", 1, 24));
        yourSelection.setHorizontalAlignment(SwingConstants.CENTER);
        yourSelection.setText("Your Selection");

        restartButton.setBackground(new Color(51, 51, 51));
        restartButton.setForeground(new Color(255, 255, 255));
        restartButton.setText("Restart");
        restartButton.setToolTipText("");

        backToBrowseButton.setBackground(new Color(51, 51, 51));
        backToBrowseButton.setForeground(new Color(255, 255, 255));
        backToBrowseButton.setText("Back To Browse");
        backToBrowseButton.setToolTipText("");

        placeOrderButton.setBackground(new Color(51, 51, 51));
        placeOrderButton.setFont(new Font("Segoe UI", 1, 12));
        placeOrderButton.setForeground(new Color(255, 255, 255));
        placeOrderButton.setText("Place Order");
        placeOrderButton.setToolTipText("");

        GroupLayout orderOptionsLayout = new GroupLayout(orderOptions);
        orderOptions.setLayout(orderOptionsLayout);
        orderOptionsLayout.setHorizontalGroup(
            orderOptionsLayout.createParallelGroup(LEADING)
            .addGroup(orderOptionsLayout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(restartButton, PREFERRED, 118, PREFERRED)
                .addGap(18, 18, 18)
                .addComponent(backToBrowseButton, PREFERRED, 118, PREFERRED)
                .addGap(18, 18, 18)
                .addComponent(placeOrderButton, PREFERRED, 118, PREFERRED)
                .addContainerGap(DEFAULT, Short.MAX_VALUE))
        );
        orderOptionsLayout.setVerticalGroup(
            orderOptionsLayout.createParallelGroup(LEADING)
            .addGroup(orderOptionsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(orderOptionsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(placeOrderButton, PREFERRED, 45, PREFERRED)
                    .addComponent(restartButton, PREFERRED, 45, PREFERRED)
                    .addComponent(backToBrowseButton, PREFERRED, 45, PREFERRED))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(LEADING)
                    .addComponent(yourSelection, TRAILING, DEFAULT, DEFAULT, Short.MAX_VALUE)
                    .addComponent(itemsSelected, DEFAULT, DEFAULT, Short.MAX_VALUE)
                    .addComponent(orderOptions, DEFAULT, DEFAULT, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(yourSelection, PREFERRED, 82, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemsSelected, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orderOptions, PREFERRED, DEFAULT, PREFERRED)
                .addContainerGap())
        );
    }                     
}

