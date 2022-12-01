package gui.Panels;

import Order.Order;

import javax.swing.*;

public class OrderTableItem extends JPanel {
    private JLabel bikeName;
    private JLabel handleBarName;
    private JLabel frameName;
    private JLabel wheelsName;
    private JLabel bikeSerialNumber;
    private Order order;

    public OrderTableItem(Order order) {
        this.order = order;

        bikeName = new JLabel();
        bikeSerialNumber = new JLabel();
        handleBarName = new JLabel();
        frameName = new JLabel();
        wheelsName = new JLabel();

        bikeName.setText(order.getBike().getName());
        bikeSerialNumber.setText(String.valueOf(order.getBike().getSerialNumber()));
        handleBarName.setText(order.getBike().getHandleBar().getName());
        frameName.setText(order.getBike().getFrame().getName());
        wheelsName.setText(order.getBike().getWheels().getName());

        GroupLayout productItemLayout = new GroupLayout(this);
        this.setLayout(productItemLayout);
        productItemLayout.setHorizontalGroup(
                productItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(productItemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bikeName)
                                .addGap(69, 69, 69)
                                .addComponent(handleBarName, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(frameName, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(wheelsName, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(bikeSerialNumber, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
        );
        productItemLayout.setVerticalGroup(
                productItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(productItemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(productItemLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bikeName)
                                        .addComponent(handleBarName)
                                        .addComponent(frameName)
                                        .addComponent(wheelsName)
                                        .addComponent(bikeSerialNumber))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }
}
