package gui.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReviewExistingOrder extends JPanel {                  
    private Button findOrderButton;
    private Button forgottenOrderNumberButton;
    private JPanel orderFindForm;
    private Label orderFindFormTitle;
    private TextField orderNumberField;
    private JLabel yourSelection;

    public ReviewExistingOrder() {
        yourSelection = new JLabel();
        orderFindForm = new JPanel();
        orderNumberField = new TextField();
        orderFindFormTitle = new Label();
        findOrderButton = new Button();
        forgottenOrderNumberButton = new Button();

        yourSelection.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        yourSelection.setHorizontalAlignment(SwingConstants.CENTER);
        yourSelection.setText("Review Exisitng Order");

        orderFindForm.setBorder(BorderFactory.createEtchedBorder());

        orderFindFormTitle.setAlignment(Label.CENTER);
        orderFindFormTitle.setFont(new Font("Dialog", 0, 18)); // NOI18N
        orderFindFormTitle.setText("Enter your order number below");

        findOrderButton.setFont(new Font("Dialog", 1, 12)); // NOI18N
        findOrderButton.setLabel("Find My Order");
        findOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                findOrderButtonActionPerformed(evt);
            }
        });

        forgottenOrderNumberButton.setLabel("Forgotten Order Number");
        forgottenOrderNumberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                forgottenOrderNumberButtonActionPerformed(evt);
            }
        });

        GroupLayout orderFindFormLayout = new GroupLayout(orderFindForm);
        orderFindForm.setLayout(orderFindFormLayout);
        orderFindFormLayout.setHorizontalGroup(
            orderFindFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(orderFindFormLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(orderFindFormLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(orderFindFormLayout.createSequentialGroup()
                        .addComponent(forgottenOrderNumberButton, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(findOrderButton, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                    .addGroup(orderFindFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(orderNumberField, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                        .addComponent(orderFindFormTitle, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        orderFindFormLayout.setVerticalGroup(
            orderFindFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, orderFindFormLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(orderFindFormTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(orderNumberField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(orderFindFormLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(findOrderButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(forgottenOrderNumberButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        GroupLayout reviewExisitngOrderLayout = new GroupLayout(this);
        setLayout(reviewExisitngOrderLayout);
        reviewExisitngOrderLayout.setHorizontalGroup(
            reviewExisitngOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, reviewExisitngOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(yourSelection, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(reviewExisitngOrderLayout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(orderFindForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        reviewExisitngOrderLayout.setVerticalGroup(
            reviewExisitngOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(reviewExisitngOrderLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(yourSelection, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(orderFindForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 152, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void findOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void forgottenOrderNumberButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                           
        // TODO add your handling code here:
    }                                                                          
}
