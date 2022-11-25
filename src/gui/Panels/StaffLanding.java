package gui.Panels;

import javax.swing.*;
import java.awt.*;

public class StaffLanding extends JPanel {
    private final JFrame frame;
    private final JButton assembleBike = new JButton();
    private final JButton acceptPayment = new JButton();
    private final JButton manageStock = new JButton();
    private final JButton viewOrders = new JButton();
    private final JMenuBar header = new JMenuBar();
    private final JMenu jMenu1 = new JMenu();

    public StaffLanding(JFrame _frame) {
        frame = _frame;

        initComponents();
    }

    private void initComponents() {
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Bikes Ltd.");
        setMinimumSize(new java.awt.Dimension(900, 500));
        setSize(new java.awt.Dimension(900, 500));

        assembleBike.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        assembleBike.setText("Assemble Bike");

        acceptPayment.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        acceptPayment.setText("Accept Payment");
        acceptPayment.addActionListener(this::acceptPaymentActionPerformed);

        manageStock.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        manageStock.setText("Manage Stock");

        viewOrders.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        viewOrders.setText("View Orders");

        javax.swing.GroupLayout staffLandingMainLayout = new javax.swing.GroupLayout(this);
        this.setLayout(staffLandingMainLayout);
        staffLandingMainLayout.setHorizontalGroup(
                staffLandingMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffLandingMainLayout.createSequentialGroup()
                                .addContainerGap(96, Short.MAX_VALUE)
                                .addGroup(staffLandingMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(staffLandingMainLayout.createSequentialGroup()
                                                .addComponent(manageStock, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)
                                                .addComponent(viewOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(staffLandingMainLayout.createSequentialGroup()
                                                .addComponent(acceptPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)
                                                .addComponent(assembleBike, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(96, 96, 96))
        );
        staffLandingMainLayout.setVerticalGroup(
                staffLandingMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(staffLandingMainLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(staffLandingMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(assembleBike, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(acceptPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(staffLandingMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(viewOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(manageStock, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(79, Short.MAX_VALUE))
        );

        jMenu1.setText("Logout");
        header.add(jMenu1);

        frame.setJMenuBar(header);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(this, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(this, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        frame.pack();
    }

    private void acceptPaymentActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
}
