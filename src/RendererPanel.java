import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class RendererPanel extends JPanel implements ActionListener{


        JButton buttonDemo;
        String textDemo;
        Graphics2D g2D;


        RendererPanel(int width, int height){
            //image = new ImageIcon("").getImage();

            this.setPreferredSize(new Dimension(500,500));
            buttonDemo = new JButton();
            buttonDemo.addActionListener(this);
            textDemo = "";

        }

        public void paint(Graphics g) {



            g2D = (Graphics2D) g;
            //casting down
            g2D.setPaint(new Color(20,20,2));
            g2D.fillOval(240, 240, 20, 20);

            g2D.setFont(new Font("Helvetica", Font.ITALIC, 20));
            g2D.drawString(textDemo, 230, 250);

            buttonDemo.setBounds(240,240,20,20);

            buttonDemo.setEnabled(true);

            this.add(buttonDemo);


            //g2D.drawImage(image, coordinates);
        }



        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == buttonDemo) {
                textDemo += "0";
                repaint();
            }
        }






    /*
    interpreter:
[0 1 2 3 4]
[1 0 4 5 6]
[2 4 0 7 8]
[3 5 7 0 6]
[4 6 8 6 0]

on row 0, it will start on index 0 (making circles and connection with each node.
on row 1, it will start on index 1 (skipping the node already made w/ node 0) and go through.
etc. etc.

maybe make a "node" class for the drawing of nodes
attributes:
int[] paths = the row that the node applies to.
int xcoord = x coord
int ycoord = y coord

     */



}