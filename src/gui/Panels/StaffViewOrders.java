package gui.Panels;

import Order.Order;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;

import static SQL.Queries.Order.SQLOrder.getOrders;
import static SQL.Queries.Order.SQLOrder.getOrders;

public class StaffViewOrders extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private final JLabel status;
    private final JLabel orderNumber;
    private final JScrollPane productTable;
    private final JPanel productTableItems;
    private final JButton confirmed;
    private final JButton fulfilled;
    private final JButton pending;
    private final JLabel serialNumber;
    private final JPanel stockNav;
    private final JPanel tableHeadingLabels;
    private final JLabel cost;
    private final JButton all;

    private HashSet<TableItem> productTableItemsList = new HashSet<>();

    private final ArrayList<TableItem> orders = new ArrayList<>();

    public StaffViewOrders() {
        stockNav = new JPanel();
        pending = new JButton();
        confirmed = new JButton();
        fulfilled = new JButton();
        all = new JButton();
        tableHeadingLabels = new JPanel();
        orderNumber = new JLabel();
        serialNumber = new JLabel();
        cost = new JLabel();
        status = new JLabel();
        productTable = new JScrollPane();
        productTableItems = new JPanel();

        initializeButtons();

        stockNav.setBorder(BorderFactory.createEtchedBorder());

        GroupLayout stockNavLayout = new GroupLayout(stockNav);
        stockNav.setLayout(stockNavLayout);
        stockNavLayout.setHorizontalGroup(
            stockNavLayout.createParallelGroup(LEADING)
            .addGroup(stockNavLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pending, PREFERRED, 212, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmed, PREFERRED, 212, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fulfilled, PREFERRED, 212, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(all, PREFERRED, 214, PREFERRED)
                .addContainerGap(DEFAULT, Short.MAX_VALUE))
        );
        stockNavLayout.setVerticalGroup(
            stockNavLayout.createParallelGroup(LEADING)
            .addGroup(TRAILING, stockNavLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stockNavLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(pending, PREFERRED, 100, PREFERRED)
                    .addComponent(confirmed, PREFERRED, 100, PREFERRED)
                    .addComponent(fulfilled, PREFERRED, 100, PREFERRED)
                    .addComponent(all, PREFERRED, 100, PREFERRED))
                .addContainerGap())
        );

        orderNumber.setText("Order Number");

        serialNumber.setText("Cost");

        cost.setText("serialNumber");

        status.setText("Status");

        GroupLayout tableHeadingLabelsLayout = new GroupLayout(tableHeadingLabels);
        tableHeadingLabels.setLayout(tableHeadingLabelsLayout);
        tableHeadingLabelsLayout.setHorizontalGroup(
            tableHeadingLabelsLayout.createParallelGroup(LEADING)
            .addGroup(tableHeadingLabelsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(orderNumber, PREFERRED, 169, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT, Short.MAX_VALUE)
                .addComponent(cost, PREFERRED, 139, PREFERRED)
                .addGap(50, 50, 50)
                .addComponent(status, PREFERRED, 139, PREFERRED)
                .addGap(36, 36, 36)
                .addComponent(serialNumber, PREFERRED, 139, PREFERRED)
                .addGap(38, 38, 38))
        );
        tableHeadingLabelsLayout.setVerticalGroup(
            tableHeadingLabelsLayout.createParallelGroup(LEADING)
            .addGroup(TRAILING, tableHeadingLabelsLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(tableHeadingLabelsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(orderNumber)
                    .addComponent(serialNumber)
                    .addComponent(cost)
                    .addComponent(status))
                .addContainerGap())
        );

        initPanels();

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(LEADING)
                    .addComponent(stockNav, TRAILING, DEFAULT, DEFAULT, Short.MAX_VALUE)
                    .addComponent(tableHeadingLabels, DEFAULT, DEFAULT, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(TRAILING, layout.createSequentialGroup()
                .addContainerGap(DEFAULT, Short.MAX_VALUE)
                .addComponent(productTable, PREFERRED, 819, PREFERRED)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(stockNav, PREFERRED, DEFAULT, PREFERRED)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tableHeadingLabels, PREFERRED, DEFAULT, PREFERRED)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT, Short.MAX_VALUE)
                                .addComponent(productTable, PREFERRED, 276, PREFERRED)
                                .addGap(41, 41, 41))
        );
    }

    public void initPanels() {
        productTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        productTableItems.setMaximumSize(new java.awt.Dimension(900, 32767));
        productTableItems.setMinimumSize(new java.awt.Dimension(900, 100));

        productTableItems.removeAll();

        GroupLayout productTableItemsLayout = new GroupLayout(productTableItems);
        productTableItems.setLayout(productTableItemsLayout);

        GroupLayout.ParallelGroup horzGroup = productTableItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.SequentialGroup vertGroup = productTableItemsLayout.createSequentialGroup();

        for (TableItem order : productTableItemsList) {
            horzGroup.addComponent(order, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
            vertGroup.addComponent(order, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);//.addGap(0, 0, Short.MAX_VALUE);
        }

        productTableItemsLayout.setHorizontalGroup(horzGroup);

        productTableItemsLayout.setVerticalGroup(
                productTableItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(vertGroup).addGap(0, 244, Short.MAX_VALUE)
        );

        productTable.setViewportView(productTableItems);
    }

    private void initializeButtons() {
        pending.setText("Pending");
        confirmed.setText("Confirmed");
        fulfilled.setText("Fulfilled");
        all.setText("All");

        pending.addActionListener(e -> {
            HashSet<Order> pendingOrders = new HashSet<>(getOrders(Order.Status.PENDING));
            productTableItemsList = new HashSet<>();
            if (pendingOrders.size() > 0) {
                for (Order order : pendingOrders) {
                    productTableItemsList.add(new TableItem(order));
                }
            }
            initPanels();
        });

        confirmed.addActionListener(e -> {
            HashSet<Order> pendingOrders = new HashSet<>(getOrders(Order.Status.CONFIRMED));
            productTableItemsList = new HashSet<>();
            if (pendingOrders.size() > 0) {
                for (Order order : pendingOrders) {
                    productTableItemsList.add(new TableItem(order));
                }
            }
            initPanels();
        });

        fulfilled.addActionListener(e -> {
            HashSet<Order> pendingOrders = new HashSet<>(getOrders(Order.Status.FULFILLED));
            productTableItemsList = new HashSet<>();
            if (pendingOrders.size() > 0) {
                for (Order order : pendingOrders) {
                    productTableItemsList.add(new TableItem(order));
                }
            }
            initPanels();
        });

        all.addActionListener(e -> {
            HashSet<Order> pendingOrders = new HashSet<>(getOrders(Order.Status.All));
            productTableItemsList = new HashSet<>();
            if (pendingOrders.size() > 0) {
                for (Order order : pendingOrders) {
                    productTableItemsList.add(new TableItem(order));
                }
            }
            initPanels();
        });
    }
}