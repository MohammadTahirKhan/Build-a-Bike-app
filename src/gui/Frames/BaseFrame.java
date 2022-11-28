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
    private StockBrowse stockBrowse;
    private ProductBrowse productBrowse;

    public BaseFrame() {
        BaseFrame frame = this;

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                header = new JMenuBar();
                menuItem1 = new JMenu();
                menuItem2 = new JMenu();
                staffLogin = new StaffLogin(frame);
                staffLanding = new StaffLanding(frame);
                reviewExistingOrder = new ReviewExistingOrder(frame);
                forgottenOrderNumber = new ForgottenOrderNumber(frame);
                viewOrder = new ViewOrder(frame);
                stockBrowse = new StockBrowse(frame);
                productBrowse = new ProductBrowse(frame);

                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setTitle("Bikes Ltd.");
                setMinimumSize(new Dimension(900, 500));
                setPreferredSize(new Dimension(900, 500));
                setSize(new Dimension(900, 500));
                setVisible(true);

                //displayPanel(staffLogin, "Back to Browse", null);
                //displayPanel(staffLanding, "Logout", null);
                //displayPanel(reviewExistingOrder, "Back to Browse", null);
                //displayPanel(forgottenOrderNumber, "Back to Browse", null);
                //displayPanel(viewOrder, "Review Existing Order", null);
                //displayPanel(stockBrowse, "Staff Portal", "Review Existing Order");
                displayPanel(productBrowse, "Staff Portal", "Review Existing Order");
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
