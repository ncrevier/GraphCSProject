import java.awt.event.*;

import javax.swing.*;

public class Game implements ActionListener{
    Graph myGraph;
    RendererFrame myframe;
    int[] selectedNodes;
    int numNodesSelected;
    int numNodes;
    Timer myTimer;
    int time;
    int uselessTask;
    boolean gameWon;
    boolean done;


    Game(int nodesNum, int maxDistance, int percentZeros, int timeGiven){
        numNodes = nodesNum;
        myGraph = new Graph(numNodes);
        myGraph.randomlyGenerate(maxDistance, percentZeros);
        myframe = new RendererFrame(500,500,"Pathfinder!", myGraph, this);
        selectedNodes = new int[numNodes];
        selectedNodes[0] = 0;
        numNodesSelected = 0;
        gameWon = false;
        done = false;



        myTimer = new Timer(1000, this);
        myTimer.start();
        time = timeGiven;

    }

    public void ButtonPressed(int Node) {
        boolean alreadySelected = false;
        for (int i = 0; i < numNodesSelected+1; i++) {
            if(Node == selectedNodes[i]){
                alreadySelected = true;
            }
        }
        if (myGraph.getCost((selectedNodes[numNodesSelected]), Node) == 0 || alreadySelected) {
            //yeah no don't do it
        }
        else{
            selectedNodes[numNodesSelected + 1] = Node;
            myframe.theRenderer.changeLineColor(selectedNodes[numNodesSelected], selectedNodes[numNodesSelected+1]);

            numNodesSelected++;
        }
        if(Node == (int)(numNodes/2)){
            //since that is our end goal

            gameWon = true;

        }
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if (e.getSource() == myTimer){
            if(!done) {

                if (gameWon == true || time <= 0) {
                    if (gameWon) {
                        myframe.theRenderer.gameWon = true;
                    } else {
                        myframe.theRenderer.gameLost = true;
                    }

                    myframe.theRenderer.repaint();
                    done = true;
                } else {

                    time--;
                    myframe.theRenderer.actionPerformed(e);
                }
            }
        }
    }







}
