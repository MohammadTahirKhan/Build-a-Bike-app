package gui.Panels;

import javax.swing.*;
import java.util.ArrayList;

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

        serialNumber.setText("Status");

        cost.setText("Cost");

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

        productTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        productTableItems.setMaximumSize(new java.awt.Dimension(900, 32767));
        productTableItems.setMinimumSize(new java.awt.Dimension(900, 100));

        GroupLayout productTableItemsLayout = new GroupLayout(productTableItems);

        GroupLayout.SequentialGroup sequentialGroup = productTableItemsLayout.createSequentialGroup();

        for (TableItem item : orders) {
            sequentialGroup.addComponent(item, PREFERRED, DEFAULT, PREFERRED).addGap(0, 0, Short.MAX_VALUE);
        }

        productTableItems.setLayout(productTableItemsLayout);
        productTableItemsLayout.setHorizontalGroup(
                productTableItemsLayout.createParallelGroup(LEADING)
                        .addGroup(sequentialGroup)
        );
        productTableItemsLayout.setVerticalGroup(
                productTableItemsLayout.createParallelGroup(LEADING)
                        .addGroup(sequentialGroup)
        );

        productTable.setViewportView(productTableItems);

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

    private void initializeButtons() {
        pending.setText("Pending");
        confirmed.setText("Confirmed");
        fulfilled.setText("Fulfilled");
        all.setText("All");

        pending.addActionListener(e -> {
            // TODO: link to back
            System.out.println("pending selected");
        });

        confirmed.addActionListener(e -> {
            // TODO: link to back
            System.out.println("confirmed selected");
        });

        fulfilled.addActionListener(e -> {
            // TODO: link to back
            System.out.println("fulfilled selected");
        });

        all.addActionListener(e -> {
// TODO: link to back
            System.out.println("all selected");
        });
    }
}