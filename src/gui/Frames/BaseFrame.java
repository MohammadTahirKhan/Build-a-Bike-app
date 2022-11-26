package gui.Frames;

import gui.Panels.*;
import javax.swing.*;
import java.awt.*;
// import java.util.*;
// import java.util.logging.Logger;

public class BaseFrame extends JFrame {
    private JMenuBar header;
    private JMenu menuItem1;
    private JMenu menuItem2;
    private StaffLogin staffLogin;
    private StaffLanding staffLanding;
    private ReviewExistingOrder reviewExistingOrder;
    private ForgottenOrderNumber forgottenOrderNumber;
    private ViewOrder viewOrder;

    public BaseFrame(){
        /**try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(BaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } **/

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                header = new JMenuBar();
                menuItem1 = new JMenu();
                staffLogin = new StaffLogin();
                staffLanding = new StaffLanding();
                reviewExistingOrder = new ReviewExistingOrder();
                forgottenOrderNumber = new ForgottenOrderNumber();
                viewOrder = new ViewOrder();

                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setTitle("Bikes Ltd.");
                setMinimumSize(new Dimension(900, 500));
                setPreferredSize(new Dimension(900, 500));
                setSize(new Dimension(900, 500));
                setVisible(true);

                //goToStaffLogin();
                //goToStaffLanding();
                //goToReviewExistingOrder();
                //displayPanel(staffLogin, "Back to Browse", null);
                //displayPanel(staffLanding, "Logout", null);
                //displayPanel(reviewExistingOrder, "Back to Browse", null);
                //displayPanel(forgottenOrderNumber, "Back to Browse", null);
                displayPanel(viewOrder, "Review Existing Order", null);
            }
        });
    }

    public void setHeader(String item1, String item2) {
        if (item1 != null) {
            menuItem1.setText(item1);
            header.add(menuItem1);
        }
        if (item2 != null) {
            menuItem2.setText(item2);
            header.add(menuItem2);
        }
        setJMenuBar(header);
    }

    public void displayPanel(JPanel panel, String menuItem1, String menuItem2) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        setHeader(menuItem1, menuItem2);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

}
