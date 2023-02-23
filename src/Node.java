public class Node {

    /*
    interpreter:
[0 1 2 3 4]
[1 0 4 5 6]
[2 4 0 7 8]
[3 5 7 0 6]
[4 6 8 6 0]

on row 0, it will start on index 0 (making circles and connection with each node.
on row 1, it will start on index 1 (skipping the node already made w/ node 0) and go through.
etc. etc.

maybe make a "node" class for the drawing of nodes
attributes:
int[] paths = the row that the node applies to.
int xcoord = x coord
int ycoord = y coord

     */

    private boolean[] connected;



}
