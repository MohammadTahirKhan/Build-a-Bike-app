package gui.Panels;

import Product.Product;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProductBrowse extends JPanel {
    private final JFrame frame;
    private final JPanel orderNav = new JPanel();
    private final JButton selectWheels = new JButton();
    private final JButton selectHandlebars = new JButton();
    private final JButton selectFrameSets = new JButton();
    private final JButton viewOrder = new JButton();
    private final JPanel productFilters = new JPanel();
    private final Choice sortBy = new Choice();
    private final Label sortByLabel = new Label();
    private final JScrollPane productView = new JScrollPane();
    private final JPanel allProducts = new JPanel();
    private final JMenuBar header = new JMenuBar();
    private final JMenu staffPortal = new JMenu();
    private final JMenu reviewExistingOrder = new JMenu();
    private ArrayList<JPanel> productPanels;

    public void clearProductPanels() {
        this.productPanels.clear();
    }

    public ProductBrowse(JFrame _frame) {
        frame = _frame;
        initComponents();
    }

    private void selectWheelsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public ProductBrowse(JFrame _frame, ArrayList<Product> products) {
        frame = _frame;
        for (Product product : products) {
            addProductPanel(product);
        }
        initComponents();
    }

    public void addProductPanel(Product product) {
        this.productPanels.add(new ProductPanel(product));
    }

    private void initComponents() {

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Bikes Ltd.");

        orderNav.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        selectWheels.setText("Select Wheels");
        selectWheels.addActionListener(this::selectWheelsActionPerformed);

        selectFrameSets.setText("Select Frame-Sets");

        selectHandlebars.setText("Select Handlebars");

        viewOrder.setText("View Order");

        javax.swing.GroupLayout orderNavLayout = new javax.swing.GroupLayout(orderNav);
        orderNav.setLayout(orderNavLayout);
        orderNavLayout.setHorizontalGroup(
                orderNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(orderNavLayout.createSequentialGroup()
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
        orderNavLayout.setVerticalGroup(
                orderNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderNavLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(orderNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(selectWheels, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectFrameSets, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectHandlebars, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(viewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        sortByLabel.setText("Sort by:");

        javax.swing.GroupLayout productFiltersLayout = new javax.swing.GroupLayout(productFilters);
        productFilters.setLayout(productFiltersLayout);
        productFiltersLayout.setHorizontalGroup(
                productFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productFiltersLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sortByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );
        productFiltersLayout.setVerticalGroup(
                productFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sortBy, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(sortByLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        productView.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);


        javax.swing.GroupLayout allProductsLayout = new javax.swing.GroupLayout(allProducts);
        allProducts.setLayout(allProductsLayout);

        GroupLayout.SequentialGroup allProductsSequentialGroup = allProductsLayout.createSequentialGroup().addContainerGap();
        GroupLayout.ParallelGroup allProductsParallelGroup = allProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false);

        for (JPanel productPanel : productPanels) {
            allProductsSequentialGroup.addComponent(productPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
            allProductsSequentialGroup.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
            allProductsParallelGroup.addComponent(productPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        }

        allProductsSequentialGroup.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);

        allProductsLayout.setHorizontalGroup(
                allProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(allProductsSequentialGroup)
        );
        allProductsLayout.setVerticalGroup(
                allProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(allProductsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(allProductsParallelGroup)
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        productView.setViewportView(allProducts);

        javax.swing.GroupLayout productBrowseMainLayout = new javax.swing.GroupLayout(this);
        this.setLayout(productBrowseMainLayout);
        productBrowseMainLayout.setHorizontalGroup(
                productBrowseMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(productBrowseMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(productBrowseMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(orderNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(productFilters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(productView, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );
        productBrowseMainLayout.setVerticalGroup(
                productBrowseMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(productBrowseMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(orderNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(productFilters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(productView, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                                .addContainerGap())
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
                        .addComponent(this, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frame.pack();
    }
}
