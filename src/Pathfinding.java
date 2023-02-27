import java.util.*;
public class Pathfinding {
    private Pnode start, finish;
    private Graph graph;
    Pathfinding(int s, int f, Graph g) {
        start = new Pnode(s);
        finish = new Pnode(f);
        graph = g;
    }
    public int[] findPath() {
        ArrayList<Pnode> open = new ArrayList<>();
        ArrayList<Pnode> closed = new ArrayList<>();

        open.add(start);

        while(open.size() > 0) {
            Pnode curr = open.get(0);
            for (int i = 1; i<open.size(); i++) {
                if (open.get(i).getFCost() < curr.getFCost() || open.get(i).getFCost() == curr.getFCost()
                                                                && open.get(i).getHCost() < curr.getHCost()) {
                    curr = open.get(i);
                }
            }

            open.remove(curr);
            closed.add(curr);

            if (curr.getVal() == finish.getVal()) {
                // done
            }

        }
    }

}
