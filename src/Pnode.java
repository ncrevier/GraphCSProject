import java.util.*;
public class Pnode implements Comparable<Pnode> {

    private Integer dist = Integer.MAX_VALUE;
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
    @Override
    public int compareTo(Pnode otherPnode) {
        if (this.dist > otherPnode.getDistance()) {
            return 1;
        } else if (this.dist < otherPnode.getDistance()) {
            return -1;
        }
        return 0;
    }


}
