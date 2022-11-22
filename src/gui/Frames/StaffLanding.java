package gui.Frames;

public class StaffLanding extends javax.swing.JFrame {

    /**
     * Creates new form StaffLogin
     */
    public StaffLanding() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        staffLandingMain = new java.awt.Panel();
        assembleBike = new javax.swing.JButton();
        acceptPayment = new javax.swing.JButton();
        manageStock = new javax.swing.JButton();
        viewOrders = new javax.swing.JButton();
        header = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bikes Ltd.");
        setMinimumSize(new java.awt.Dimension(900, 500));
        setSize(new java.awt.Dimension(900, 500));

        assembleBike.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        assembleBike.setText("Assemble Bike");

        acceptPayment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        acceptPayment.setText("Accept Payment");
        acceptPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptPaymentActionPerformed(evt);
            }
        });

        manageStock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        manageStock.setText("Manage Stock");

        viewOrders.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        viewOrders.setText("View Orders");

        javax.swing.GroupLayout staffLandingMainLayout = new javax.swing.GroupLayout(staffLandingMain);
        staffLandingMain.setLayout(staffLandingMainLayout);
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

        setJMenuBar(header);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffLandingMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(staffLandingMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void acceptPaymentActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffLanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffLanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffLanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffLanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffLanding().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton acceptPayment;
    private javax.swing.JButton assembleBike;
    private javax.swing.JMenuBar header;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JButton manageStock;
    private java.awt.Panel staffLandingMain;
    private javax.swing.JButton viewOrders;
    // End of variables declaration                   
}
