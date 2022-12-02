package gui.Panels;

import Order.Order;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ForgottenFindOrder extends JPanel {
    private final JScrollPane productTable;
    private final JPanel productTableItems;

    private final ArrayList<OrderTableItem> orderTableItems = new ArrayList<>();

    public ForgottenFindOrder() {
        JPanel tableHeadingLabels = new JPanel();
        JLabel productName = new JLabel();
        JLabel serialNumber = new JLabel();
        JLabel unitCost = new JLabel();
        JLabel brandName = new JLabel();
        JLabel serialNumber1 = new JLabel();
        productTable = new JScrollPane();
        productTableItems = new JPanel();
        JLabel staffLogin = new JLabel();

        productName.setText("Bike Name");

        serialNumber.setText("Wheels");

        unitCost.setText("Handle Bars");

        brandName.setText("Frame Set");

        serialNumber1.setText("Order Number");

        GroupLayout tableHeadingLabelsLayout = new GroupLayout(tableHeadingLabels);
        tableHeadingLabels.setLayout(tableHeadingLabelsLayout);
        tableHeadingLabelsLayout.setHorizontalGroup(
                tableHeadingLabelsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(tableHeadingLabelsLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(productName, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(unitCost, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(brandName, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(serialNumber, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(serialNumber1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        tableHeadingLabelsLayout.setVerticalGroup(
                tableHeadingLabelsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, tableHeadingLabelsLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(tableHeadingLabelsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(productName)
                                        .addComponent(serialNumber)
                                        .addComponent(unitCost)
                                        .addComponent(brandName)
                                        .addComponent(serialNumber1))
                                .addContainerGap())
        );

        generateOrders(new ArrayList<>());

        staffLogin.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        staffLogin.setHorizontalAlignment(SwingConstants.CENTER);
        staffLogin.setText("Find Order");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(43, Short.MAX_VALUE)
                                .addComponent(productTable, GroupLayout.PREFERRED_SIZE, 819, GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(tableHeadingLabels, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(staffLogin, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(staffLogin, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tableHeadingLabels, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(productTable, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
        );
    }

    public void generateOrders(ArrayList<Order> orders) {
        productTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        productTableItems.setMaximumSize(new java.awt.Dimension(900, 32767));
        productTableItems.setMinimumSize(new java.awt.Dimension(900, 100));

        GroupLayout productTableItemsLayout = new GroupLayout(productTableItems);
        productTableItems.setLayout(productTableItemsLayout);

        GroupLayout.ParallelGroup horzGroup = productTableItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.SequentialGroup vertGroup = productTableItemsLayout.createSequentialGroup();

        for (Order order : orders) {
            OrderTableItem orderTableItem = new OrderTableItem(order);
            orderTableItems.add(orderTableItem);
            horzGroup.addComponent(orderTableItem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
            vertGroup.addComponent(orderTableItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);//.addGap(0, 0, Short.MAX_VALUE);
        }

        productTableItemsLayout.setHorizontalGroup(horzGroup);

        productTableItemsLayout.setVerticalGroup(
                productTableItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(vertGroup).addGap(0,244,Short.MAX_VALUE)
        );

        productTable.setViewportView(productTableItems);
    }
}
