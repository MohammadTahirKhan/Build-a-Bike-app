package gui.Panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewOrder extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private JButton backToBrowseButton;
    private final JPanel itemsSelected;

    private JPanel orderOptions;
    private JButton placeOrderButton;
    private JButton restartButton;
    private JLabel yourSelection;

    private ArrayList<ProductPanel> productPanels = new ArrayList<>(3);


    public ViewOrder() {
        itemsSelected = new JPanel();
        yourSelection = new JLabel();
        orderOptions = new JPanel();
        restartButton = new JButton();
        backToBrowseButton = new JButton();
        placeOrderButton = new JButton();

        GroupLayout itemsSelectedLayout = new GroupLayout(itemsSelected);
        GroupLayout.SequentialGroup seqGroup = itemsSelectedLayout.createSequentialGroup();
        GroupLayout.ParallelGroup parGroup = itemsSelectedLayout.createParallelGroup(LEADING);

        for (ProductPanel productPanel : productPanels) {
            seqGroup.addGap(29, 29, 29)
                    .addComponent(productPanel, PREFERRED, DEFAULT, PREFERRED);
            parGroup.addComponent(productPanel, DEFAULT, DEFAULT, Short.MAX_VALUE);
        }
        seqGroup.addContainerGap(29, Short.MAX_VALUE);


        itemsSelected.setLayout(itemsSelectedLayout);
        itemsSelectedLayout.setHorizontalGroup(
                itemsSelectedLayout.createParallelGroup(LEADING)
                        .addGroup(seqGroup)
        );
        itemsSelectedLayout.setVerticalGroup(
                parGroup
        );

        yourSelection.setFont(new Font("Segoe UI", Font.BOLD, 24));
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
        placeOrderButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
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

