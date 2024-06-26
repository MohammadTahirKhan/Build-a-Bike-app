package gui.Panels;


import Order.Order;
import Product.Product;
import gui.Frames.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewOrder extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private final JButton backToBrowseButton;
    private final JPanel itemsSelected;

    private final JButton placeOrderButton;
    private final JButton restartButton;
    private final JLabel yourSelection;

    private final ArrayList<ProductPanel> productPanels = new ArrayList<>(3);

    private final BaseFrame parentFrame;

    public ViewOrder(BaseFrame parentFrame) {
        this.parentFrame = parentFrame;

        itemsSelected = new JPanel();
        yourSelection = new JLabel();
        JPanel orderOptions = new JPanel();
        restartButton = new JButton();
        backToBrowseButton = new JButton();
        placeOrderButton = new JButton();

        initializeButtons();

        initPanels();

        yourSelection.setFont(new Font("Segoe UI", Font.BOLD, 24));
        yourSelection.setHorizontalAlignment(SwingConstants.CENTER);
        yourSelection.setText("Your Selection");
        if (BaseFrame.currentOrder.getID() != -1 && (BaseFrame.currentOrder.getStatus() == Order.Status.FULFILLED || BaseFrame.currentOrder.getStatus() == Order.Status.PENDING || BaseFrame.currentOrder.getStatus() == Order.Status.CONFIRMED)) {
            yourSelection.setText("Order Placed! : #" + BaseFrame.currentOrder.getID() + " (" + BaseFrame.currentOrder.getStatus() + ")");
        }

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
        GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
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

    public void initPanels() {
        itemsSelected.removeAll();
        productPanels.clear();


        Product handleBar = null;
        Product frame = null;
        Product wheels = null;

        if (BaseFrame.currentOrder.getBike() != null) {
            handleBar = BaseFrame.currentOrder.getBike().getHandleBar();
            frame = BaseFrame.currentOrder.getBike().getFrame();
            wheels = BaseFrame.currentOrder.getBike().getWheels();
        }

        if (handleBar != null) productPanels.add(new ProductPanel(handleBar, "Add to Bike"));
        if (frame != null) productPanels.add(new ProductPanel(frame, "Add to Bike"));
        if (wheels != null) productPanels.add(new ProductPanel(wheels, "Add to Bike"));

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
        if (BaseFrame.currentOrder.getID() != -1 && (BaseFrame.currentOrder.getStatus() == Order.Status.FULFILLED || BaseFrame.currentOrder.getStatus() == Order.Status.PENDING || BaseFrame.currentOrder.getStatus() == Order.Status.CONFIRMED)) {
            yourSelection.setText("Order Placed! : #" + BaseFrame.currentOrder.getID() + " (" + BaseFrame.currentOrder.getStatus() + ")");
        }
    }

    private void initializeButtons() {
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

        restartButton.addActionListener(e -> {
            BaseFrame.currentOrder = new Order();
            parentFrame.displayPanel(parentFrame.productBrowse, false, true, true, false, false);
        });

        backToBrowseButton.addActionListener(e -> parentFrame.displayPanel(parentFrame.productBrowse, false, true, true, false, false));

        placeOrderButton.addActionListener(e -> {
            if (BaseFrame.currentOrder.getBike() != null) {
                if (BaseFrame.currentOrder.getBike().getFrame() != null && BaseFrame.currentOrder.getBike().getHandleBar() != null && BaseFrame.currentOrder.getBike().getWheels() != null) {
                    parentFrame.confirmOrder.initPanels();
                    parentFrame.displayPanel(parentFrame.enterCustomerDetails, false, true, true, false, false);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select all parts before placing order!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a bike before placing an order.");
            }

        });
    }
}

