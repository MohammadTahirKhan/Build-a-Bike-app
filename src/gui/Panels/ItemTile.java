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
    private JLabel checkboxLabel;

    private JSeparator separator;
    private JSeparator separator1;
    private JSeparator separator2;
    
    private JCheckBox addToBike;

    public ItemTile(Boolean checkbox) {
        separator1 = new JSeparator();
        separator2 = new JSeparator();
        separator = new JSeparator();
        checkboxLabel = new JLabel("Add to bike");
        addToBike = new JCheckBox();
        image = new JLabel();
        itemDisplayName = new JLabel("Super Swag Wheels 16\"");
        itemDisplayCost = new JLabel("£69.99");

        setBorder(BorderFactory.createEtchedBorder());
        image.setHorizontalAlignment(SwingConstants.CENTER);

        itemDisplayName.setFont(new Font("Segoe UI", 0, 14));

        itemDisplayCost.setFont(new Font("Segoe UI", 0, 14));
        itemDisplayCost.setHorizontalAlignment(SwingConstants.CENTER);

        if (checkbox == false) {
            GroupLayout layout = new GroupLayout(this);
            setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                .addGroup(TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(TRAILING)
                        .addComponent(itemDisplayCost, DEFAULT, DEFAULT, Short.MAX_VALUE)
                        .addComponent(separator)
                        .addComponent(image, LEADING, DEFAULT, DEFAULT, Short.MAX_VALUE)
                        .addComponent(separator1, LEADING)
                        .addGroup(LEADING, layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(itemDisplayName, DEFAULT, 224, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(image, PREFERRED, 185, PREFERRED)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(separator, PREFERRED, DEFAULT, PREFERRED)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(itemDisplayName)
                    .addGap(3, 3, 3)
                    .addComponent(separator1, PREFERRED, DEFAULT, PREFERRED)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(itemDisplayCost, PREFERRED, 55, PREFERRED)
                    .addContainerGap(7, Short.MAX_VALUE))
            );
        } else {
            GroupLayout layout = new GroupLayout(this);
            setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(LEADING)
                                            .addComponent(separator, TRAILING)
                                            .addComponent(image, DEFAULT, DEFAULT, Short.MAX_VALUE)
                                            .addComponent(separator1)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(itemDisplayName, DEFAULT, 240, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(itemDisplayCost, DEFAULT, DEFAULT, Short.MAX_VALUE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(separator2, PREFERRED, DEFAULT, PREFERRED)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(layout.createParallelGroup(LEADING, false)
                                                            .addComponent(addToBike, DEFAULT, DEFAULT, Short.MAX_VALUE)
                                                            .addComponent(checkboxLabel, DEFAULT, 109, Short.MAX_VALUE))))
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(image, PREFERRED, 185, PREFERRED)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(separator, PREFERRED, DEFAULT, PREFERRED)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(itemDisplayName)
                                    .addGap(3, 3, 3)
                                    .addComponent(separator1, PREFERRED, DEFAULT, PREFERRED)
                                    .addGroup(layout.createParallelGroup(LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(layout.createParallelGroup(LEADING)
                                                            .addComponent(separator2)
                                                            .addComponent(itemDisplayCost, DEFAULT, DEFAULT, Short.MAX_VALUE))
                                                    .addContainerGap())
                                            .addGroup(TRAILING, layout.createSequentialGroup()
                                                    .addGap(12, 12, 12)
                                                    .addComponent(checkboxLabel)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT, Short.MAX_VALUE)
                                                    .addComponent(addToBike)
                                                    .addGap(15, 15, 15))))
            );
        }
    }
}
