package gui.Panels;


import Product.Frame;
import Product.HandleBar;
import Product.Product;
import Product.Wheels;
import gui.Frames.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static SQL.Queries.Product.SQLFrame.getAllFrame;
import static SQL.Queries.Product.SQLHandleBar.getAllHandleBar;
import static SQL.Queries.Product.SQLWheels.getAllWheels;

public class ProductBrowse extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final LayoutStyle.ComponentPlacement RELATED = LayoutStyle.ComponentPlacement.RELATED;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private final BaseFrame parentFrame;
    private JPanel allProducts;
    private final JPanel orderNav;
    private final JPanel productFilters;
    private final JScrollPane productView;

    private final JButton selectFrameSets;
    private final JButton selectHandlebars;
    private final JButton selectWheels;
    private final JButton viewOrder;

    private final Choice sortBy;
    private final Label sortByLabel;

    private final ArrayList<ProductPanel> productPanels = new ArrayList<>();

    public ProductBrowse(BaseFrame parentFrame) {
        this.parentFrame = parentFrame;
        orderNav = new JPanel();
        selectWheels = new JButton();
        selectFrameSets = new JButton();
        selectHandlebars = new JButton();
        viewOrder = new JButton();
		productFilters = new JPanel();
		sortBy = new Choice();
		sortByLabel = new Label();
		productView = new JScrollPane();


		orderNav.setBorder(BorderFactory.createEtchedBorder());

		initializeButtons();

		GroupLayout orderNavLayout = new GroupLayout(orderNav);
		orderNav.setLayout(orderNavLayout);
		orderNavLayout.setHorizontalGroup(
				orderNavLayout.createParallelGroup(LEADING)
						.addGroup(orderNavLayout.createSequentialGroup()
								.addGap(16, 16, 16)
								.addComponent(selectWheels, PREFERRED, 212, PREFERRED)
								.addPreferredGap(RELATED)
								.addComponent(selectFrameSets, PREFERRED, 212,
										PREFERRED)
								.addPreferredGap(RELATED)
								.addComponent(selectHandlebars, PREFERRED, 212,
										PREFERRED)
								.addPreferredGap(RELATED)
								.addComponent(viewOrder, PREFERRED, 214, PREFERRED)
								.addContainerGap(DEFAULT, Short.MAX_VALUE)));
		orderNavLayout.setVerticalGroup(
				orderNavLayout.createParallelGroup(LEADING)
						.addGroup(TRAILING, orderNavLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(orderNavLayout.createParallelGroup(
										GroupLayout.Alignment.CENTER)
										.addComponent(selectWheels, PREFERRED,
												100, PREFERRED)
										.addComponent(selectFrameSets,
												PREFERRED, 100,
												PREFERRED)
										.addComponent(selectHandlebars,
												PREFERRED, 100,
												PREFERRED)
										.addComponent(viewOrder, PREFERRED, 100,
												PREFERRED))
								.addContainerGap()));

		sortByLabel.setText("Sort by:");

		GroupLayout productFiltersLayout = new GroupLayout(productFilters);
		productFilters.setLayout(productFiltersLayout);
		productFiltersLayout.setHorizontalGroup(
				productFiltersLayout.createParallelGroup(LEADING)
						.addGroup(TRAILING, productFiltersLayout.createSequentialGroup()
								.addContainerGap(DEFAULT, Short.MAX_VALUE)
								.addComponent(sortByLabel, PREFERRED, DEFAULT,
										PREFERRED)
								.addPreferredGap(RELATED)
								.addComponent(sortBy, PREFERRED, 162, PREFERRED)
								.addGap(20, 20, 20)));
		productFiltersLayout.setVerticalGroup(
				productFiltersLayout.createParallelGroup(LEADING)
						.addComponent(sortBy, DEFAULT, 30, Short.MAX_VALUE)
						.addComponent(sortByLabel, DEFAULT, DEFAULT, Short.MAX_VALUE));

		productView.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        drawProductPanels();

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout
										.createParallelGroup(LEADING)
										.addComponent(orderNav, DEFAULT,
												DEFAULT,
												Short.MAX_VALUE)
										.addComponent(productFilters, DEFAULT,
												DEFAULT,
												Short.MAX_VALUE)
										.addComponent(productView, PREFERRED, 0,
												Short.MAX_VALUE))
								.addContainerGap()));
								layout.setVerticalGroup(
									layout.createParallelGroup(LEADING)
						.addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(orderNav, PREFERRED, DEFAULT, PREFERRED)
                                .addPreferredGap(RELATED)
                                .addComponent(productFilters, PREFERRED, DEFAULT,
                                        PREFERRED)
                                .addPreferredGap(RELATED)
                                .addComponent(productView, DEFAULT, 318,
                                        Short.MAX_VALUE)
                                .addContainerGap()));
    }

    private void drawProductPanels() {
        allProducts = new JPanel();

        GroupLayout allProductsLayout = new GroupLayout(allProducts);

        GroupLayout.SequentialGroup allProductsSequentialGroup = allProductsLayout.createSequentialGroup()
                .addContainerGap();
        GroupLayout.ParallelGroup allProductsParallelGroup = allProductsLayout.createParallelGroup(LEADING,
                false);

        for (JPanel productPanel : productPanels) {
            allProductsSequentialGroup.addComponent(productPanel, PREFERRED, DEFAULT, PREFERRED);
            allProductsSequentialGroup.addPreferredGap(RELATED);
            allProductsParallelGroup.addComponent(productPanel, DEFAULT, DEFAULT, Short.MAX_VALUE);
        }

        allProducts.setLayout(allProductsLayout);
        allProductsLayout.setHorizontalGroup(
                allProductsLayout.createParallelGroup(LEADING)
                        .addGroup(allProductsSequentialGroup));

        allProductsLayout.setVerticalGroup(
                allProductsLayout.createParallelGroup(LEADING)
                        .addGroup(allProductsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(allProductsParallelGroup)
                                .addContainerGap(16, Short.MAX_VALUE)));

        productView.setViewportView(allProducts);
    }

    private void initializeButtons() {
        selectWheels.setText("Select Wheels");
        selectFrameSets.setText("Select Frame-Sets");
        selectHandlebars.setText("Select Handlebars");
        viewOrder.setText("View Order");

        selectWheels.addActionListener(e -> populateProductPanels(Product.Products.WHEELS));

        selectFrameSets.addActionListener(e -> populateProductPanels(Product.Products.FRAME));

        selectHandlebars.addActionListener(e -> populateProductPanels(Product.Products.HANDLEBAR));

        viewOrder.addActionListener(e -> parentFrame.displayPanel(parentFrame.viewOrder, true, false, true, false, false));
    }

    private void populateProductPanels(Product.Products productType) {
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
        productPanels.clear();
        products.forEach(product -> productPanels.add(new ProductPanel(product)));
        drawProductPanels();
    }
}
