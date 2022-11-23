package gui.Frames;

public class ReviewExistingOrder extends javax.swing.JFrame {

    /**
     * Creates new form StaffLogin
     */
    public ReviewExistingOrder() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        reviewExisitngOrderMain = new java.awt.Panel();
        yourSelection = new javax.swing.JLabel();
        orderFindForm = new javax.swing.JPanel();
        orderNumberField = new java.awt.TextField();
        orderFindFormTitle = new java.awt.Label();
        findOrderButton = new java.awt.Button();
        forgottenOrderNumberButton = new java.awt.Button();
        header = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bikes Ltd.");
        setMinimumSize(new java.awt.Dimension(900, 500));
        setSize(new java.awt.Dimension(900, 500));

        yourSelection.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        yourSelection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yourSelection.setText("Review Exisitng Order");

        orderFindForm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        orderFindFormTitle.setAlignment(java.awt.Label.CENTER);
        orderFindFormTitle.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        orderFindFormTitle.setText("Enter your order number below");

        findOrderButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        findOrderButton.setLabel("Find My Order");
        findOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findOrderButtonActionPerformed(evt);
            }
        });

        forgottenOrderNumberButton.setLabel("Forgotten Order Number");
        forgottenOrderNumberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgottenOrderNumberButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout orderFindFormLayout = new javax.swing.GroupLayout(orderFindForm);
        orderFindForm.setLayout(orderFindFormLayout);
        orderFindFormLayout.setHorizontalGroup(
            orderFindFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderFindFormLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(orderFindFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(orderFindFormLayout.createSequentialGroup()
                        .addComponent(forgottenOrderNumberButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(findOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(orderFindFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(orderNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(orderFindFormTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        orderFindFormLayout.setVerticalGroup(
            orderFindFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderFindFormLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(orderFindFormTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(orderNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(orderFindFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(findOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forgottenOrderNumberButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout reviewExisitngOrderMainLayout = new javax.swing.GroupLayout(reviewExisitngOrderMain);
        reviewExisitngOrderMain.setLayout(reviewExisitngOrderMainLayout);
        reviewExisitngOrderMainLayout.setHorizontalGroup(
            reviewExisitngOrderMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewExisitngOrderMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(yourSelection, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(reviewExisitngOrderMainLayout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(orderFindForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        reviewExisitngOrderMainLayout.setVerticalGroup(
            reviewExisitngOrderMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewExisitngOrderMainLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(yourSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(orderFindForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 152, Short.MAX_VALUE))
        );

        jMenu1.setText("Back To Browse");
        header.add(jMenu1);

        setJMenuBar(header);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reviewExisitngOrderMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(reviewExisitngOrderMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void findOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void forgottenOrderNumberButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                           
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
            java.util.logging.Logger.getLogger(ReviewExistingOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReviewExistingOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReviewExistingOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReviewExistingOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReviewExistingOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private java.awt.Button findOrderButton;
    private java.awt.Button forgottenOrderNumberButton;
    private javax.swing.JMenuBar header;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel orderFindForm;
    private java.awt.Label orderFindFormTitle;
    private java.awt.TextField orderNumberField;
    private java.awt.Panel reviewExisitngOrderMain;
    private javax.swing.JLabel yourSelection;
    // End of variables declaration                   
}
