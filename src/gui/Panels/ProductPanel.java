package gui.Panels;

import Product.Product;

import javax.swing.*;
import java.awt.*;

public class ProductPanel extends JPanel {
    private static final Font SEGOE_UI = new Font("Segoe UI", Font.PLAIN, 14);


    public ProductPanel(Product product) {
        this.setBorder(BorderFactory.createEtchedBorder());

        JLabel image = new JLabel();
        image.setHorizontalAlignment(SwingConstants.CENTER);
        image.setText("/IMAGE/");

        JLabel displayName = new JLabel();
        displayName.setFont(SEGOE_UI); // NOI18N
        displayName.setText(product.getName());

        JLabel displayCost = new JLabel();
        displayCost.setFont(SEGOE_UI); // NOI18N
        displayCost.setHorizontalAlignment(SwingConstants.CENTER);
        displayCost.setText("£" + product.getItemCost());

        JCheckBox select = new JCheckBox();
        select.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel addToBikeLabel = new JLabel("Add to Bike");
        addToBikeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        JSeparator horizontalSeparator = new JSeparator();
        JSeparator verticalSeparator = new JSeparator(SwingConstants.VERTICAL);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(horizontalSeparator, GroupLayout.Alignment.TRAILING)
                                        .addComponent(image, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(horizontalSeparator)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(displayName, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(displayCost, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(verticalSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(select, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(addToBikeLabel, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(image, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(horizontalSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(displayName)
                                .addGap(3, 3, 3)
                                .addComponent(horizontalSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(verticalSeparator)
                                                        .addComponent(displayCost, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(addToBikeLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                                .addComponent(select)
                                                .addGap(15, 15, 15))))
        );
    }
}
