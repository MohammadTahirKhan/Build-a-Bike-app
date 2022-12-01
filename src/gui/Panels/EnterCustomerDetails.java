package gui.Panels;

import javax.swing.*;

import gui.Frames.BaseFrame;

import java.awt.*;

public class EnterCustomerDetails extends JPanel {  
     private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;
                  
    private Button nextButton;
    private TextField forenameField;
    private Label forenameLabel;
    private JPanel forgottenOrderForm;
    private Label forgottenOrderFormTitle;
    private TextField houseNumberField;
    private TextField houseNumberField1;
    private TextField houseNumberField2;
    private Label houseNumberLabel;
    private Label houseNumberLabel1;
    private Label houseNumberLabel2;
    private TextField postcodeField;
    private Label postcodeLabel;
    private Label surnameLabel;
    private TextField textField2;

    private BaseFrame parentFrame;
  
    public EnterCustomerDetails(BaseFrame baseFrame) {
        parentFrame = baseFrame;
        forgottenOrderForm = new JPanel();
        forenameField = new TextField();
        textField2 = new TextField();
        forenameLabel = new Label();
        surnameLabel = new Label();
        forgottenOrderFormTitle = new Label();
        nextButton = new Button();
        houseNumberField = new TextField();
        houseNumberLabel = new Label();
        postcodeLabel = new Label();
        postcodeField = new TextField();
        houseNumberLabel1 = new Label();
        houseNumberField1 = new TextField();
        houseNumberLabel2 = new Label();
        houseNumberField2 = new TextField();

        forgottenOrderForm.setBorder(BorderFactory.createEtchedBorder());

        initializeButtons();

        forenameLabel.setText("Forename");

        surnameLabel.setText("Surname");

        forgottenOrderFormTitle.setAlignment(Label.CENTER);
        forgottenOrderFormTitle.setFont(new Font("Dialog", 0, 18)); // NOI18N
        forgottenOrderFormTitle.setText("Enter Your Details Below");

        houseNumberLabel.setText("House Number");

        postcodeLabel.setText("Postcode");

        houseNumberLabel1.setText("Road Name");

        houseNumberLabel2.setText("City");

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
                            .addComponent(postcodeField, PREFERRED, 317, PREFERRED)
                            .addComponent(houseNumberLabel1, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(houseNumberField1, PREFERRED, 317, PREFERRED)
                            .addComponent(houseNumberLabel2, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(houseNumberField2, PREFERRED, 317, PREFERRED)))
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
                .addComponent(textField2, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(houseNumberLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(houseNumberField, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(houseNumberLabel1, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(houseNumberField1, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(houseNumberLabel2, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(houseNumberField2, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postcodeLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(postcodeField, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton, PREFERRED, DEFAULT, PREFERRED)
                .addContainerGap(DEFAULT, Short.MAX_VALUE))
        );

        houseNumberLabel2.getAccessibleContext().setAccessibleName("City");

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
        nextButton.addActionListener(e -> parentFrame.displayPanel(parentFrame.confirmOrder, true, false, true, false, false));
    }
}
