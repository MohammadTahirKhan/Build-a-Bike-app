package gui.Panels;

import Actors.Address;
import Actors.Customer;
import Order.Order;
import gui.Frames.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;

import static SQL.Queries.Order.SQLOrder.insertOrder;
import static SQL.Queries.Product.SQLProduct.decrementStock;

public class EnterCustomerDetails extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private final Button nextButton;
    private final TextField forenameField;
    private final Label forenameLabel;
    private final JPanel forgottenOrderForm;
    private final Label forgottenOrderFormTitle;
    private final TextField houseNumberField;
    private final TextField roadNameField;
    private final TextField cityField;
    private final Label houseNumberLabel;
    private final Label roadNameLabel;
    private final Label cityLabel;
    private final TextField postcodeField;
    private final Label postcodeLabel;
    private final Label surnameLabel;
    private final TextField surnameField;

    private final BaseFrame parentFrame;

    public EnterCustomerDetails(BaseFrame baseFrame) {
        parentFrame = baseFrame;
        forgottenOrderForm = new JPanel();
        forenameField = new TextField();
        surnameField = new TextField();
        forenameLabel = new Label();
        surnameLabel = new Label();
        forgottenOrderFormTitle = new Label();
        nextButton = new Button();
        houseNumberField = new TextField();
        houseNumberLabel = new Label();
        postcodeLabel = new Label();
        postcodeField = new TextField();
        roadNameLabel = new Label();
        roadNameField = new TextField();
        cityLabel = new Label();
        cityField = new TextField();

        forgottenOrderForm.setBorder(BorderFactory.createEtchedBorder());

        initializeButtons();

        forenameLabel.setText("Forename");

        surnameLabel.setText("Surname");

        forgottenOrderFormTitle.setAlignment(Label.CENTER);
        forgottenOrderFormTitle.setFont(new Font("Dialog", Font.PLAIN, 18)); // NOI18N
        forgottenOrderFormTitle.setText("Enter Your Details Below");

        houseNumberLabel.setText("House Number");

        postcodeLabel.setText("Postcode");

        roadNameLabel.setText("Road Name");

        cityLabel.setText("City");

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
                            .addComponent(surnameField, PREFERRED, 317, PREFERRED)
                            .addComponent(forenameField, PREFERRED, 317, PREFERRED)
                            .addComponent(houseNumberLabel, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(houseNumberField, PREFERRED, 317, PREFERRED)
                            .addComponent(postcodeLabel, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(postcodeField, PREFERRED, 317, PREFERRED)
                            .addComponent(roadNameLabel, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(roadNameField, PREFERRED, 317, PREFERRED)
                            .addComponent(cityLabel, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(cityField, PREFERRED, 317, PREFERRED)))
                    .addGroup(forgottenOrderFormLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(nextButton, PREFERRED, 95, PREFERRED)))
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
                .addComponent(surnameField, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(houseNumberLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(houseNumberField, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roadNameLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(roadNameField, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cityLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(cityField, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postcodeLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(postcodeField, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton, PREFERRED, DEFAULT, PREFERRED)
                .addContainerGap(DEFAULT, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(TRAILING, layout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addComponent(forgottenOrderForm, PREFERRED, DEFAULT, PREFERRED)
                .addGap(226, 226, 226))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(forgottenOrderForm, PREFERRED, DEFAULT, PREFERRED)
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }  
    
    private void initializeButtons() {
        nextButton.setLabel("Next");
        nextButton.addActionListener(e -> {
            if (forenameField.getText().isEmpty() || surnameField.getText().isEmpty() || houseNumberField.getText().isEmpty() || roadNameField.getText().isEmpty() || cityField.getText().isEmpty() || postcodeField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            } else {
                String forename = forenameField.getText();
                String surname = surnameField.getText();
                int houseNumber = Integer.parseInt(houseNumberField.getText());
                String roadName = roadNameField.getText();
                String city = cityField.getText();
                String postcode = postcodeField.getText();
                Address address = new Address(houseNumber, roadName, city, postcode);
                Customer customer = new Customer(forename, surname, address);
                BaseFrame.currentOrder.setCustomer(customer);
                BaseFrame.currentOrder.setStatus(Order.Status.PENDING);
                BaseFrame.currentOrder.setDate((Date.valueOf(LocalDate.now())));
                BaseFrame.currentOrder.getBike().setValues();
                BaseFrame.currentOrder = insertOrder(BaseFrame.currentOrder);
                assert BaseFrame.currentOrder != null;
                decrementStock(BaseFrame.currentOrder);

                parentFrame.confirmOrder.initPanels();
                parentFrame.displayPanel(parentFrame.confirmOrder, true, false, true, false, false);
            }
        });
    }

}
