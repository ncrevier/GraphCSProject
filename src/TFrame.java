import javax.swing.*;
import java.awt.*;

public class TFrame extends JFrame {
    public TFrame(int width, int height, String title) {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        this.setResizable(false);
        this.setVisible(true); // visible
        this.setSize(width, height); // sets the width: 640px and height: 640px
        this.getContentPane().setBackground(new Color(200, 90, 145));
    }
}
