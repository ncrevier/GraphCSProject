import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class RendererPanel extends JPanel implements ActionListener{

        Node[] nodesArray;
        Color desiredPaint;
        Graph theGraph;
        int NumOfNodes;
        Button[] buttonArray;
        JButton buttonDemo;
        String textDemo;
        Graphics2D g2D;


        RendererPanel(int width, int height, Graph gr){
            //image = new ImageIcon("").getImage();
            this.setPreferredSize(new Dimension(640,640));
            buttonDemo = new JButton();
            buttonDemo.addActionListener(this);
            textDemo = "";
            NumOfNodes = 0;
            theGraph = gr;
            nodesArray = theGraph.graphMaker();
            NumOfNodes = theGraph.nodes;

        }

        public void paint(Graphics g) {



            g2D = (Graphics2D) g;
            //casting down
            g2D.setPaint(new Color(20,20,2));
            g2D.fillOval(310, 310, 20, 20);

            g2D.setFont(new Font("Helvetica", Font.ITALIC, 20));
            g2D.drawString(textDemo, 230, 250);

            buttonDemo.setBounds(310,310,20,20);

            buttonDemo.setEnabled(true);

            this.add(buttonDemo);
            renderLines(g2D);
            renderNodes(g2D);


            //g2D.drawImage(image, coordinates);
        }

        public void renderLines(Graphics2D g){
            for (int i = 0; i < NumOfNodes; i++) {
                for (int j = i; j < NumOfNodes; j++) {
                    g.drawLine((int)nodesArray[i].getX() + 320, (int)nodesArray[i].getY() + 320, (int)nodesArray[j].getX() + 320, (int)nodesArray[j].getY() + 320);
                    g.setPaint(desiredPaint);
                }

            }

        }

        public void renderNodes(Graphics2D g) {

            for (int i = 0; i < NumOfNodes; i++) {
                g.drawOval((int)nodesArray[i].getX() + 320 - 5, (int)nodesArray[i].getY() + 320 -5, 10, 10);
                g.setPaint(desiredPaint);
                //g.drawLine((int)nodesArray[i].getX() + 320 - 5, (int)nodesArray[i].getY() + 320 -5,)

            }

            /*
            buttonArray = new Button[NumOfNodes];
            for (int i = 0; i < NumOfNodes; i++) {
                buttonArray[i] =

            }

             */



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