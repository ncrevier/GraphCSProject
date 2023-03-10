import java.awt.event.*;

import javax.swing.*;

public class Game implements ActionListener{
    Graph myGraph;
    Pathfinding myPather;
    RendererFrame myframe;
    int[] selectedNodes;
    //Nodes that have been so far selected, in order, starting from the 0th node
    int numNodesSelected;
    int scoreOfPathPlayer;
    int scoreOfPathAlgorithm;
    int numNodes;
    Timer myTimer;
    int time;
    //Timer counts down until loss
    boolean gameWon;
    //A boolean for winning specifically
    boolean done;
    //A boolean for being "done", so that actionPerformed stops running after the game is finished



    Game(){

        myframe = new RendererFrame(500,500,"Pathfinder!", this);
        //Makes a frame for rendering

        //Starts at 0
        numNodesSelected = 0;
        //We don't count the starting node as a selected node
        gameWon = false;
        done = false;

        scoreOfPathPlayer = 0;






        //Starting a timer

    }

    public void startGame(int nodesNum, int maxDistance, int percentZeros, int timeGiven){
        time = timeGiven;
        numNodes = nodesNum;
        myGraph = new Graph(numNodes);
        myGraph.randomlyGenerate(maxDistance, percentZeros);
        selectedNodes = new int[numNodes];
        //This array will have those nodes in order, then the rest will be null
        selectedNodes[0] = 0;
        myframe.theRenderer.setGraph(myGraph);
        myPather = new Pathfinding(0, (int)(nodesNum/2), myGraph);
        scoreOfPathAlgorithm = myPather.findPath();

        myTimer = new Timer(1000, this);
        myTimer.start();



    }

    public void ButtonPressed(int Node) {
        boolean alreadySelected = false;
        //Boolean for whether the button pressed has already been pressed
        for (int i = 0; i < numNodesSelected+1; i++) {
            if(Node == selectedNodes[i]){
                alreadySelected = true;
            }
        }
        //Checking
        if (myGraph.getCost((selectedNodes[numNodesSelected]), Node) == 0 || alreadySelected) {
            //if either it's already been selected, or the cost is 0, aka there is no path between these nodes
            //note that "(selectedNodes[numNodesSelected]" is the most recently selected node
        }
        else{
            selectedNodes[numNodesSelected + 1] = Node;
            //Next node
            myframe.theRenderer.changeLineColor(selectedNodes[numNodesSelected], selectedNodes[numNodesSelected+1]);
            //Highlights line
            numNodesSelected++;
            if(Node == (int)(numNodes/2)){
                //Our end goal is to get from one side to the other
                gameWon = true;
                for (int i = 0; i < numNodesSelected; i++) {
                    scoreOfPathPlayer = scoreOfPathPlayer + myGraph.getCost(selectedNodes[i], selectedNodes[i+1]);
                    //Continuously adds the cost between each node, for total player distance

                }
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e){

        if (e.getSource() == myTimer){
            //Checks every 1000ms, aka every second
            if(!done) {
                if (gameWon) {
                    myframe.theRenderer.gameState = 1;
                    //The gamestate of winning
                    myframe.theRenderer.repaint();
                    done = true;
                    //Updating the Renderer panel
                }
                else if (time <= 0) {
                    myframe.theRenderer.gameState = 2;
                    //The gamestate of losing
                    myframe.theRenderer.repaint();
                    done = true;
                    //Updating the renderer panel
                }
                else {
                    //Decrease time, a counter
                    time--;
                    myframe.theRenderer.repaint();
                    //Updates renderer panel timer
                }
            }
        }
    }
}
