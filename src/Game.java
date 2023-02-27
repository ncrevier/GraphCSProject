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


    Game(int nodesNum, int maxDistance, int percentZeros, int timeGiven){
        numNodes = nodesNum;
        myGraph = new Graph(numNodes);
        myGraph.randomlyGenerate(maxDistance, percentZeros);
        myframe = new RendererFrame(500,500,"Pathfinder!", myGraph, this);
        selectedNodes = new int[numNodes];
        selectedNodes[0] = 0;
        numNodesSelected = 0;

        myTimer = new Timer(1000, this);
        myTimer.start();
        time = timeGiven;
        runGame();
    }

    public int[] runGame(){
        boolean ended = false;
        System.out.println("game started");
        while(time > 0){
           int x = 5; //why does this have to exist?
        }
        System.out.println("Game ended!");
        return selectedNodes;


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
            time = 0;
            System.out.println("You found it!");

        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == myTimer){
            time--;
            myframe.theRenderer.actionPerformed(e);
        }
    }







}
