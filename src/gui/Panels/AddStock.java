package gui.Panels;

import SQL.Queries.Product.SQLProduct;
import gui.Frames.BaseFrame;

import javax.swing.*;
import java.awt.*;

public class AddStock extends JPanel {

    private final JButton addStock;
    private final BaseFrame parentFrame;

    private final TextField quantityField;
    private final TextField serialNumberField;
    private final TextField brandNameField;


    public AddStock(BaseFrame baseFrame) {
        parentFrame = baseFrame;
        JPanel form = new JPanel();
        JLabel addStockTitle = new JLabel();

        Label serialNumberLabel = new Label();
        serialNumberField = new TextField();
        Label brandNameLabel = new Label();
        brandNameField = new TextField();
        Label quantityLabel = new Label();
        quantityField = new TextField();

        Label formTitle = new Label();
        addStock = new JButton();

        addStockTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        addStockTitle.setHorizontalAlignment(SwingConstants.CENTER);
        addStockTitle.setText("Add Stock");

        initializeButtons();

        form.setBorder(BorderFactory.createEtchedBorder());

        serialNumberLabel.setText("Serial Number");

        quantityLabel.setText("Quantity");

        brandNameLabel.setText("Brand Name");

        formTitle.setAlignment(Label.CENTER);
        formTitle.setFont(new Font("Dialog", Font.PLAIN, 18)); // NOI18N
        formTitle.setText("Enter Details Below");

        GroupLayout formLayout = new GroupLayout(form);
        form.setLayout(formLayout);
        int PREFERRED = GroupLayout.PREFERRED_SIZE;
        int DEFAULT = GroupLayout.DEFAULT_SIZE;
        GroupLayout.Alignment LEADING = GroupLayout.Alignment.LEADING;
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
                            .addComponent(brandNameLabel, PREFERRED, DEFAULT, PREFERRED)
                            .addComponent(brandNameField, PREFERRED, 317, PREFERRED)
                            .addComponent(quantityField, PREFERRED, 317, PREFERRED)
                            .addComponent(serialNumberField, PREFERRED, 317, PREFERRED)))
                    .addGroup(formLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(addStock, PREFERRED, 95, PREFERRED)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        GroupLayout.Alignment TRAILING = GroupLayout.Alignment.TRAILING;
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
                .addComponent(brandNameLabel, PREFERRED, DEFAULT, PREFERRED)
                .addGap(0, 0, 0)
                .addComponent(brandNameField, PREFERRED, DEFAULT, PREFERRED)
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

        addStock.addActionListener(e -> {
            SQLProduct.addStock(
                    Integer.parseInt(serialNumberField.getText().trim()),
                    brandNameField.getText().trim(),
                    Integer.parseInt(quantityField.getText().trim())
            );
            parentFrame.displayPanel(parentFrame.stockBrowse, false, false, false, false, true);
        });
    }
}
