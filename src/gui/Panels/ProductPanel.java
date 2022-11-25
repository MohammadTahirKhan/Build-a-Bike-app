package gui.Panels;

import Product.Product;

import javax.swing.*;
import java.awt.*;

public class ProductPanel extends JPanel {
    private static final Font SEGOE_UI = new Font("Segoe UI", Font.PLAIN, 14);
    private final JLabel addToBikeLabel = new JLabel("Add to Bike");

    private final Product product;

    private final JLabel image = new JLabel();
    private final JLabel displayName = new JLabel();
    private final JLabel displayCost = new JLabel();
    private final JCheckBox select = new JCheckBox();
    private final JSeparator horizontalSeparator = new JSeparator();
    private final JSeparator verticalSeparator = new JSeparator(SwingConstants.VERTICAL);

    public ProductPanel(Product product) {
        this.product = product;
        initComponents();
    }

    private void initComponents() {
        this.setBorder(BorderFactory.createEtchedBorder());


        image.setHorizontalAlignment(SwingConstants.CENTER);
        image.setText("/IMAGE/");


        displayName.setFont(SEGOE_UI); // NOI18N
        displayName.setText(product.getName());

        displayCost.setFont(SEGOE_UI); // NOI18N
        displayCost.setHorizontalAlignment(SwingConstants.CENTER);
        displayCost.setText("£" + product.getItemCost());

        select.setHorizontalAlignment(SwingConstants.CENTER);

        addToBikeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout productPanel5Layout = new GroupLayout(this);
        this.setLayout(productPanel5Layout);

        productPanel5Layout.setHorizontalGroup(
                productPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(productPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(productPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(horizontalSeparator, GroupLayout.Alignment.TRAILING)
                                        .addComponent(image, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(horizontalSeparator)
                                        .addGroup(productPanel5Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(displayName, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                                        .addGroup(productPanel5Layout.createSequentialGroup()
                                                .addComponent(displayCost, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(verticalSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(productPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(select, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(addToBikeLabel, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        productPanel5Layout.setVerticalGroup(
                productPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(productPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(image, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(horizontalSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(displayName)
                                .addGap(3, 3, 3)
                                .addComponent(horizontalSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(productPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(productPanel5Layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(productPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(verticalSeparator)
                                                        .addComponent(displayCost, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, productPanel5Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(addToBikeLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                                .addComponent(select)
                                                .addGap(15, 15, 15))))
        );
    }

    public void setSelectLabel(String label) {
        this.addToBikeLabel.setText(label);
    }
}
