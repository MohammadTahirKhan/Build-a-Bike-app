package gui.Panels;

import Order.Order;
import Product.Product;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class TableItem extends JPanel {
    private final JLabel name;
    private final JLabel serialNumber;
    private final JLabel brandName;
    private final JLabel stock;

    public TableItem(Product product) {


        name = new JLabel(product.getName());
        serialNumber = new JLabel(String.valueOf(product.getSerialNumber()));
        brandName = new JLabel(product.getBrandName());
        stock = new JLabel(String.valueOf(product.getStock()));

        setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(name, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(serialNumber, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(brandName, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(stock, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(name)
                                    .addComponent(serialNumber)
                                    .addComponent(brandName)
                                    .addComponent(stock))
                            .addContainerGap(7, Short.MAX_VALUE))
        );
    }

    public TableItem(Order order) {

        name = new JLabel(String.valueOf(order.getID()));
        serialNumber = new JLabel(String.valueOf(order.getBike().getSerialNumber()));
        brandName = new JLabel(String.valueOf(order.getStatus()));
        order.setCost();
        stock = new JLabel(String.valueOf(order.getCost()));

        setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(name, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(serialNumber, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(brandName, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(stock, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(name)
                                        .addComponent(serialNumber)
                                        .addComponent(brandName)
                                        .addComponent(stock))
                                .addContainerGap(7, Short.MAX_VALUE))
        );
    }
}
