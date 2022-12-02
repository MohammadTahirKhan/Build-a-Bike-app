package gui.Panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel(String filename) {
        try {
            image = ImageIO.read(this.getClass().getResource("/resources/images/" + filename));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.getScaledInstance(this.getWidth(), this.getHeight(), BufferedImage.SCALE_SMOOTH), 0, 0, this); // see javadoc for more info on the parameters
    }

}