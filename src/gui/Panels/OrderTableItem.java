package gui.Panels;

import javax.swing.*;

public class OrderTableItem extends JPanel {
    private JLabel bikeName;
    private JLabel handleBarName;
    private JLabel frameName;
    private JLabel wheelsName;
    private JLabel bikeSerialNumber;

    public OrderTableItem() {
        bikeName = new JLabel();
        bikeSerialNumber = new JLabel();
        handleBarName = new JLabel();
        frameName = new JLabel();
        wheelsName = new JLabel();

        bikeName.setText("name");
        bikeSerialNumber.setText("98374");
        handleBarName.setText("handlebor");
        frameName.setText("frames");
        wheelsName.setText("wheelz");

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
