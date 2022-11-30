package gui.Frames;

import gui.Panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class BaseFrame extends JFrame {
    private JMenuBar header;
    private JMenu backToBrowse;
    private JMenu toStaffPortal;
    private JMenu toReviewOrder;
    private JMenu logout;
    private JMenu backToLanding;

    public StaffLogin staffLogin;
    public StaffLanding staffLanding;
    public ReviewExistingOrder reviewExistingOrder; 
    public ForgottenOrderNumber forgottenOrderNumber;
    public ViewOrder viewOrder;
    public StockBrowse stockBrowse;
    public ProductBrowse productBrowse;
    public ConfirmOrder confirmOrder; 
    public AddStock addStock; 
    public StaffFindOrder staffFindOrder;
    public StaffAssembleOrder staffAssembleOrder;
    public StaffViewOrders staffViewOrders;

    private final BaseFrame thisFrame = this;

    public BaseFrame(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                header = new JMenuBar();
                backToBrowse = new JMenu();
                toStaffPortal = new JMenu();
                toReviewOrder = new JMenu();
                logout = new JMenu();
                backToLanding = new JMenu();

                staffLogin = new StaffLogin(thisFrame);
                staffLanding = new StaffLanding(thisFrame);
                reviewExistingOrder = new ReviewExistingOrder(thisFrame);
                forgottenOrderNumber = new ForgottenOrderNumber(thisFrame);
                viewOrder = new ViewOrder(thisFrame);
                stockBrowse = new StockBrowse(thisFrame);
                productBrowse = new ProductBrowse(thisFrame);
                confirmOrder = new ConfirmOrder(thisFrame);
                addStock = new AddStock(thisFrame);
                staffFindOrder = new StaffFindOrder(thisFrame);
                staffAssembleOrder = new StaffAssembleOrder(thisFrame);
                staffViewOrders = new StaffViewOrders();

                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setTitle("Bikes Ltd.");
                initializeHeader();
                //1000x575
                setMinimumSize(new Dimension(900, 500));
                setPreferredSize(new Dimension(900, 500));
                setSize(new Dimension(900, 500));
                setVisible(true);

                displayPanel(productBrowse, false, true, true, false, false);
            }
        });
    }

    public void displayPanel(JPanel panel, Boolean btb, Boolean tsp, Boolean tro, Boolean log, Boolean bts) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        setHeader(btb, tsp, tro, log, bts);

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

    public void initializeHeader() {
        backToBrowse.setText("Back To Browse");
        toStaffPortal.setText("Staff Portal");
        toReviewOrder.setText("Review Existing Order");
        logout.setText("Logout");
        backToLanding.setText("Back To Staff Landing");
        setHeaderActions(backToBrowse);
        setHeaderActions(toStaffPortal);
        setHeaderActions(toReviewOrder);
        setHeaderActions(logout);
        setHeaderActions(backToLanding);
    }

    public void setHeader(Boolean btb, Boolean tsp, Boolean tro, Boolean log, Boolean bts) {
        if (btb) {
            header.add(backToBrowse);
        } else {
            header.remove(backToBrowse);
        }

        if (tsp) {
            header.add(toStaffPortal);
        } else {
            header.remove(toStaffPortal);
        }

        if (tro) {
            header.add(toReviewOrder);
        } else {
            header.remove(toReviewOrder);
        }

        if (log) {
            header.add(logout);
        } else {
            header.remove(logout);
        }

        if (bts) {
            header.add(backToLanding);
        } else {
            header.remove(backToLanding);
        }
        setJMenuBar(header);
    }

    public void setHeaderActions(JMenu item) {
        item.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Objects.equals(item.getText(), "Logout")) {
                    //TODO: link to back
                    displayPanel(productBrowse, false, true, true, false, false);
                }
                if (Objects.equals(item.getText(), "Back To Browse")) {
                    displayPanel(productBrowse, false, true, true, false, false);
                }
                if (Objects.equals(item.getText(), "Review Existing Order")) {
                    displayPanel(reviewExistingOrder, true, false, false, false, false);
                }
                if (Objects.equals(item.getText(), "Staff Portal")) {
                    displayPanel(staffLogin, true, false, false, false, false);
                }
                if (Objects.equals(item.getText(), "Back To Staff Landing")) {
                    displayPanel(staffLanding, false, false, false, true, false);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        }); 
    }
}
