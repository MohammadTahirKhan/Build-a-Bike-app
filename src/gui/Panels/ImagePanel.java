package gui.Panels;

import Product.Product;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImagePanel extends JPanel {

    static private final BufferedImage frame;
    static private final BufferedImage wheel;
    static private final BufferedImage handlebar;

    static {
        try {
            frame = ImageIO.read(ImagePanel.class.getClassLoader().getResource("resources/images/frame.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            wheel = ImageIO.read(ImagePanel.class.getClassLoader().getResource("resources/images/wheel.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            handlebar = ImageIO.read(ImagePanel.class.getClassLoader().getResource("resources/images/handlebar.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final BufferedImage image;

    public ImagePanel(Product.Products product) {
        switch (product) {
            case FRAME:
                image = frame;
                break;
            case WHEELS:
                image = wheel;
                break;
            case HANDLEBAR:
                image = handlebar;
                break;
            default:
                throw new IllegalArgumentException("Unknown product type");
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.getScaledInstance(this.getWidth(), this.getHeight(), BufferedImage.SCALE_SMOOTH), 0, 0, this); // see javadoc for more info on the parameters
    }

}