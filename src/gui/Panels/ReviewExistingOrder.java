package gui.Panels;

import SQL.Queries.Order.SQLOrder;
import gui.Frames.BaseFrame;

import javax.swing.*;
import java.awt.*;

import static SQL.Queries.Order.SQLOrder.getOrders;

public class ReviewExistingOrder extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private final Button findOrderButton;
    private final Button forgottenOrderNumberButton;
    private final JPanel orderFindForm;
    private final Label orderFindFormTitle;
    private final TextField orderNumberField;
    private final JLabel yourSelection;

    private final BaseFrame parentFrame;

    public ReviewExistingOrder(BaseFrame parentFrame) {
        this.parentFrame = parentFrame;
        yourSelection = new JLabel();
        orderFindForm = new JPanel();
        orderNumberField = new TextField();
        orderFindFormTitle = new Label();
        findOrderButton = new Button();
        forgottenOrderNumberButton = new Button();

        yourSelection.setFont(new Font("Segoe UI", Font.BOLD, 24));
        yourSelection.setHorizontalAlignment(SwingConstants.CENTER);
        yourSelection.setText("Review Exisitng Order");

        orderFindForm.setBorder(BorderFactory.createEtchedBorder());

        orderFindFormTitle.setAlignment(Label.CENTER);
        orderFindFormTitle.setFont(new Font("Dialog", Font.PLAIN, 18));
        orderFindFormTitle.setText("Enter your order number below");

        initializeButtons();

        GroupLayout orderFindFormLayout = new GroupLayout(orderFindForm);
        orderFindForm.setLayout(orderFindFormLayout);
        orderFindFormLayout.setHorizontalGroup(
            orderFindFormLayout.createParallelGroup(LEADING)
            .addGroup(orderFindFormLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(orderFindFormLayout.createParallelGroup(TRAILING, false)
                    .addGroup(orderFindFormLayout.createSequentialGroup()
                        .addComponent(forgottenOrderNumberButton, PREFERRED, 156, PREFERRED)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT, Short.MAX_VALUE)
                        .addComponent(findOrderButton, PREFERRED, 156, PREFERRED))
                    .addGroup(orderFindFormLayout.createParallelGroup(LEADING)
                        .addComponent(orderNumberField, PREFERRED, 317, PREFERRED)
                        .addComponent(orderFindFormTitle, PREFERRED, 317, PREFERRED)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        orderFindFormLayout.setVerticalGroup(
            orderFindFormLayout.createParallelGroup(LEADING)
            .addGroup(TRAILING, orderFindFormLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(orderFindFormTitle, PREFERRED, DEFAULT, PREFERRED)
                .addGap(25, 25, 25)
                .addComponent(orderNumberField, PREFERRED, 33, PREFERRED)
                .addGap(24, 24, 24)
                .addGroup(orderFindFormLayout.createParallelGroup(TRAILING)
                    .addComponent(findOrderButton, PREFERRED, DEFAULT, PREFERRED)
                    .addComponent(forgottenOrderNumberButton, PREFERRED, DEFAULT, PREFERRED))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        GroupLayout reviewExisitngOrderLayout = new GroupLayout(this);
        setLayout(reviewExisitngOrderLayout);
        reviewExisitngOrderLayout.setHorizontalGroup(
            reviewExisitngOrderLayout.createParallelGroup(LEADING)
            .addGroup(TRAILING, reviewExisitngOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(yourSelection, DEFAULT, 888, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(reviewExisitngOrderLayout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(orderFindForm, PREFERRED, DEFAULT, PREFERRED)
                .addContainerGap(DEFAULT, Short.MAX_VALUE))
        );
        reviewExisitngOrderLayout.setVerticalGroup(
            reviewExisitngOrderLayout.createParallelGroup(LEADING)
            .addGroup(reviewExisitngOrderLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(yourSelection, PREFERRED, 82, PREFERRED)
                .addGap(53, 53, 53)
                .addComponent(orderFindForm, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 152, Short.MAX_VALUE))
        );
    }
    
    private void initializeButtons() {
        findOrderButton.setFont(new Font("Dialog", Font.BOLD, 12));
        findOrderButton.setLabel("Find My Order");

        forgottenOrderNumberButton.setFont(new Font("Dialog", Font.BOLD, 12));
        forgottenOrderNumberButton.setLabel("Forgotten My Order Number");
        findOrderButton.addActionListener(e -> {
            Order.Order order = SQLOrder.getOrder(Integer.parseInt(orderNumberField.getText().trim()));
            if (order != null) {
                BaseFrame.currentOrder = order;
                parentFrame.viewOrder.initPanels();
                parentFrame.displayPanel(parentFrame.viewOrder, true, false, false, false, false);
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Order not found");
            }
        });

        forgottenOrderNumberButton.addActionListener(e -> parentFrame.displayPanel(parentFrame.forgottenOrderNumber, true, false, false, false, false));
    }
}
