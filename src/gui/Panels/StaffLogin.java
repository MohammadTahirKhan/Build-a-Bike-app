package gui.Panels;

import javax.swing.*;
import java.awt.*;

public class StaffLogin extends JPanel {
    private final JFrame frame;
    private final JPanel loginForm = new JPanel();
    private final JLabel staffLogin = new JLabel();
    private final TextField usernameField = new TextField();
    private final TextField passwordField = new TextField();
    private final Label usernameLabel = new Label();
    private final Label passwordLabel = new Label();
    private final Label loginFormTitle = new Label();
    private final Button loginButton = new Button();
    private final JMenuBar header = new JMenuBar();

    public StaffLogin(JFrame _frame) {
        frame = _frame;
        initComponents();
    }

    private void initComponents() {
        JMenu jMenu1 = new JMenu();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Bikes Ltd.");
        setMinimumSize(new java.awt.Dimension(900, 500));
        setPreferredSize(new java.awt.Dimension(900, 500));
        setSize(new java.awt.Dimension(900, 500));

        staffLogin.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        staffLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        staffLogin.setText("Staff Login");

        loginForm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        usernameLabel.setText("Username");

        passwordLabel.setText("Password");

        loginFormTitle.setAlignment(java.awt.Label.CENTER);
        loginFormTitle.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18)); // NOI18N
        loginFormTitle.setText("Enter username and password below");

        loginButton.setLabel("Login");

        javax.swing.GroupLayout loginFormLayout = new javax.swing.GroupLayout(loginForm);
        loginForm.setLayout(loginFormLayout);
        loginFormLayout.setHorizontalGroup(
                loginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginFormLayout.createSequentialGroup()
                                .addGroup(loginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(loginFormLayout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addGroup(loginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(loginFormTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(loginFormLayout.createSequentialGroup()
                                                .addGap(169, 169, 169)
                                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(61, Short.MAX_VALUE))
        );
        loginFormLayout.setVerticalGroup(
                loginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginFormLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(loginFormTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout staffLoginMainLayout = new javax.swing.GroupLayout(this);
        this.setLayout(staffLoginMainLayout);
        staffLoginMainLayout.setHorizontalGroup(
                staffLoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffLoginMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(staffLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(staffLoginMainLayout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(loginForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(230, Short.MAX_VALUE))
        );
        staffLoginMainLayout.setVerticalGroup(
                staffLoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(staffLoginMainLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(staffLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(loginForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 131, Short.MAX_VALUE))
        );

        jMenu1.setText("Back To Browse");
        header.add(jMenu1);

        frame.setJMenuBar(header);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(this, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(this, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        frame.pack();
    }
}

