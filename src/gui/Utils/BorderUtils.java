package gui.Utils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static gui.Utils.FontUtils.HEADER_FONT;

public class BorderUtils {

    public static Border createBorder(String title){
        return createBorder(title, HEADER_FONT);
    }

    public static Border createBorder(String title, Font font){
        TitledBorder border = BorderFactory.createTitledBorder(title);
        border.setTitleFont(font);
        Border margin =  BorderFactory.createEmptyBorder(5, 5, 5, 5);
        return BorderFactory.createCompoundBorder(border, margin);
    }
}
