import org.w3c.dom.ls.LSOutput;

import java.util.*;
public class Pathfinding {
    private Pnode start, finish;
    private int s_s, f_f;
    private Graph graph;

    Pathfinding(int s, int f, Graph g) {
        graph = g;
//        start = new Pnode(graph.getConnections(s));
//        finish = new Pnode(graph.getConnections(f));
        s_s = s;
        f_f = f;
    }

    public int findPath() {
        Pnode[] coolerGraph = new Pnode[graph.getSize()];
        for (int i = 0; i < graph.getSize(); i++) {
            coolerGraph[i] = new Pnode(graph.getConnections(i));
        }
        List<Pnode> closed = new ArrayList<Pnode>();
        start = coolerGraph[s_s];
        finish = coolerGraph[f_f];
        System.out.println("finish adjnodes " + finish.getAdjacentNodes());

        // your values will be in a matrix w/ index corresponding to node # in graph
        PriorityQueue<Pnode> frontier = new PriorityQueue<Pnode>();
        start.setDistance(0);
        System.out.println("start adjNodes " + start.getAdjacentNodes());
        frontier.add(start);

        while (!frontier.isEmpty()) {
            //pop out the frontier; we are now evaluating this node
            Pnode curr = frontier.poll();
            // for each node adjacent to our frontier...
            int pass = 0;
            for (int i : curr.getAdjacentNodes()) {
                System.out.println(++pass + "===================================");
                // check if its 'distance' is inf, meaning it has not been set one yet (in relation to first node)
                if (coolerGraph[i].getDistance() == Integer.MAX_VALUE) {
                    // we set its new dist to the curr node dist + the dist from curr to it.
                    coolerGraph[i].setDistance(curr.getAdjacentDistances()[i] + curr.getDistance());
                    System.out.println(i + " to start :: " + coolerGraph[i].getDistance());
                    System.out.println(i + "the adjNodes :: " +coolerGraph[i].getAdjacentNodes());
                    // this node is now our new frontier.
                    frontier.add(coolerGraph[i]);
                } else {
                    if (curr.getDistance() + curr.getAdjacentDistances()[i] <= coolerGraph[i].getDistance()) {
                        coolerGraph[i].setDistance(curr.getDistance() + curr.getAdjacentDistances()[i]);
                        System.out.println(i + " to start :: " + coolerGraph[i].getDistance());
                        System.out.println(i + "the adjNodes :: " +coolerGraph[i].getAdjacentNodes());


                    }
                }
            }
            // byebye current, you are being reassigned!
        }
        System.out.println("final ans:" + finish.getDistance());
        return finish.getDistance();
    }
}
/* dist from start node to another node
dist from its neighbors
A --> B + B --> C = A ---> C
first val always going to be less
to get shortest dist: distance to one before it + that to the next node.
if its less, it changes, otherwise, change.
run thru entire graph, get to end, then the dist will be set to the shortest one possible



*/
