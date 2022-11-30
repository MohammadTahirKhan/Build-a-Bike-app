package gui.Panels;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class TableItem extends JPanel {
    private final JLabel name;
    private final JLabel cost;
    private final JLabel brandName;
    private final JLabel serialNumber;

    public TableItem(String n, Double c, String b, String s) {


        name = new JLabel(n);
        cost = new JLabel("£" + c.toString());
        brandName = new JLabel(b);
        serialNumber = new JLabel(s);

        setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(cost, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(brandName, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(serialNumber, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(cost)
                    .addComponent(brandName)
                    .addComponent(serialNumber))
                .addContainerGap(7, Short.MAX_VALUE))
        );
    }
}
