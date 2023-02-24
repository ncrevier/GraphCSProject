public class Node{
    private int xcoord;
    private int ycoord;
    private int[] connections;
    // each index related to node it is connected to. a 0 value means it is not connected.

    // each index relates to the node it is connected to. returns true if connected, false if not.
    // returns true for self.

    public Node(int x, int y, int[] connections) {
        xcoord=x;
        ycoord=y;
        this.connections=connections;
        // position of self will reflect its position in Graph; see graphMaker
    }

    public int getXcoord(){
        return xcoord;
    }

    public int getYcoord(){
        return ycoord;
    }









}
