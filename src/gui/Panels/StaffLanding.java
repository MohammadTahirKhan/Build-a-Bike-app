package gui.Panels;

import gui.Frames.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StaffLanding extends JPanel {
    public static final Font SEGOE_UI = new Font("Segoe UI", Font.BOLD, 14);
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private JButton acceptPayment;
    private JButton assembleBike;
    private JButton manageStock;
    private JButton viewOrders;

    BaseFrame parentFrame;

    public StaffLanding(BaseFrame parentFrame) {
        this.parentFrame = parentFrame;
        assembleBike = new JButton();
        acceptPayment = new JButton();
        manageStock = new JButton();
        viewOrders = new JButton();

        assembleBike.setFont(SEGOE_UI);
        assembleBike.setText("Assemble Bike");

        acceptPayment.setFont(SEGOE_UI);
        acceptPayment.setText("Accept Payment");
        acceptPayment.addActionListener(this::acceptPaymentActionPerformed);

        manageStock.setFont(SEGOE_UI);
        manageStock.setText("Manage Stock");

        viewOrders.setFont(SEGOE_UI);
        viewOrders.setText("View Orders");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(TRAILING, layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(manageStock, PREFERRED, 333, PREFERRED)
                        .addGap(42, 42, 42)
                        .addComponent(viewOrders, PREFERRED, 333, PREFERRED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(acceptPayment, PREFERRED, 333, PREFERRED)
                        .addGap(42, 42, 42)
                        .addComponent(assembleBike, PREFERRED, 333, PREFERRED)))
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(assembleBike, PREFERRED, 149, PREFERRED)
                    .addComponent(acceptPayment, PREFERRED, 149, PREFERRED))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(viewOrders, PREFERRED, 149, PREFERRED)
                    .addComponent(manageStock, PREFERRED, 149, PREFERRED))
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }

    private void acceptPaymentActionPerformed(ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             
}

