public class Node{
    private double xcoord;
    // x-coord of center
    private double ycoord;
    // y-coord of center
    private int[] connections;
    // each index related to node it is connected to. a 0 value means it is not connected.

    // each index relates to the node it is connected to. returns true if connected, false if not.
    // returns true for self.

    public Node(double x, double y, int[] connections) {
        xcoord=x;
        ycoord=y;
        this.connections=connections;
        // position of self will reflect its position in Graph; see graphMaker
    }

    public double getX(){
        return xcoord;
    }

    public double getY(){
        return ycoord;
    }









}
