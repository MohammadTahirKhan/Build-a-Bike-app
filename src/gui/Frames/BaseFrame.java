package gui.Frames;

import gui.Panels.*;
import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame {
    private JMenuBar header;
    private JMenu menuItem1;
    private StaffLogin staffLogin;

    public BaseFrame(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                header = new JMenuBar();
                menuItem1 = new JMenu();
                staffLogin = new StaffLogin();

                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setTitle("Bikes Ltd.");
                setMinimumSize(new Dimension(900, 500));
                setPreferredSize(new Dimension(900, 500));
                setSize(new Dimension(900, 500));
                setVisible(true);

                menuItem1.setText("Review Exisitng Order");
                header.add(menuItem1);
                setJMenuBar(header);
                add(header);
                    
                goToStaffLogin();
            }
        });
    }

    public void goToStaffLogin() {
        getContentPane().removeAll();
        getContentPane().add(staffLogin);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(staffLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(staffLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }
}
