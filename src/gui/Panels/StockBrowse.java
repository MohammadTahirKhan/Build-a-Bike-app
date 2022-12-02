package gui.Panels;

import Product.Frame;
import Product.HandleBar;
import Product.Product;
import Product.Wheels;
import gui.Frames.BaseFrame;

import javax.swing.*;
import java.util.ArrayList;

import static SQL.Queries.Product.SQLFrame.getAllFrame;
import static SQL.Queries.Product.SQLHandleBar.getAllHandleBar;
import static SQL.Queries.Product.SQLWheels.getAllWheels;

public class StockBrowse extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private final JLabel brandName;
    private final JLabel productName;
    private final JScrollPane productTable;
    private final JPanel productTableItems;
    private final JButton selectFrameSets;
    private final JButton selectHandlebars;
    private final JButton selectWheels;
    private final JLabel serialNumber;
    private final JPanel stockNav;
    private final JPanel tableHeadingLabels;
    private final JLabel stockAmount;
    private final JButton addStock;

    private final ArrayList<TableItem> productItems = new ArrayList<>();
    private final BaseFrame parentFrame;


    public StockBrowse(BaseFrame baseFrame) {
        this.parentFrame = baseFrame;
        stockNav = new JPanel();
        selectWheels = new JButton();
        selectFrameSets = new JButton();
        selectHandlebars = new JButton();
        addStock = new JButton();
        tableHeadingLabels = new JPanel();
        productName = new JLabel();
        serialNumber = new JLabel();
        stockAmount = new JLabel();
        brandName = new JLabel();
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
                .addComponent(selectWheels, PREFERRED, 212, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectFrameSets, PREFERRED, 212, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectHandlebars, PREFERRED, 212, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addStock, PREFERRED, 214, PREFERRED)
                .addContainerGap(DEFAULT, Short.MAX_VALUE))
        );
        stockNavLayout.setVerticalGroup(
            stockNavLayout.createParallelGroup(LEADING)
            .addGroup(TRAILING, stockNavLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stockNavLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(selectWheels, PREFERRED, 100, PREFERRED)
                    .addComponent(selectFrameSets, PREFERRED, 100, PREFERRED)
                    .addComponent(selectHandlebars, PREFERRED, 100, PREFERRED)
                    .addComponent(addStock, PREFERRED, 100, PREFERRED))
                .addContainerGap())
        );

        productName.setText("Product Name");

        serialNumber.setText("Serial Number");

        brandName.setText("Brand Name");

        stockAmount.setText("Stock");

        GroupLayout tableHeadingLabelsLayout = new GroupLayout(tableHeadingLabels);
        tableHeadingLabels.setLayout(tableHeadingLabelsLayout);
        tableHeadingLabelsLayout.setHorizontalGroup(
            tableHeadingLabelsLayout.createParallelGroup(LEADING)
            .addGroup(tableHeadingLabelsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(productName, PREFERRED, 169, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT, Short.MAX_VALUE)
                .addComponent(serialNumber, PREFERRED, 139, PREFERRED)
                .addGap(50, 50, 50)
                .addComponent(brandName, PREFERRED, 139, PREFERRED)
                .addGap(36, 36, 36)
                .addComponent(stockAmount, PREFERRED, 139, PREFERRED)
                .addGap(38, 38, 38))
        );
        tableHeadingLabelsLayout.setVerticalGroup(
            tableHeadingLabelsLayout.createParallelGroup(LEADING)
            .addGroup(TRAILING, tableHeadingLabelsLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(tableHeadingLabelsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(productName)
                    .addComponent(serialNumber)
                    .addComponent(brandName)
                    .addComponent(stockAmount))
                .addContainerGap())
        );

        productTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        populateTable();


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
        productTable.setViewportView(productTableItems);
    }

    public void populateTable() {
        productTableItems.removeAll();


        productTableItems.setMaximumSize(new java.awt.Dimension(900, 32767));
        productTableItems.setMinimumSize(new java.awt.Dimension(900, 100));
        GroupLayout productTableItemsLayout = new GroupLayout(productTableItems);

        GroupLayout.ParallelGroup parallelGroup = productTableItemsLayout.createParallelGroup();
        GroupLayout.SequentialGroup sequentialGroup = productTableItemsLayout.createSequentialGroup();


        for (TableItem item : productItems) {
            parallelGroup.addComponent(item, PREFERRED, DEFAULT, PREFERRED);
            sequentialGroup.addComponent(item, PREFERRED, DEFAULT, PREFERRED).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        }

        productTableItems.setLayout(productTableItemsLayout);
        productTableItemsLayout.setHorizontalGroup(
                productTableItemsLayout.createParallelGroup(LEADING)
                        .addGroup(parallelGroup)
                        .addGap(0, 81, Short.MAX_VALUE)
        );
        productTableItemsLayout.setVerticalGroup(
                productTableItemsLayout.createParallelGroup(LEADING)
                        .addGroup(sequentialGroup)
        );
    }

    private void initializeButtons() {
        selectWheels.setText("Wheels");
        selectFrameSets.setText("Frame-Sets");
        selectHandlebars.setText("Handlebars");
        addStock.setText("Add New Stock");
        selectWheels.addActionListener(e -> populateTableItems(Product.Products.WHEELS));

        selectFrameSets.addActionListener(e -> populateTableItems(Product.Products.FRAME));

        selectHandlebars.addActionListener(e -> populateTableItems(Product.Products.HANDLEBAR));

        addStock.addActionListener(e -> parentFrame.displayPanel(parentFrame.addStock, false, false, false, true, true));
    }

    private void populateTableItems(Product.Products productType) {
        ArrayList<Product> products = new ArrayList<>();
        switch (productType) {
            case WHEELS:
                ArrayList<Wheels> wheels = getAllWheels();
                products.addAll(wheels);
                break;
            case FRAME:
                ArrayList<Frame> frames = getAllFrame();
                products.addAll(frames);
                break;
            case HANDLEBAR:
                ArrayList<HandleBar> handlebars = getAllHandleBar();
                products.addAll(handlebars);
                break;
        }
        productItems.clear();
        products.forEach(product -> productItems.add(new TableItem(product)));
        populateTable();
    }
}

