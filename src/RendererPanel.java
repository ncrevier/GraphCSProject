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

        Integer[][] colors;

        JButton buttons[];


    RendererPanel(int width, int height, Graph gr){
            //image = new ImageIcon("").getImage();
            this.setPreferredSize(new Dimension(640,640));
//            buttonDemo = new JButton();
//            buttonDemo.addActionListener(this);
            textDemo = "";
            NumOfNodes = 0;
            theGraph = gr;
            nodesArray = theGraph.graphMaker();
            NumOfNodes = theGraph.nodes;
            colors = new Integer[gr.matrix.length][gr.matrix.length];
            buttons = new JButton[NumOfNodes];
            for (int x=0;x<NumOfNodes;x++){
                buttons[x] = new JButton();
                buttons[x].addActionListener(this);
                buttons[x].setBounds((int)nodesArray[x].getX()+320-50, (int)nodesArray[x].getY()+320-50, 100,100);
                buttons[x].setEnabled(true);
                buttons[x].setVisible(true);
            }

        }

    public void setColor(){

    }



    public void paint(Graphics g) {



            g2D = (Graphics2D) g;
            //casting down
//            g2D.setPaint(new Color(20,20,2));
//            g2D.fillOval(310, 310, 20, 20);

            g2D.setFont(new Font("Helvetica", Font.ITALIC, 20));
            g2D.drawString(textDemo, 230, 250);

//            buttonDemo.setBounds(310,310,20,20);

//            buttonDemo.setEnabled(true);

//            this.add(buttonDemo);
            renderLines(g2D);
            renderNodes(g2D);
            for (int x=0;x<NumOfNodes;x++){
                this.add(buttons[x]);
            }



            //g2D.drawImage(image, coordinates);
        }

        public void renderLines(Graphics2D g){
            for (int i = 0; i < NumOfNodes; i++) {
                for (int j = i; j < NumOfNodes; j++) {
                    if (!((nodesArray[i].connections())[j]==0)){
                        int x1 = (int)nodesArray[i].getX() + 320;
                        int y1 = (int)nodesArray[i].getY() + 320;
                        int x2 = (int)nodesArray[j].getX() + 320;
                        int y2 = (int)nodesArray[j].getY() + 320;
                        g.drawLine(x1, y1, x2, y2);
                        g.setPaint(Color.BLACK);
                        g.drawString(String.valueOf((nodesArray[i].connections())[j]), (x1+x2)/2, (y1+y2)/2);
                    }

                }

            }

        }

        public void renderNodes(Graphics2D g) {

            for (Integer i = 0; i < NumOfNodes; i++) {
                g.setPaint(Color.BLACK);
                g.drawOval((int)nodesArray[i].getX() + 320 - 15, (int)nodesArray[i].getY() + 320 -15, 30, 30);
                g.setPaint(Color.white);
                g.fillOval((int)nodesArray[i].getX() + 320 - 14, (int)nodesArray[i].getY() + 320 -14, 28, 28);
                g.setPaint(Color.PINK);
                g.drawString(i.toString(), (int)nodesArray[i].getX() + 320, (int)nodesArray[i].getY() + 320);

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
            System.out.println("w");
            for (Integer x=0;x<NumOfNodes;x++) {
                if (e.getSource() == buttons[x]) {
//                    textDemo += x;
                    System.out.println(x);
                    repaint();
                }
            }
        }

}