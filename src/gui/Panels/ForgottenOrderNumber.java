package gui.Panels;

import Order.Order;
import gui.Frames.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static SQL.Queries.Order.SQLOrder.getOrders;

public class ForgottenOrderNumber extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private final Button findOrderButton;
    private final TextField forenameField;
    private final Label forenameLabel;
    private final JPanel forgottenOrderForm;
    private final Label forgottenOrderFormTitle;
    private final JLabel forgottenOrderTitle;
    private final TextField houseNumberField;
    private final Label houseNumberLabel;
    private final TextField postcodeField;
    private final Label postcodeLabel;
    private final Label surnameLabel;
    private final TextField textField2;

    private final BaseFrame parentFrame;

    public ForgottenOrderNumber(BaseFrame parentFrame) {
        this.parentFrame = parentFrame;
        forgottenOrderTitle = new JLabel();
        forgottenOrderForm = new JPanel();
        forenameField = new TextField();
        textField2 = new TextField();
        forenameLabel = new Label();
        surnameLabel = new Label();
        forgottenOrderFormTitle = new Label();
        findOrderButton = new Button();
        houseNumberField = new TextField();
        houseNumberLabel = new Label();
        postcodeLabel = new Label();
        postcodeField = new TextField();


        forgottenOrderTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));

        forgottenOrderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        forgottenOrderTitle.setText("Forgotten Order Number");

        initializeButtons();

        forgottenOrderForm.setBorder(BorderFactory.createEtchedBorder());

        forenameLabel.setText("Forename");

        surnameLabel.setText("Surname");

        forgottenOrderFormTitle.setAlignment(Label.CENTER);

        forgottenOrderFormTitle.setFont(new Font("Dialog", Font.PLAIN, 18));
        forgottenOrderFormTitle.setText("Enter Your Details Below");

        houseNumberLabel.setText("House Number");

        postcodeLabel.setText("Postcode");

        GroupLayout forgottenOrderFormLayout = new GroupLayout(forgottenOrderForm);
        forgottenOrderForm.setLayout(forgottenOrderFormLayout);
        forgottenOrderFormLayout.setHorizontalGroup(
            forgottenOrderFormLayout.createParallelGroup(LEADING)
            .addGroup(forgottenOrderFormLayout.createSequentialGroup()
                .addGroup(forgottenOrderFormLayout.createParallelGroup(LEADING)
                    .addGroup(forgottenOrderFormLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(forgottenOrderFormLayout.createParallelGroup(LEADING)
                            .addComponent(forgottenOrderFormTitle, PREFERRED, 317, PREFERRED)
                            .addComponent(surnameLabel, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(forenameLabel, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(textField2, PREFERRED, 317, PREFERRED)
                            .addComponent(forenameField, PREFERRED, 317, PREFERRED)
                            .addComponent(houseNumberLabel, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(houseNumberField, PREFERRED, 317, PREFERRED)
                            .addComponent(postcodeLabel, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(postcodeField, PREFERRED, 317, PREFERRED)))
                    .addGroup(forgottenOrderFormLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(findOrderButton, PREFERRED, 95, PREFERRED)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        forgottenOrderFormLayout.setVerticalGroup(
            forgottenOrderFormLayout.createParallelGroup(LEADING)
            .addGroup(TRAILING, forgottenOrderFormLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(forgottenOrderFormTitle, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forenameLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(forenameField, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(surnameLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(textField2, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(houseNumberLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(houseNumberField, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postcodeLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(postcodeField, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findOrderButton, PREFERRED, DEFAULT, PREFERRED)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(forgottenOrderTitle, DEFAULT, DEFAULT, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(forgottenOrderForm, PREFERRED, DEFAULT, PREFERRED)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(forgottenOrderTitle, PREFERRED, 82, PREFERRED)
                                .addGap(18, 18, 18)
                                .addComponent(forgottenOrderForm, PREFERRED, DEFAULT, PREFERRED)
                                .addGap(0, 76, Short.MAX_VALUE))
        );
    } 
    
    private void initializeButtons() {
        findOrderButton.setLabel("Find My Order");
        findOrderButton.addActionListener(e -> {
            ArrayList<Order> order = getOrders(forenameField.getText().trim(), textField2.getText().trim(), Integer.parseInt(houseNumberField.getText().trim()), postcodeField.getText().trim());
            if (order == null) {
                JOptionPane.showMessageDialog(parentFrame, "Order not found");
            } else if (order.size() == 1) {
                BaseFrame.currentOrder = order.get(0);
                parentFrame.viewOrder.initPanels();
                parentFrame.displayPanel(parentFrame.viewOrder, true, false, false, false, false);
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Multiple orders found");
                parentFrame.forgottenFindOrder.generateOrders(order);
                parentFrame.displayPanel(parentFrame.forgottenFindOrder, true, false, false, false, false);
            }
//parentFrame.displayPanel(parentFrame.viewOrder, true, false, false, false, false);
        });
    }
}