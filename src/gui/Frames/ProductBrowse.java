package gui.Frames;

import javax.swing.*;
import javax.swing.GroupLayout.ParallelGroup;

import java.awt.*;
import java.awt.event.*;

public class ProductBrowse extends JPanel {
        private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
        private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
        private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
        private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private JPanel allProducts;
    private JMenuBar header;
    private JPanel orderNav;
    private JPanel productBrowseMain;
    private JPanel productFilters;
    private JScrollPane productView;
    private JMenu reviewExistingOrder;
    private JButton selectFrameSets;
    private JButton selectHandlebars;
    private JButton selectWheels;
    private Choice sortBy;
    private Label sortByLabel;
    private JMenu staffPortal;
    private JButton viewOrder;

    public ProductBrowse() {
        productBrowseMain = new JPanel();
        orderNav = new JPanel();
        selectWheels = new JButton();
        selectFrameSets = new JButton();
        selectHandlebars = new JButton();
        viewOrder = new JButton();
        productFilters = new JPanel();
        sortBy = new Choice();
        sortByLabel = new Label();
        productView = new JScrollPane();
        allProducts = new JPanel();

        orderNav.setBorder(BorderFactory.createEtchedBorder());

        selectWheels.setText("Select Wheels");
        selectWheels.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                selectWheelsActionPerformed(evt);
            }
        });

        selectFrameSets.setText("Select Frame-Sets");

        selectHandlebars.setText("Select Handlebars");

        viewOrder.setText("View Order");

        GroupLayout orderNavLayout = new GroupLayout(orderNav);
        orderNav.setLayout(orderNavLayout);
        orderNavLayout.setHorizontalGroup(
                orderNavLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(orderNavLayout.createSequentialGroup()
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
        orderNavLayout.setVerticalGroup(
                orderNavLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, orderNavLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(orderNavLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(selectWheels, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectFrameSets, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectHandlebars, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(viewOrder, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        sortByLabel.setText("Sort by:");

        GroupLayout productFiltersLayout = new GroupLayout(productFilters);
        productFilters.setLayout(productFiltersLayout);
        productFiltersLayout.setHorizontalGroup(
                productFiltersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, productFiltersLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sortByLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sortBy, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)));
        productFiltersLayout.setVerticalGroup(
                productFiltersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sortBy, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(sortByLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        productView.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        GroupLayout allProductsLayout = new GroupLayout(allProducts);
        allProducts.setLayout(allProductsLayout);
        ParallelGroup test = allProductsLayout.setHorizontalGroup(
                allProductsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(allProductsLayout.createSequentialGroup()))
                                //.addContainerGap()
                                // .addComponent(productPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                // .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // .addComponent(productPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                // .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // .addComponent(productPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                // .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // .addComponent(productPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                // .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // .addComponent(productPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                // .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // .addComponent(productPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                //.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        allProductsLayout.setVerticalGroup(
                allProductsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(allProductsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(allProductsLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(productPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(productPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(productPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(productPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(productPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(productPanel5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        productView.setViewportView(allProducts);

        GroupLayout productBrowseMainLayout = new GroupLayout(productBrowseMain);
        productBrowseMain.setLayout(productBrowseMainLayout);
        productBrowseMainLayout.setHorizontalGroup(
                productBrowseMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(productBrowseMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(productBrowseMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(orderNav, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(productFilters, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(productView, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );
        productBrowseMainLayout.setVerticalGroup(
                productBrowseMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(productBrowseMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(orderNav, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(productFilters, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(productView, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                                .addContainerGap())
        );

        staffPortal.setText("Staff Portal");
        staffPortal.setHorizontalAlignment(SwingConstants.RIGHT);
        header.add(staffPortal);

        reviewExistingOrder.setText("Review Existing Order");
        reviewExistingOrder.setHorizontalAlignment(SwingConstants.RIGHT);
        header.add(reviewExistingOrder);
    }

    private void selectWheelsActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }
}
