import java.util.*;
public class Pnode implements Comparable<Pnode>{

    //temporary distance value so we know its not been assigned anything yet
    private Integer dist = Integer.MAX_VALUE;
    //shortest path of node
    private Integer shortestPath=null;
    //the node # of its adjacent nodes.
    private ArrayList<Integer> adjacentNodes;
    //distances to the adjacent nodes.
    private int[] adjacentDistance;

    public int getDistance() {
        return dist;
    }

    public Pnode(int[] adj) {
        adjacentDistance = adj;
        adjacentNodes = new ArrayList<Integer>(adj.length);
        for (int i=0;i<adj.length;i++){
            if (adjacentDistance[i]>0){
                adjacentNodes.add(i);
            }
        }
    }

    public ArrayList<Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public int[] getAdjacentDistances() {
        return adjacentDistance;
    }

    public void setNext(int node){
        // this has to be the index of the node in the graph
        shortestPath = node;
    }

    @Override
    public int compareTo(Pnode node){
        if (this.dist == node.getDistance()){
            return 0;
        }
        else if (this.dist < node.getDistance()){
            return -1;
        }
        return 1;
    }

    public int setDistance(int newDist) {
        dist = newDist;
        return dist;
    }

    public Integer getNext(){
        return shortestPath;
    }


}
