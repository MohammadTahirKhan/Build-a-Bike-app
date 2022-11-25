package gui.Panels;

import javax.swing.*;
import java.awt.*;

public class ForgottenOrderNumber extends JPanel {
    private final JFrame frame;
    private final JLabel forgottenOrderTitle = new JLabel();
    private final JPanel forgottenOrderForm = new JPanel();
    private final TextField forenameField = new TextField();
    private final TextField textField2 = new TextField();
    private final Label surnameLabel = new Label();
    private final Label forenameLabel = new Label();
    private final Label forgottenOrderFormTitle = new Label();
    private final Button findOrderButton = new Button();
    private final TextField houseNumberField = new TextField();
    private final Label houseNumberLabel = new Label();
    private final Label postcodeLabel = new Label();
    private final TextField postcodeField = new TextField();
    private final JMenuBar header = new JMenuBar();
    private final JMenu jMenu1 = new JMenu();

    public ForgottenOrderNumber(JFrame _frame) {
        frame = _frame;
        initComponents();
    }

    private void initComponents() {

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Bikes Ltd.");
        setMinimumSize(new Dimension(900, 500));
        setSize(new Dimension(900, 500));

        forgottenOrderTitle.setFont(new Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        forgottenOrderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        forgottenOrderTitle.setText("Forgotten Order Number");

        forgottenOrderForm.setBorder(BorderFactory.createEtchedBorder());

        forenameLabel.setText("Forename");

        surnameLabel.setText("Surname");

        forgottenOrderFormTitle.setAlignment(Label.CENTER);
        forgottenOrderFormTitle.setFont(new Font("Dialog", Font.PLAIN, 18)); // NOI18N
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

        GroupLayout forgottenOrderNumberMainLayout = new GroupLayout(this);
        this.setLayout(forgottenOrderNumberMainLayout);
        forgottenOrderNumberMainLayout.setHorizontalGroup(
                forgottenOrderNumberMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, forgottenOrderNumberMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(forgottenOrderTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(forgottenOrderNumberMainLayout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(forgottenOrderForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(230, Short.MAX_VALUE))
        );
        forgottenOrderNumberMainLayout.setVerticalGroup(
                forgottenOrderNumberMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(forgottenOrderNumberMainLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(forgottenOrderTitle, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(forgottenOrderForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 76, Short.MAX_VALUE))
        );

        jMenu1.setText("Back To Browse");
        header.add(jMenu1);
        jMenu1.addActionListener(e -> {
            frame.setContentPane(new ProductBrowse(frame));
            frame.repaint();
        });

        frame.setJMenuBar(header);

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(this, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        frame.pack();
    }

    void backToBrowseActionPerformed() {
        frame.setContentPane(new ProductBrowse(frame));
        frame.repaint();
        frame.revalidate();
    }
}
