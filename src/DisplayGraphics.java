import javax.swing.*;
import java.awt.*;

public class DisplayGraphics extends Canvas{
    public void paint(Graphics g) {
        g.drawString("Hello",80,40);
        g.drawString("Hi",40,80);

        g.drawOval(30,130,50, 50);
        setForeground(Color.BLACK);
    }
}  