package gui.Panels;

import gui.Frames.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConfirmOrder extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private final JPanel itemsSelected;
    private JPanel orderOptions;
    private JButton backToBrowseButton;
    private JLabel yourSelection;
    private ArrayList<ProductPanel> productPanels = new ArrayList<>(3);

    private BaseFrame parentFrame;

    public ConfirmOrder(BaseFrame parentFrame) {
        this.parentFrame = parentFrame;

        itemsSelected = new JPanel();
        orderOptions = new JPanel();
        yourSelection = new JLabel();
        backToBrowseButton = new JButton();

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
        yourSelection.setText("Order Placed! : #" + "ORDERNUMBER");

        GroupLayout orderOptionsLayout = new GroupLayout(orderOptions);
        orderOptions.setLayout(orderOptionsLayout);
        orderOptionsLayout.setHorizontalGroup(
            orderOptionsLayout.createParallelGroup(LEADING)
            .addGroup(orderOptionsLayout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(backToBrowseButton, PREFERRED, 118, PREFERRED)
                .addContainerGap(DEFAULT, Short.MAX_VALUE))
        );
        orderOptionsLayout.setVerticalGroup(
            orderOptionsLayout.createParallelGroup(LEADING)
            .addGroup(orderOptionsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(orderOptionsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(backToBrowseButton, PREFERRED, 45, PREFERRED))
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
        backToBrowseButton.setBackground(new Color(51, 51, 51));
        backToBrowseButton.setForeground(new Color(255, 255, 255));
        backToBrowseButton.setText("Back To Browse");
        backToBrowseButton.setToolTipText("");
        backToBrowseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                parentFrame.displayPanel(parentFrame.productBrowse, false, true, true, false, false);	
			}
		});
	}
}


