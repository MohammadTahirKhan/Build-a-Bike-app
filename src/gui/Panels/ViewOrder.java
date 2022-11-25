package gui.Panels;

import Product.Product;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewOrder extends JPanel {
    private final JFrame frame;
    private final JPanel itemsSelected = new JPanel();
    private final JLabel yourSelection = new JLabel();
    private final JPanel orderOptions = new JPanel();
    private final JButton restartButton = new JButton();
    private final JButton backToBrowseButton = new JButton();
    private final JButton placeOrderButton = new JButton();
    private final JMenuBar header = new JMenuBar();
    private final JMenu jMenu1 = new JMenu();
    private ArrayList<ProductPanel> productPanels;

    public ViewOrder(JFrame _frame) {
        frame = _frame;
        initComponents();
    }

    public ViewOrder(JFrame _frame, ArrayList<Product> products) {
        frame = _frame;
        for (Product product : products) {
            addProductPanel(product);
        }
        initComponents();
    }

    public void clearProductPanels() {
        this.productPanels.clear();
    }

    public void addProductPanel(Product product) {
        this.productPanels.add(new ProductPanel(product));
    }

    private void initComponents() {

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Bikes Ltd.");
        setBackground(new java.awt.Color(255, 255, 255));
        setSize(new java.awt.Dimension(800, 500));

        javax.swing.GroupLayout itemsSelectedLayout = new javax.swing.GroupLayout(itemsSelected);

        GroupLayout.SequentialGroup sequentialGroup = itemsSelectedLayout.createSequentialGroup().addGap(49, 49, 49);
        GroupLayout.ParallelGroup parallelGroup = itemsSelectedLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        for (ProductPanel prod : productPanels) {
            sequentialGroup.addComponent(prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29);
            parallelGroup.addComponent(prod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        }

        sequentialGroup.addContainerGap(49, Short.MAX_VALUE);

        itemsSelected.setLayout(itemsSelectedLayout);
        itemsSelectedLayout.setHorizontalGroup(
                itemsSelectedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sequentialGroup)
        );
        itemsSelectedLayout.setVerticalGroup(
                parallelGroup
        );

        yourSelection.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        yourSelection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yourSelection.setText("Your Selection");

        restartButton.setBackground(new java.awt.Color(51, 51, 51));
        restartButton.setForeground(new java.awt.Color(255, 255, 255));
        restartButton.setText("Restart");
        restartButton.setToolTipText("");

        backToBrowseButton.setBackground(new java.awt.Color(51, 51, 51));
        backToBrowseButton.setForeground(new java.awt.Color(255, 255, 255));
        backToBrowseButton.setText("Back To Browse");
        backToBrowseButton.setToolTipText("");

        placeOrderButton.setBackground(new java.awt.Color(51, 51, 51));
        placeOrderButton.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        placeOrderButton.setForeground(new java.awt.Color(255, 255, 255));
        placeOrderButton.setText("Place Order");
        placeOrderButton.setToolTipText("");

        javax.swing.GroupLayout orderOptionsLayout = new javax.swing.GroupLayout(orderOptions);
        orderOptions.setLayout(orderOptionsLayout);
        orderOptionsLayout.setHorizontalGroup(
                orderOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(orderOptionsLayout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(backToBrowseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(placeOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        orderOptionsLayout.setVerticalGroup(
                orderOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(orderOptionsLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(orderOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(placeOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(backToBrowseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout viewMyOrderMainLayout = new javax.swing.GroupLayout(this);
        this.setLayout(viewMyOrderMainLayout);
        viewMyOrderMainLayout.setHorizontalGroup(
                viewMyOrderMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(viewMyOrderMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(viewMyOrderMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(yourSelection, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(itemsSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(orderOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        viewMyOrderMainLayout.setVerticalGroup(
                viewMyOrderMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(viewMyOrderMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(yourSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(itemsSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jMenu1.setText("Review Existing Order");
        header.add(jMenu1);

        frame.setJMenuBar(header);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(this, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(this, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
        );

        frame.pack();
    }

}
