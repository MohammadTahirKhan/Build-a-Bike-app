package gui.Panels;

import gui.Frames.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ProductBrowse extends JPanel {
	private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
	private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
	private final LayoutStyle.ComponentPlacement RELATED = LayoutStyle.ComponentPlacement.RELATED;
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

    private BaseFrame parentFrame;

    private ArrayList<ProductPanel> productPanels = new ArrayList<>();

    public ProductBrowse(BaseFrame parentFrame) {
        this.parentFrame = parentFrame;
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

		GroupLayout productBrowseMainLayout = new GroupLayout(productBrowseMain);
		productBrowseMain.setLayout(productBrowseMainLayout);
		productBrowseMainLayout.setHorizontalGroup(
				productBrowseMainLayout.createParallelGroup(LEADING)
						.addGroup(productBrowseMainLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(productBrowseMainLayout
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
		productBrowseMainLayout.setVerticalGroup(
				productBrowseMainLayout.createParallelGroup(LEADING)
						.addGroup(productBrowseMainLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(orderNav, PREFERRED, DEFAULT, PREFERRED)
								.addPreferredGap(RELATED)
								.addComponent(productFilters, PREFERRED, DEFAULT,
										PREFERRED)
								.addPreferredGap(RELATED)
								.addComponent(productView, DEFAULT, 318,
										Short.MAX_VALUE)
								.addContainerGap()));

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
