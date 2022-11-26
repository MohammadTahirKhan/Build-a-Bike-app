package gui.Panels;

import javax.swing.*;
import java.awt.*;

public class ItemTile extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private JLabel image;
    private JLabel itemDisplayCost;
    private JLabel itemDisplayName;
    private JSeparator seperator1;
    private JSeparator seperator2;

    public ItemTile() {
        seperator1 = new JSeparator();
        seperator2 = new JSeparator();

        image = new JLabel();
        itemDisplayName = new JLabel();
        itemDisplayCost = new JLabel();

        setBorder(BorderFactory.createEtchedBorder());
        image.setHorizontalAlignment(SwingConstants.CENTER);
        image.setText("/IMAGE/");

        itemDisplayName.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        itemDisplayName.setText("Super Swag Wheels 16\"");

        itemDisplayCost.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        itemDisplayCost.setHorizontalAlignment(SwingConstants.CENTER);
        itemDisplayCost.setText("£69.99");

        GroupLayout item1Layout = new GroupLayout(this);
        setLayout(item1Layout);
        item1Layout.setHorizontalGroup(
            item1Layout.createParallelGroup(LEADING)
            .addGroup(TRAILING, item1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(item1Layout.createParallelGroup(TRAILING)
                    .addComponent(itemDisplayCost, DEFAULT, DEFAULT, Short.MAX_VALUE)
                    .addComponent(seperator2)
                    .addComponent(image, LEADING, DEFAULT, DEFAULT, Short.MAX_VALUE)
                    .addComponent(seperator1, LEADING)
                    .addGroup(LEADING, item1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(itemDisplayName, DEFAULT, 224, Short.MAX_VALUE)))
                .addContainerGap())
        );
        item1Layout.setVerticalGroup(
            item1Layout.createParallelGroup(LEADING)
            .addGroup(item1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, PREFERRED, 185, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seperator1, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemDisplayName)
                .addGap(3, 3, 3)
                .addComponent(seperator2, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemDisplayCost, PREFERRED, 55, PREFERRED)
                .addContainerGap(7, Short.MAX_VALUE))
        );
    }
}
