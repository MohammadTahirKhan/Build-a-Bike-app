package gui.Panels;

import gui.Frames.BaseFrame;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StockBrowse extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private JLabel brandName;
    private JLabel productName;
    private JScrollPane productTable;
    private JPanel productTableItems;
    private JButton selectFrameSets;
    private JButton selectHandlebars;
    private JButton selectWheels;
    private JLabel serialNumber;
    private JPanel stockNav;
    private JPanel tableHeadingLabels;
    private JLabel unitCost;
    private JButton addStock;

    private ArrayList<TableItem> productItems = new ArrayList<>();
    private BaseFrame parentFrame;


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
        unitCost = new JLabel();
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

        unitCost.setText("Unit Cost");

        brandName.setText("Brand Name");

        GroupLayout tableHeadingLabelsLayout = new GroupLayout(tableHeadingLabels);
        tableHeadingLabels.setLayout(tableHeadingLabelsLayout);
        tableHeadingLabelsLayout.setHorizontalGroup(
            tableHeadingLabelsLayout.createParallelGroup(LEADING)
            .addGroup(tableHeadingLabelsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(productName, PREFERRED, 169, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT, Short.MAX_VALUE)
                .addComponent(unitCost, PREFERRED, 139, PREFERRED)
                .addGap(50, 50, 50)
                .addComponent(brandName, PREFERRED, 139, PREFERRED)
                .addGap(36, 36, 36)
                .addComponent(serialNumber, PREFERRED, 139, PREFERRED)
                .addGap(38, 38, 38))
        );
        tableHeadingLabelsLayout.setVerticalGroup(
            tableHeadingLabelsLayout.createParallelGroup(LEADING)
            .addGroup(TRAILING, tableHeadingLabelsLayout.createSequentialGroup()
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

        GroupLayout productTableItemsLayout = new GroupLayout(productTableItems);

        GroupLayout.SequentialGroup sequentialGroup = productTableItemsLayout.createSequentialGroup();

        for (TableItem item : productItems) {
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
        selectWheels.setText("Wheels");
        selectFrameSets.setText("Frame-Sets");
        selectHandlebars.setText("Handlebars");
        addStock.setText("Add New Stock");
        selectWheels.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: link to back
                System.out.println("wheels selected");
			}
		});

        selectFrameSets.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: link to back
                System.out.println("framesets selected");
			}
		});

        selectHandlebars.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: link to back
                System.out.println("handlebars selected");
			}
		});

        addStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                System.out.println("add stock selected");
                parentFrame.displayPanel(parentFrame.addStock, false, false, false, true, true);	
			}
		});
	}                                                     
}
