package gui.Panels;
import java.awt.*;
import javax.swing.*;

public class StaffLogin extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;
    
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
            loginFormLayout.createParallelGroup(LEADING)
            .addGroup(loginFormLayout.createSequentialGroup()
                .addGroup(loginFormLayout.createParallelGroup(LEADING)
                    .addGroup(loginFormLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(loginFormLayout.createParallelGroup(LEADING)
                            .addComponent(loginFormTitle, PREFERRED, 317, PREFERRED)
                            .addComponent(passwordLabel, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(usernameLabel, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(passwordField, PREFERRED, 317, PREFERRED)
                            .addComponent(usernameField, PREFERRED, 317, PREFERRED)))
                    .addGroup(loginFormLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(loginButton, PREFERRED, 95, PREFERRED)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        loginFormLayout.setVerticalGroup(
            loginFormLayout.createParallelGroup(LEADING)
            .addGroup(TRAILING, loginFormLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(loginFormTitle, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(usernameLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(usernameField, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(passwordField, PREFERRED, DEFAULT, PREFERRED)
                .addGap(32, 32, 32)
                .addComponent(loginButton, PREFERRED, DEFAULT, PREFERRED)
                .addGap(31, 31, 31))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(staffLogin, DEFAULT, DEFAULT, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(loginForm, PREFERRED, DEFAULT, PREFERRED)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(staffLogin, PREFERRED, 82, PREFERRED)
                .addGap(18, 18, 18)
                .addComponent(loginForm, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 131, Short.MAX_VALUE))
        );
    }                                         
}
