package gui.Panels;

import javax.swing.*;

public class StockBrowse extends JPanel {
    private final JFrame frame;
    final private JPanel stockNav = new JPanel();
    private final JButton selectWheels = new JButton();
    private final JButton selectFrameSets = new JButton();
    private final JButton selectHandlebars = new JButton();
    private final JLabel brandName = new JLabel();
    private final JButton viewOrder = new JButton();
    private final JPanel tableHeadingLabels = new JPanel();
    private final JLabel productName = new JLabel();
    private final JLabel serialNumber = new JLabel();
    private final JLabel unitCost = new JLabel();
    private final JScrollPane productTable = new JScrollPane();
    private final JPanel productTableItems = new JPanel();
    private final JPanel productItem = new JPanel();
    private final JLabel itemName = new JLabel();
    private final JLabel itemCost = new JLabel();
    private final JLabel itemBrandName = new JLabel();
    private final JLabel itemSerialNumber = new JLabel();
    private final JMenuBar header = new JMenuBar();
    private final JMenu staffPortal = new JMenu();

    public StockBrowse(JFrame _frame) {
        frame = _frame;
        initComponents();
    }

    private void initComponents() {

        JMenu reviewExistingOrder = new JMenu();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Bikes Ltd.");
        setMinimumSize(new java.awt.Dimension(900, 500));
        setPreferredSize(new java.awt.Dimension(900, 500));
        setSize(new java.awt.Dimension(900, 500));

        stockNav.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        selectWheels.setText("Wheels");
        selectWheels.addActionListener(this::selectWheelsActionPerformed);

        selectFrameSets.setText("Frame-Sets");

        selectHandlebars.setText("Handlebars");

        viewOrder.setText("Add New Stock");

        javax.swing.GroupLayout stockNavLayout = new javax.swing.GroupLayout(stockNav);
        stockNav.setLayout(stockNavLayout);
        stockNavLayout.setHorizontalGroup(
                stockNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(stockNavLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(selectWheels, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectFrameSets, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectHandlebars, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        stockNavLayout.setVerticalGroup(
                stockNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stockNavLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(stockNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(selectWheels, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectFrameSets, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectHandlebars, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(viewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        productName.setText("Product Name");

        serialNumber.setText("Serial Number");

        unitCost.setText("Unit Cost");

        brandName.setText("Brand Name");

        javax.swing.GroupLayout tableHeadingLabelsLayout = new javax.swing.GroupLayout(tableHeadingLabels);
        tableHeadingLabels.setLayout(tableHeadingLabelsLayout);
        tableHeadingLabelsLayout.setHorizontalGroup(
                tableHeadingLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tableHeadingLabelsLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(unitCost, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(brandName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(serialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
        );
        tableHeadingLabelsLayout.setVerticalGroup(
                tableHeadingLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tableHeadingLabelsLayout.createSequentialGroup()
                                .addContainerGap(16, Short.MAX_VALUE)
                                .addGroup(tableHeadingLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(productName)
                                        .addComponent(serialNumber)
                                        .addComponent(unitCost)
                                        .addComponent(brandName))
                                .addContainerGap())
        );

        productTable.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        productTableItems.setMaximumSize(new java.awt.Dimension(900, 32767));
        productTableItems.setMinimumSize(new java.awt.Dimension(900, 100));

        productItem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        itemName.setText("insert dummy text here wowow");

        itemCost.setText("125.00");

        itemBrandName.setText("lorem mf ipsum");

        itemSerialNumber.setText("018274013");

        javax.swing.GroupLayout productItemLayout = new javax.swing.GroupLayout(productItem);
        productItem.setLayout(productItemLayout);
        productItemLayout.setHorizontalGroup(
                productItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(productItemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(itemCost, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(itemBrandName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(itemSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(17, Short.MAX_VALUE))
        );
        productItemLayout.setVerticalGroup(
                productItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(productItemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(productItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(itemName)
                                        .addComponent(itemCost)
                                        .addComponent(itemBrandName)
                                        .addComponent(itemSerialNumber))
                                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout productTableItemsLayout = new javax.swing.GroupLayout(productTableItems);
        productTableItems.setLayout(productTableItemsLayout);
        productTableItemsLayout.setHorizontalGroup(
                productTableItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(productTableItemsLayout.createSequentialGroup()
                                .addComponent(productItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        productTableItemsLayout.setVerticalGroup(
                productTableItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(productTableItemsLayout.createSequentialGroup()
                                .addComponent(productItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 485, Short.MAX_VALUE))
        );

        productTable.setViewportView(productTableItems);

        javax.swing.GroupLayout stockBrowseMainLayout = new javax.swing.GroupLayout(this);
        this.setLayout(stockBrowseMainLayout);
        stockBrowseMainLayout.setHorizontalGroup(
                stockBrowseMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(stockBrowseMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(stockBrowseMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(stockNav, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tableHeadingLabels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stockBrowseMainLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(productTable, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
        );
        stockBrowseMainLayout.setVerticalGroup(
                stockBrowseMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(stockBrowseMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(stockNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tableHeadingLabels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(productTable, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
        );

        staffPortal.setText("Staff Portal");
        staffPortal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        header.add(staffPortal);

        reviewExistingOrder.setText("Review Existing Order");
        reviewExistingOrder.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        header.add(reviewExistingOrder);

        frame.setJMenuBar(header);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(this, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(this, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        frame.pack();
    }

    private void selectWheelsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
}
