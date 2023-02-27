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
        JButton quitButton;
        String textDemo;
        Graphics2D g2D;

        Integer[][] colors;
        // a 2D array, storing a 1 for "selected" (color green) and 0 for "unselected" (black). simil

        JButton buttons[];
        // an array of buttons, one for each node.
        Game game;

        boolean gameWon;
        boolean gameLost;


    RendererPanel(int width, int height, Graph gr, Game ga){
            //image = new ImageIcon("").getImage();
            this.setPreferredSize(new Dimension(640,640));
            quitButton = new JButton();
            quitButton.addActionListener(this);
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
            quitButton.setEnabled(true);
            quitButton.setVisible(true);
            game = ga;
            gameWon = false;


        }

    public void changeLineColor(int n1, int n2) {
        colors[n1][n2] = 1;
        colors[n2][n1] = 1;
    }



    public void paint(Graphics g) {
        if(!gameWon && !gameLost) {


            g2D = (Graphics2D) g;
            g2D.setPaint(Color.PINK);
            g2D.fillRect(0, 0, 640, 640);



            g2D.setFont(new Font("Helvetica", Font.ITALIC, 20));
            g2D.setPaint(Color.BLACK);
            g2D.drawString("Timer: " + game.time, 530, 30);


            renderLines(g2D);
            renderNodes(g2D);

            for (int x = 0; x < NumOfNodes; x++) {
                this.add(buttons[x]);
                buttons[x].setBounds((int) nodesArray[x].getX() + 320 - 20, (int) nodesArray[x].getY() + 320 - 20, 40, 40);
            }
            this.add(quitButton);
            quitButton.setBounds(30, 30, 30, 30);
            g2D.setPaint(Color.RED);
            g2D.drawRect(30, 30, 30, 30);
        }
        else{
            endGame(g);
        }


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

        public void endGame(Graphics g){

            Graphics2D g2 = (Graphics2D) g;
            System.out.println(gameWon);
            g2.setPaint(Color.PINK);
            g2.fillRect(0, 0, 640, 640);
            System.out.println("ended");

            if(gameWon){
                g2.setPaint(Color.BLACK);
                g2.drawString("YOU WINNED ", 320, 320);
                System.out.println("winned");
            }
            else{
                g2.setPaint(Color.BLACK);
                g2.drawString("YOU LOST ", 320, 320);
                System.out.println("lost");
            }
        }





        @Override
        public void actionPerformed(ActionEvent e) {

            for (Integer x=0;x<NumOfNodes;x++) {
                if (e.getSource() == buttons[x]) {
//                    textDemo += x;
                    game.ButtonPressed(x);


                }
            }
            if(e.getSource() == quitButton){
                game.time = 0;
            }

            repaint();
        }

}