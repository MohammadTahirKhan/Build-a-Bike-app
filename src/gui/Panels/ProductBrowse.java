package gui.Panels;


import Product.Frame;
import Product.HandleBar;
import Product.Product;
import Product.Wheels;
import gui.Frames.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static SQL.Queries.Product.SQLFrame.getAllFrame;
import static SQL.Queries.Product.SQLHandleBar.getAllHandleBar;
import static SQL.Queries.Product.SQLWheels.getAllWheels;

public class ProductBrowse extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final LayoutStyle.ComponentPlacement RELATED = LayoutStyle.ComponentPlacement.RELATED;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private final BaseFrame parentFrame;
    private final JScrollPane productView;

    private final JButton selectFrameSets;
    private final JButton selectHandlebars;
    private final JButton selectWheels;
    private final JButton viewOrder;

    private final ArrayList<ProductPanel> productPanels = new ArrayList<>();

    public ProductBrowse(BaseFrame parentFrame) {
        this.parentFrame = parentFrame;
        JPanel orderNav = new JPanel();
        selectWheels = new JButton();
        selectFrameSets = new JButton();
        selectHandlebars = new JButton();
        viewOrder = new JButton();
        Choice sortBy = new Choice();
        Label sortByLabel = new Label();
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
        GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
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
										.addComponent(productView, PREFERRED, 0,
												Short.MAX_VALUE))
								.addContainerGap()));
								layout.setVerticalGroup(
									layout.createParallelGroup(LEADING)
						.addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(orderNav, PREFERRED, DEFAULT, PREFERRED)
                                .addPreferredGap(RELATED)
                                .addComponent(productView, 370, 370,
                                        370)
                                .addContainerGap()));
    }

    public void drawProductPanels() {
        JPanel allProducts = new JPanel();

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

        viewOrder.addActionListener(e ->
                {
                    checkProductPanels();
                    parentFrame.viewOrder.initPanels();
                    parentFrame.displayPanel(parentFrame.viewOrder, true, false, true, false, false);
                }
        );
    }

    private boolean checkProductPanels() {
        List<ProductPanel> filteredPanels = productPanels.stream().filter(ProductPanel::isSelected).collect(Collectors.toList());
        if (filteredPanels.size() == 1) {
            ProductPanel panel = filteredPanels.get(0);
            if (panel.product instanceof Frame) {
                BaseFrame.currentOrder.getBike().setFrame((Frame) panel.product);
            } else if (panel.product instanceof Wheels) {
                BaseFrame.currentOrder.getBike().setWheels((Wheels) panel.product);
            } else if (panel.product instanceof HandleBar) {
                BaseFrame.currentOrder.getBike().setHandleBar((HandleBar) panel.product);
            }
            return true;
        } else if (filteredPanels.size() > 1) {
            JOptionPane.showMessageDialog(this, "Please select only one product");
            return false;
        }
        return true;
    }

    private void populateProductPanels(Product.Products productType) {
        if (!checkProductPanels()) {
            return;
        }

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
        products.forEach(product -> {
            ProductPanel panel = new ProductPanel(product, "Add to Bike");
            productPanels.add(panel);
        });
        drawProductPanels();
    }
}
