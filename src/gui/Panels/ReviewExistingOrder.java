package gui.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ReviewExistingOrder extends JPanel {
    private final JFrame frame;
    private final Panel reviewExisitngOrderMain = new Panel();
    private final JLabel yourSelection = new JLabel();
    private final JPanel orderFindForm = new JPanel();
    private final TextField orderNumberField = new TextField();
    private final Label orderFindFormTitle = new Label();
    private final Button findOrderButton = new Button();
    private final Button forgottenOrderNumberButton = new Button();
    private final JMenu jMenu1 = new JMenu();
    private final JMenuBar header = new JMenuBar();

    public ReviewExistingOrder(JFrame _frame) {
        frame = _frame;

        initComponents();
    }

    private void initComponents() {

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Bikes Ltd.");
        setMinimumSize(new java.awt.Dimension(900, 500));
        setSize(new java.awt.Dimension(900, 500));

        yourSelection.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        yourSelection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yourSelection.setText("Review Exisitng Order");

        orderFindForm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        orderFindFormTitle.setAlignment(java.awt.Label.CENTER);
        orderFindFormTitle.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18)); // NOI18N
        orderFindFormTitle.setText("Enter your order number below");

        findOrderButton.setFont(new java.awt.Font("Dialog", Font.BOLD, 12)); // NOI18N
        findOrderButton.setLabel("Find My Order");
        findOrderButton.addActionListener(this::findOrderButtonActionPerformed);

        forgottenOrderNumberButton.setLabel("Forgotten Order Number");
        forgottenOrderNumberButton.addActionListener(this::forgottenOrderNumberButtonActionPerformed);

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

        frame.setJMenuBar(header);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
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

        frame.pack();
    }

    private void forgottenOrderNumberButtonActionPerformed(ActionEvent evt) {
        frame.setContentPane(new ForgottenOrderNumber(frame));
        frame.repaint();
    }

    private void findOrderButtonActionPerformed(ActionEvent evt) {
        //frame.setContentPane(new OrderDetails(frame));
        frame.repaint();
    }
}
