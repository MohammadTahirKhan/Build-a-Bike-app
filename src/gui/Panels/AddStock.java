package gui.Panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import gui.Frames.BaseFrame;

public class AddStock extends JPanel {
    private final GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
    private final GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
    private final int DEFAULT = GroupLayout.DEFAULT_SIZE;
    private final int PREFERRED = GroupLayout.PREFERRED_SIZE;

    private JButton addStock;
    private BaseFrame parentFrame;
   
    private JPanel form;
    private JLabel addStockTitle;
    private Label formTitle;
    private Label quantityLabel; 
    private Label serialNumberLabel;
    private TextField quantityField;
    private TextField serialNumberField;

    

    public AddStock(BaseFrame baseFrame) {
        parentFrame = baseFrame;
        form = new JPanel();
        addStockTitle = new JLabel();

        serialNumberLabel = new Label();
        serialNumberField = new TextField();
        quantityLabel = new Label();
        quantityField = new TextField();

        formTitle = new Label();
        addStock = new JButton();

        addStockTitle.setFont(new Font("Segoe UI", 1, 24));
        addStockTitle.setHorizontalAlignment(SwingConstants.CENTER);
        addStockTitle.setText("Add Stock");

        initializeButtons();

        form.setBorder(BorderFactory.createEtchedBorder());

        serialNumberLabel.setText("Serial Number");

        quantityLabel.setText("Quantity");

        formTitle.setAlignment(Label.CENTER);
        formTitle.setFont(new Font("Dialog", 0, 18)); // NOI18N
        formTitle.setText("Enter Details Below");

        GroupLayout formLayout = new GroupLayout(form);
        form.setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addGroup(formLayout.createParallelGroup(LEADING)
                    .addGroup(formLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(formLayout.createParallelGroup(LEADING)
                            .addComponent(formTitle, PREFERRED, 317, PREFERRED)
                            .addComponent(quantityLabel, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(serialNumberLabel, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(quantityField, PREFERRED, 317, PREFERRED)
                            .addComponent(serialNumberField, PREFERRED, 317, PREFERRED)))
                    .addGroup(formLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(addStock, PREFERRED, 95, PREFERRED)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(LEADING)
            .addGroup(TRAILING, formLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(formTitle, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serialNumberLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(serialNumberField, PREFERRED, DEFAULT, PREFERRED)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantityLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(quantityField, PREFERRED, DEFAULT, PREFERRED)
                .addGap(27, 27, 27)
                .addComponent(addStock, PREFERRED, DEFAULT, PREFERRED)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addStockTitle, DEFAULT, DEFAULT, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(form, PREFERRED, DEFAULT, PREFERRED)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(addStockTitle, PREFERRED, 82, PREFERRED)
                .addGap(18, 18, 18)
                .addComponent(form, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 158, Short.MAX_VALUE))
        );
    }
    
    private void initializeButtons() {
        addStock.setText("Add Stock");

        addStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: link to back
				System.out.println("add stock selected");
                parentFrame.displayPanel(parentFrame.stockBrowse, false, false, false, false, true);	
			}
		});
	}                            
}