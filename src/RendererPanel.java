import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class RendererPanel extends JPanel implements ActionListener{

        Node[] nodesArray;
        //Array of nodes from the graphmaker method, will help determine location
        Graph theGraph;
        int NumOfNodes;
        JButton quitButton;
        //A quit button
        JButton startButton;
        //Start button
        JButton easyButton;
        JButton mediumButton;
        JButton hardButton;
        JButton impossibleButton;

        Integer[][] colors;
        // a 2D array, storing a 1 for "selected" (color green) and 0 for "unselected" (black),
        //This specifies the colors of the lines between nodes
        JButton buttons[];
        // an array of buttons, one for each node.
        Game game;
        //A model of the original game object, this is passed down from game itself
        int gameState;
        //0 is still going, 1 is won, 2 is lost, 3 is hasn't started, 4 is selecting difficulty



    RendererPanel(int width, int height, Game ga){
            this.setPreferredSize(new Dimension(640,640));
            //Defaults


            quitButton = new JButton();
            quitButton.addActionListener(this);
            quitButton.setEnabled(true);
            quitButton.setVisible(true);

            startButton = new JButton();
            startButton.addActionListener(this);
            startButton.setEnabled(true);
            startButton.setVisible(true);

            easyButton = new JButton();
            easyButton.addActionListener(this);
            easyButton.setEnabled(true);
            easyButton.setVisible(true);

            mediumButton = new JButton();
            mediumButton.addActionListener(this);
            mediumButton.setEnabled(true);
            mediumButton.setVisible(true);

            hardButton = new JButton();
            hardButton.addActionListener(this);
            hardButton.setEnabled(true);
            hardButton.setVisible(true);

            impossibleButton = new JButton();
            impossibleButton.addActionListener(this);
            impossibleButton.setEnabled(true);
            impossibleButton.setVisible(true);

            //Defaults for the buttons to work
            //Setting the game
            game = ga;
            gameState = 3;
        }


    public void setGraph(Graph g){
        theGraph = g;
        nodesArray = theGraph.graphMaker();
        NumOfNodes = theGraph.nodes;
        colors = new Integer[g.matrix.length][g.matrix.length];
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
            //Defaults for each button to work
        }
    }
    public void paint(Graphics g) {
        //this method runs on creation and whenever "repaint" is called
        Graphics2D g2D = (Graphics2D) g;
        if(gameState == 0) {
            //If the game isn't going anymore, no need for repainting

            //Downcasting because Graphics2D is more useful(it has setPaint)
            g2D.setPaint(Color.PINK);
            g2D.fillRect(0, 0, 640, 640);
            //Basically erasing things before
            g2D.setFont(new Font("Helvetica", Font.ITALIC, 20));
            g2D.setPaint(Color.BLACK);
            g2D.drawString("Timer: " + game.time, 530, 30);
            //Timer display
            renderLines(g2D);
            renderNodes(g2D);
            //Rendering each
            for (int x = 0; x < NumOfNodes; x++) {
                this.add(buttons[x]);
                buttons[x].setBounds((int) nodesArray[x].getX() + 320 - 20, (int) nodesArray[x].getY() + 320 - 20, 40, 40);
            }
            this.add(quitButton);
            quitButton.setBounds(30, 30, 30, 30);
            //Adding buttons afterwards
            g2D.setPaint(Color.RED);
            g2D.drawRect(30, 30, 30, 30);
            //Quit button Outline
        }
        else if(gameState == 3){
            g2D.setPaint(Color.PINK);
            g2D.fillRect(0, 0, 640, 640);
            g2D.setPaint(Color.BLACK);
            g2D.drawString("HELLO DO YOU WANT START? ", 240, 200);
            this.add(startButton);
            startButton.setBounds(280, 400, 80, 50);
            g2D.setPaint(Color.BLACK);
            g2D.drawString("START", 305, 420);
            g2D.drawRect(280, 400, 80, 50);


        }
        else if(gameState == 4){
            g2D.setPaint(Color.PINK);
            g2D.fillRect(0, 0, 640, 640);
            g2D.setPaint(Color.BLACK);
            g2D.drawString("SELECT UR THING ", 270, 200);


            this.add(easyButton);
            g2D.setPaint(Color.GREEN);
            easyButton.setBounds(200, 300, 240, 40);
            g2D.drawString("EASY", 310, 320);
            g2D.drawRect(200, 300, 240, 40);
            g2D.drawString("From Node 0 to Node 2", 450, 320);
            this.add(mediumButton);
            g2D.setPaint(Color.orange);
            mediumButton.setBounds(200, 350, 240, 40);
            g2D.drawString("MEDIUM", 300, 370);
            g2D.drawRect(200, 350, 240, 40);
            g2D.drawString("From Node 0 to Node 3", 450, 370);
            this.add(hardButton);
            g2D.setPaint(Color.red);
            hardButton.setBounds(200, 400, 240, 40);
            g2D.drawString("HARD", 310, 420);
            g2D.drawRect(200, 400, 240, 40);
            g2D.drawString("From Node 0 to Node 4", 450, 420);
            this.add(impossibleButton);
            g2D.setPaint(Color.BLACK);
            impossibleButton.setBounds(200, 450, 240, 40);
            g2D.drawString("IMOSSIBLE", 295, 470);
            g2D.drawRect(200, 450, 240, 40);
            g2D.drawString("From Node 0 to Node 5", 450, 470);

        }
        else{
            endGame(g);
            //Runs the endGame, and passes "g" so endGame can do its own painting
        }
    }
    public void changeLineColor(int n1, int n2) {
        //Method is called from the game class
        //1 means it should be green, it will be later rendered as such
        colors[n1][n2] = 1;
        colors[n2][n1] = 1;
    }
        public void renderLines(Graphics2D g){
            for (int i = 0; i < NumOfNodes; i++) {
                for (int j = i; j < NumOfNodes; j++) {
                    //Double for-loop so it gets every line
                    if (!((nodesArray[i].connections())[j]==0)){
                        //when the value is 0, there is no connection, thus we need to check
                        int x1 = (int)nodesArray[i].getX() + 320;
                        int y1 = (int)nodesArray[i].getY() + 320;
                        int x2 = (int)nodesArray[j].getX() + 320;
                        int y2 = (int)nodesArray[j].getY() + 320;
                        //Adding 320 because nodesArray uses the center as (0,0), instead of the upper left corner
                        //Variables to make drawing the string easier later on
                        if(colors[i][j] == 0){
                            g.setPaint(Color.BLACK);
                        }
                        else{
                            //green is when its 1
                            g.setPaint(Color.green);
                        }
                        g.drawLine(x1, y1, x2, y2);
                        g.drawString(String.valueOf((nodesArray[i].connections())[j]), (x1+x2)/2, (y1+y2)/2);
                        //Drawing the string that shows the "cost"
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
                //For each node, an outer and inner circle to cover the not precise lines
                g.setPaint(Color.PINK);
                g.drawString(i.toString(), (int)nodesArray[i].getX() + 320-5, (int)nodesArray[i].getY() + 320+5);
                //Drawing the node number on it
            }
        }
        public void endGame(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            //Again, downcasting
            g2.setPaint(Color.PINK);
            g2.fillRect(0, 0, 640, 640);
            //Clearing the board
            if(gameState == 1){
                g2.setPaint(Color.BLACK);
                g2.drawString("YOU WINNED, Distance: " + game.scoreOfPathPlayer + " and best distance: " + game.scoreOfPathAlgorithm, 320, 320);
            }
            else if(gameState == 2){
                g2.setPaint(Color.BLACK);
                g2.drawString("YOU FAILED ", 320, 320);
            }
        }

        public void removeButtons(){
            this.remove(easyButton);
            this.remove(mediumButton);
            this.remove(hardButton);
            this.remove(impossibleButton);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        //This runs whenever a button is pressed
            for (Integer x=0;x<NumOfNodes;x++) {
                if (e.getSource() == buttons[x]) {
                    game.ButtonPressed(x);
                    //tells the game that a button is pressed -> various things happen from there
                }
            }
            if(e.getSource() == quitButton){
                game.time = 0;
            }
            //These check for which specific button and the action changes depending on which
            if(e.getSource() == startButton){
                gameState = 4;
                this.remove(startButton);
            }
            if(e.getSource() == easyButton){
                gameState = 0;
                game.startGame(5, 5, 50, 20);
                removeButtons();
            }
            if(e.getSource() == mediumButton){
                gameState = 0;
                game.startGame(7, 7, 50, 20);
                removeButtons();
            }
            if(e.getSource() == hardButton){
                gameState = 0;
                game.startGame(9, 15, 50, 20);
                removeButtons();
            }
            if(e.getSource() == impossibleButton){
                gameState = 0;
                game.startGame(11, 30, 50, 15);
                removeButtons();
            }
            repaint();
        }

}