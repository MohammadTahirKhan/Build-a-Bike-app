package gui.Panels;

import Product.Frame;
import Product.HandleBar;
import Product.Product;
import Product.Wheels;
import gui.Frames.BaseFrame;

import javax.swing.*;
import java.awt.*;

public class ProductPanel extends JPanel {
    private static final Font SEGOE_UI = new Font("Segoe UI", Font.PLAIN, 14);

    final Product product;

    private ImagePanel image;
    private final JCheckBox select = new JCheckBox();

    public ProductPanel(Product product, String checkboxLabel) {
        this.product = product;
        this.setBorder(BorderFactory.createEtchedBorder());

        if (product instanceof Frame) {
            image = new ImagePanel(Product.Products.FRAME);
        } else if (product instanceof Wheels) {
            image = new ImagePanel(Product.Products.WHEELS);
        } else if (product instanceof HandleBar) {
            image = new ImagePanel(Product.Products.HANDLEBAR);
        }

        select.addActionListener(e -> {
            if (product instanceof Frame) {
                BaseFrame.currentOrder.getBike().setFrame((Frame) product);
            } else if (product instanceof Wheels) {
                BaseFrame.currentOrder.getBike().setWheels((Wheels) product);
            } else if (product instanceof HandleBar) {
                BaseFrame.currentOrder.getBike().setHandleBar((HandleBar) product);
            }
        });

        if (product instanceof Frame) {
            isSelected(BaseFrame.currentOrder.getBike().getFrame() != null && BaseFrame.currentOrder.getBike().getFrame().getPKey() == product.getPKey());
        } else if (product instanceof Wheels) {
            isSelected(BaseFrame.currentOrder.getBike().getWheels() != null && BaseFrame.currentOrder.getBike().getWheels().getPKey() == product.getPKey());
        } else if (product instanceof HandleBar) {
            isSelected(BaseFrame.currentOrder.getBike().getHandleBar() != null && BaseFrame.currentOrder.getBike().getHandleBar().getPKey() == product.getPKey());
        }

        JLabel displayName = new JLabel();
        displayName.setFont(SEGOE_UI); // NOI18N
        displayName.setText(product.getName());

        JLabel displayCost = new JLabel();
        displayCost.setFont(SEGOE_UI); // NOI18N
        displayCost.setHorizontalAlignment(SwingConstants.CENTER);
        displayCost.setText("£" + product.getItemCost());

        select.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel addToBikeLabel = new JLabel("Add to Bike");
        addToBikeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout productPanel5Layout = new GroupLayout(this);
        this.setLayout(productPanel5Layout);

        JSeparator verticalSeparator = new JSeparator(SwingConstants.VERTICAL);
        JSeparator horizontalSeparator = new JSeparator();
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

    public boolean isSelected() {
        return select.isSelected();
    }

    public void isSelected(boolean selected) {
        if (selected != isSelected()) {
            select.doClick();
        }
    }
}

