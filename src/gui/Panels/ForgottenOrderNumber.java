package gui.Frames;

import javax.swing.*;
import java.awt.*;
public class ForgottenOrderNumber extends JPanel {                
    private Button findOrderButton;
    private TextField forenameField;
    private Label forenameLabel;
    private JPanel forgottenOrderForm;
    private Label forgottenOrderFormTitle;
    private JLabel forgottenOrderTitle;
    private TextField houseNumberField;
    private Label houseNumberLabel;
    private TextField postcodeField;
    private Label postcodeLabel;
    private Label surnameLabel;
    private TextField textField2;  

    public ForgottenOrderNumber() {
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


        forgottenOrderTitle.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        forgottenOrderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        forgottenOrderTitle.setText("Forgotten Order Number");

        forgottenOrderForm.setBorder(BorderFactory.createEtchedBorder());

        forenameLabel.setText("Forename");

        surnameLabel.setText("Surname");

        forgottenOrderFormTitle.setAlignment(Label.CENTER);
        forgottenOrderFormTitle.setFont(new Font("Dialog", 0, 18)); // NOI18N
        forgottenOrderFormTitle.setText("Enter Your Details Below");

        findOrderButton.setLabel("Find My Order");

        houseNumberLabel.setText("House Number");

        postcodeLabel.setText("Postcode");

        GroupLayout forgottenOrderFormLayout = new GroupLayout(forgottenOrderForm);
        forgottenOrderForm.setLayout(forgottenOrderFormLayout);
        forgottenOrderFormLayout.setHorizontalGroup(
            forgottenOrderFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(forgottenOrderFormLayout.createSequentialGroup()
                .addGroup(forgottenOrderFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(forgottenOrderFormLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(forgottenOrderFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(forgottenOrderFormTitle, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                            .addComponent(surnameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(forenameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                            .addComponent(forenameField, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                            .addComponent(houseNumberLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(houseNumberField, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                            .addComponent(postcodeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(postcodeField, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(forgottenOrderFormLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(findOrderButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        forgottenOrderFormLayout.setVerticalGroup(
            forgottenOrderFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, forgottenOrderFormLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(forgottenOrderFormTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forenameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(forenameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(surnameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(houseNumberLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(houseNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postcodeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(postcodeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findOrderButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(forgottenOrderTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(forgottenOrderForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(forgottenOrderTitle, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(forgottenOrderForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 76, Short.MAX_VALUE))
        );
    }            
}
