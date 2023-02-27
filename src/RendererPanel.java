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
        // a 2D array, storing a 1 for "selected" (color green) and 0 for "unselected" (black). simil

        JButton buttons[];
        // an array of buttons, one for each node.
        Game game;


    RendererPanel(int width, int height, Graph gr, Game ga){
            //image = new ImageIcon("").getImage();
            this.setPreferredSize(new Dimension(640,640));
//            buttonDemo = new JButton();
//            buttonDemo.addActionListener(this);
            textDemo = "";
            theGraph = gr;
            nodesArray = theGraph.graphMaker();
            NumOfNodes = theGraph.nodes;
            colors = new Integer[gr.matrix.length][gr.matrix.length];
            // setting the color matrix as same size of the same matrix of the graph.
            for (int i = 0; i < NumOfNodes; i++) {
                for (int j = 0; j < NumOfNodes; j++) {
                    colors[i][j] = 0;
                }
            }
            buttons = new JButton[NumOfNodes];
            for (int x=0;x<NumOfNodes;x++){
                buttons[x] = new JButton();
                buttons[x].addActionListener(this);

                buttons[x].setEnabled(true);
                buttons[x].setVisible(true);
            }
            game = ga;


        }

    public void changeLineColor(int n1, int n2){
        colors[n1][n2] = 1;
        colors[n2][n1] = 1;

    }



    public void paint(Graphics g) {



            g2D = (Graphics2D) g;
            //casting down
//            g2D.setPaint(new Color(20,20,2));
//            g2D.fillOval(310, 310, 20, 20);

            g2D.setFont(new Font("Helvetica", Font.ITALIC, 20));
            g2D.drawString("Timer: " + game.time, 530, 30);

//            buttonDemo.setBounds(310,310,20,20);

//            buttonDemo.setEnabled(true);

//            this.add(buttonDemo);
            renderLines(g2D);
            renderNodes(g2D);
            for (int x=0;x<NumOfNodes;x++){
                this.add(buttons[x]);
                buttons[x].setBounds((int)nodesArray[x].getX()+320-20, (int)nodesArray[x].getY()+320-20, 40,40);
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
                        if(colors[i][j] == 0){
                            g.setPaint(Color.BLACK);
                        }
                        else{
                            g.setPaint(Color.green);
                        }
                        //g.setStroke();
                        g.drawLine(x1, y1, x2, y2);


                        g.drawString(String.valueOf((nodesArray[i].connections())[j]), (x1+x2)/2, (y1+y2)/2);
                    }

                }

            }

        }

        public void renderNodes(Graphics2D g) {

            for (Integer i = 0; i < NumOfNodes; i++) {
                g.setPaint(Color.BLACK);
                g.drawOval((int)nodesArray[i].getX() + 320 - 20, (int)nodesArray[i].getY() + 320 -20, 40, 40);
                g.setPaint(Color.white);
                g.fillOval((int)nodesArray[i].getX() + 320 - 19, (int)nodesArray[i].getY() + 320 -19, 38, 38);
                g.setPaint(Color.PINK);
                g.drawString(i.toString(), (int)nodesArray[i].getX() + 320-5, (int)nodesArray[i].getY() + 320+5);

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
            }

            for (Integer x=0;x<NumOfNodes;x++) {
                if (e.getSource() == buttons[x]) {
//                    textDemo += x;
                    game.ButtonPressed(x);

                }
            }
            repaint();
        }

}