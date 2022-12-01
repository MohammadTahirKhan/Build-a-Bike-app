package gui.Panels;

import gui.Frames.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StaffAssembleOrder extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private final JButton cancelButton;
    private final JPanel itemsSelected;

    private final JPanel orderOptions;
    private final JButton confirmButton;
    private final JLabel yourSelection;

    private final ArrayList<ProductPanel> productPanels = new ArrayList<>(3);

    private final BaseFrame parentFrame;

    public StaffAssembleOrder(BaseFrame parentFrame) {
        this.parentFrame = parentFrame;

        itemsSelected = new JPanel();
        yourSelection = new JLabel();
        orderOptions = new JPanel();
        cancelButton = new JButton();
        confirmButton = new JButton();

        initializeButtons();

        GroupLayout itemsSelectedLayout = new GroupLayout(itemsSelected);
        GroupLayout.SequentialGroup seqGroup = itemsSelectedLayout.createSequentialGroup();
        GroupLayout.ParallelGroup parGroup = itemsSelectedLayout.createParallelGroup(LEADING);

        for (ProductPanel productPanel : productPanels) {
            seqGroup.addGap(29, 29, 29)
                    .addComponent(productPanel, PREFERRED, DEFAULT, PREFERRED);
            parGroup.addComponent(productPanel, DEFAULT, DEFAULT, Short.MAX_VALUE);
        }
        seqGroup.addContainerGap(29, Short.MAX_VALUE);


        itemsSelected.setLayout(itemsSelectedLayout);
        itemsSelectedLayout.setHorizontalGroup(
                itemsSelectedLayout.createParallelGroup(LEADING)
                        .addGroup(seqGroup)
        );
        itemsSelectedLayout.setVerticalGroup(
                parGroup
        );

        yourSelection.setFont(new Font("Segoe UI", Font.BOLD, 24));
        yourSelection.setHorizontalAlignment(SwingConstants.CENTER);
        yourSelection.setText("Order #" + 2348537);

        GroupLayout orderOptionsLayout = new GroupLayout(orderOptions);
        orderOptions.setLayout(orderOptionsLayout);
        orderOptionsLayout.setHorizontalGroup(
            orderOptionsLayout.createParallelGroup(LEADING)
            .addGroup(orderOptionsLayout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(cancelButton, PREFERRED, 118, PREFERRED)
                .addGap(18, 18, 18)
                .addComponent(confirmButton, PREFERRED, 118, PREFERRED)
                .addContainerGap(DEFAULT, Short.MAX_VALUE))
        );
        orderOptionsLayout.setVerticalGroup(
            orderOptionsLayout.createParallelGroup(LEADING)
            .addGroup(orderOptionsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(orderOptionsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton, PREFERRED, 45, PREFERRED)
                    .addComponent(cancelButton, PREFERRED, 45, PREFERRED))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(LEADING)
                    .addComponent(yourSelection, TRAILING, DEFAULT, DEFAULT, Short.MAX_VALUE)
                    .addComponent(itemsSelected, DEFAULT, DEFAULT, Short.MAX_VALUE)
                    .addComponent(orderOptions, DEFAULT, DEFAULT, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(yourSelection, PREFERRED, 82, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemsSelected, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orderOptions, PREFERRED, DEFAULT, PREFERRED)
                .addContainerGap())
        );
    }  
    
    private void initializeButtons() {
        cancelButton.setBackground(new Color(51, 51, 51));
        cancelButton.setForeground(new Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("");

        confirmButton.setBackground(new Color(51, 51, 51));
        confirmButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        confirmButton.setForeground(new Color(255, 255, 255));
        confirmButton.setText("Confirm Assembly");
        confirmButton.setToolTipText("");

        cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                parentFrame.displayPanel(parentFrame.staffFindOrder, false, false, false, true, true);	
			}
		});

        confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

                parentFrame.displayPanel(parentFrame.staffFindOrder, false, false, false, true, true);	
			}
		});
	}
}
