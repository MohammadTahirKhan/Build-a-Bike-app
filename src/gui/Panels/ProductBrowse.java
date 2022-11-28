package gui.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

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

    private ArrayList<ProductPanel> productPanels = new ArrayList<>();
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
        selectWheels.addActionListener(this::selectWheelsActionPerformed);

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

        GroupLayout.SequentialGroup allProductsSequentialGroup = allProductsLayout.createSequentialGroup().addContainerGap();
        GroupLayout.ParallelGroup allProductsParallelGroup = allProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false);

        for (JPanel productPanel : productPanels) {
            allProductsSequentialGroup.addComponent(productPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
            allProductsSequentialGroup.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
            allProductsParallelGroup.addComponent(productPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        }

        allProducts.setLayout(allProductsLayout);
        allProductsLayout.setHorizontalGroup(
                allProductsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(allProductsSequentialGroup));

        allProductsLayout.setVerticalGroup(
                allProductsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(allProductsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(allProductsParallelGroup)
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
