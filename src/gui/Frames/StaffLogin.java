package gui.Frames;
import java.awt.*;
import javax.swing.*;

public class StaffLogin extends JPanel {

    public StaffLogin() {
        initComponents();
    }
                    
    private void initComponents() {

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

        GroupLayout staffLoginLayout = new GroupLayout(this);
        this.setLayout(staffLoginLayout);
        staffLoginLayout.setHorizontalGroup(
            staffLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, staffLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(staffLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(staffLoginLayout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(loginForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        staffLoginLayout.setVerticalGroup(
            staffLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(staffLoginLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(staffLogin, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 131, Short.MAX_VALUE))
        );
    }                       

    // public void setup() {
    //     try {
    //         for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the form */
    //     EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new StaffLogin().setVisible(true);
    //         }
    //     });
    // }     

    private java.awt.Button loginButton;
    private javax.swing.JPanel loginForm;
    private java.awt.Label loginFormTitle;
    private java.awt.TextField passwordField;
    private java.awt.Label passwordLabel;
    private javax.swing.JLabel staffLogin;
    private java.awt.TextField usernameField;
    private java.awt.Label usernameLabel;                 
}

