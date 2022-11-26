package gui.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StaffLanding extends JPanel {
    private JButton acceptPayment;
    private JButton assembleBike;
    private JButton manageStock;
    private JButton viewOrders;

    public StaffLanding() {
        assembleBike = new JButton();
        acceptPayment = new JButton();
        manageStock = new JButton();
        viewOrders = new JButton();

        assembleBike.setFont(new Font("Segoe UI", 1, 14));
        assembleBike.setText("Assemble Bike");

        acceptPayment.setFont(new Font("Segoe UI", 1, 14));
        acceptPayment.setText("Accept Payment");
        acceptPayment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                acceptPaymentActionPerformed(evt);
            }
        });

        manageStock.setFont(new Font("Segoe UI", 1, 14));
        manageStock.setText("Manage Stock");

        viewOrders.setFont(new Font("Segoe UI", 1, 14));
        viewOrders.setText("View Orders");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(manageStock, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(viewOrders, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(acceptPayment, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(assembleBike, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(assembleBike, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                    .addComponent(acceptPayment, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(viewOrders, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageStock, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }                       

    private void acceptPaymentActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             
}

