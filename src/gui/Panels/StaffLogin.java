package gui.Panels;
import java.awt.*;
import javax.swing.*;

public class StaffLogin extends JPanel {
    private Button loginButton;
    private JPanel loginForm;
    private Label loginFormTitle;
    private TextField passwordField;
    private Label passwordLabel;
    private JLabel staffLogin;
    private TextField usernameField;
    private Label usernameLabel;  

    public StaffLogin() {
        staffLogin = new JLabel();
        loginForm = new JPanel();
        usernameField = new TextField();
        passwordField = new TextField();
        usernameLabel = new Label();
        passwordLabel = new Label();
        loginFormTitle = new Label();
        loginButton = new Button();

        staffLogin.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        staffLogin.setHorizontalAlignment(SwingConstants.CENTER);
        staffLogin.setText("Staff Login");

        loginForm.setBorder(BorderFactory.createEtchedBorder());

        usernameLabel.setText("Username");

        passwordLabel.setText("Password");

        loginFormTitle.setAlignment(SwingConstants.CENTER);
        loginFormTitle.setFont(new Font("Dialog", 0, 18)); // NOI18N
        loginFormTitle.setText("Enter username and password below");

        loginButton.setLabel("Login");

        GroupLayout loginFormLayout = new GroupLayout(loginForm);
        loginForm.setLayout(loginFormLayout);
        loginFormLayout.setHorizontalGroup(
            loginFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(loginFormLayout.createSequentialGroup()
                .addGroup(loginFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(loginFormLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(loginFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(loginFormTitle, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(loginFormLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        loginFormLayout.setVerticalGroup(
            loginFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, loginFormLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(loginFormTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(staffLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(loginForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(staffLogin, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 131, Short.MAX_VALUE))
        );
    }                                         
}
