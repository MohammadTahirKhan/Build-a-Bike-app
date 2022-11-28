package gui.Frames;

import javax.swing.*;
import javax.swing.border.*;
public class StockBrowse extends JPanel {
    private JLabel brandName;
    private JMenuBar header;
    private JLabel itemBrandName;
    private JLabel itemCost;
    private JLabel itemName;
    private JLabel itemSerialNumber;
    private JPanel productItem;
    private JLabel productName;
    private JScrollPane productTable;
    private JPanel productTableItems;
    private JMenu reviewExistingOrder;
    private JButton selectFrameSets;
    private JButton selectHandlebars;
    private JButton selectWheels;
    private JLabel serialNumber;
    private JMenu staffPortal;
    private JPanel stockBrowseMain;
    private JPanel stockNav;
    private JPanel tableHeadingLabels;
    private JLabel unitCost;
    private JButton viewOrder;

    public StockBrowse() {
        stockNav = new JPanel();
        selectWheels = new JButton();
        selectFrameSets = new JButton();
        selectHandlebars = new JButton();
        viewOrder = new JButton();
        tableHeadingLabels = new JPanel();
        productName = new JLabel();
        serialNumber = new JLabel();
        unitCost = new JLabel();
        brandName = new JLabel();
        productTable = new JScrollPane();
        productTableItems = new JPanel();
        productItem = new JPanel();
        itemName = new JLabel();
        itemCost = new JLabel();
        itemBrandName = new JLabel();
        itemSerialNumber = new JLabel();
        header = new JMenuBar();
        staffPortal = new JMenu();
        reviewExistingOrder = new JMenu();

        stockNav.setBorder(BorderFactory.createEtchedBorder());

        selectWheels.setText("Wheels");
        selectWheels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectWheelsActionPerformed(evt);
            }
        });

        selectFrameSets.setText("Frame-Sets");

        selectHandlebars.setText("Handlebars");

        viewOrder.setText("Add New Stock");

        GroupLayout stockNavLayout = new GroupLayout(stockNav);
        stockNav.setLayout(stockNavLayout);
        stockNavLayout.setHorizontalGroup(
            stockNavLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(stockNavLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(selectWheels, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectFrameSets, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectHandlebars, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewOrder, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        stockNavLayout.setVerticalGroup(
            stockNavLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, stockNavLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stockNavLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(selectWheels, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectFrameSets, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectHandlebars, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewOrder, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        productName.setText("Product Name");

        serialNumber.setText("Serial Number");

        unitCost.setText("Unit Cost");

        brandName.setText("Brand Name");

        GroupLayout tableHeadingLabelsLayout = new GroupLayout(tableHeadingLabels);
        tableHeadingLabels.setLayout(tableHeadingLabelsLayout);
        tableHeadingLabelsLayout.setHorizontalGroup(
            tableHeadingLabelsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(tableHeadingLabelsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(productName, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(unitCost, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(brandName, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(serialNumber, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        tableHeadingLabelsLayout.setVerticalGroup(
            tableHeadingLabelsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, tableHeadingLabelsLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(tableHeadingLabelsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(productName)
                    .addComponent(serialNumber)
                    .addComponent(unitCost)
                    .addComponent(brandName))
                .addContainerGap())
        );

        productTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        productTableItems.setMaximumSize(new java.awt.Dimension(900, 32767));
        productTableItems.setMinimumSize(new java.awt.Dimension(900, 100));

        productItem.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        itemName.setText("insert dummy text here wowow");

        itemCost.setText("125.00");

        itemBrandName.setText("lorem mf ipsum");

        itemSerialNumber.setText("018274013");

        GroupLayout productItemLayout = new GroupLayout(productItem);
        productItem.setLayout(productItemLayout);
        productItemLayout.setHorizontalGroup(
            productItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(productItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemName, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(itemCost, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(itemBrandName, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(itemSerialNumber, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        productItemLayout.setVerticalGroup(
            productItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(productItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productItemLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(itemName)
                    .addComponent(itemCost)
                    .addComponent(itemBrandName)
                    .addComponent(itemSerialNumber))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        GroupLayout productTableItemsLayout = new GroupLayout(productTableItems);
        productTableItems.setLayout(productTableItemsLayout);
        productTableItemsLayout.setHorizontalGroup(
            productTableItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(productTableItemsLayout.createSequentialGroup()
                .addComponent(productItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        productTableItemsLayout.setVerticalGroup(
            productTableItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(productTableItemsLayout.createSequentialGroup()
                .addComponent(productItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 485, Short.MAX_VALUE))
        );

        productTable.setViewportView(productTableItems);

        GroupLayout stockBrowseMainLayout = new GroupLayout(stockBrowseMain);
        stockBrowseMain.setLayout(stockBrowseMainLayout);
        stockBrowseMainLayout.setHorizontalGroup(
            stockBrowseMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(stockBrowseMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stockBrowseMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(stockNav, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tableHeadingLabels, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, stockBrowseMainLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(productTable, GroupLayout.PREFERRED_SIZE, 819, GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        stockBrowseMainLayout.setVerticalGroup(
            stockBrowseMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(stockBrowseMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stockNav, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableHeadingLabels, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(productTable, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        staffPortal.setText("Staff Portal");
        staffPortal.setHorizontalAlignment(SwingConstants.RIGHT);
        header.add(staffPortal);

        reviewExistingOrder.setText("Review Existing Order");
        reviewExistingOrder.setHorizontalAlignment(SwingConstants.RIGHT);
        header.add(reviewExistingOrder);
    }                    

    private void selectWheelsActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                                          
}

