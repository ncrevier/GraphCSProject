import java.util.*;
public class Pnode {

    private Integer dist = Integer.MAX_VALUE;
    private LinkedList<Pnode> shortestPath = new LinkedList<>();
    private int[] adjacentNodes;

    public int getDistance() {
        return dist;
    }

    public Pnode(int[] adj) {
        adjacentNodes = adj;
    }

    public int[] getAdjacentNodes() {
        return adjacentNodes;
    }
    public int setDistance(int newDist) {
        dist = newDist;
    }


}
