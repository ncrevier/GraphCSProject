import javax.swing.*;
import java.awt.*;

public class RendererFrame extends JFrame {

    RendererPanel theRenderer;

    public RendererFrame(int width, int height, String title, Graph g) {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true); // visible
        // sets the width: 640px and height: 640px
        this.getContentPane().setBackground(new Color(200, 90, 145));

        theRenderer = new RendererPanel(width, height, g);

        this.add(theRenderer);
        this.pack();

    }
}
