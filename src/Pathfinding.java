import java.util.*;
public class Pathfinding {
    private Pnode start, finish;
    private Graph graph;
    Pathfinding(int s, int f, Graph g) {
        graph = g;
        start = new Pnode(graph.getConnections(s));
        finish = new Pnode(graph.getConnections(f));
    }
    public int[] findPath() {
        Pnode[] coolerGraph = new Pnode[graph.getSize()];
        for (int i = 0; i<graph.getSize(); i++) {
            coolerGraph[i] = new Pnode(graph.getConnections(i));
        }
        start.setDistance(0);
        List<Pnode> closed = new ArrayList<>();
        PriorityQueue<Pnode> open = new PriorityQueue<>(Collections.singleton(start));


        for (int i = 0; i<coolerGraph.length; i++) {
            if (open.poll().getAdjacentNodes()[i] == 0) {
                coolerGraph[i].setDistance(start.getAdjacentNodes()[i]);
            }
        }

    }

}
