
public class Graph {
    int[][] matrix;
    int nodes;
//Hello

    public Graph(int size) {
        matrix = new int[size][size];
        nodes = 0;
        for (int i = 0; i<size; i++) {
            for(int j = 0; j< size; j++) {
                matrix[i][j] = 0;

                //A 0 value for a connection means there is no connection

            }
        }
        for (int i =0; i< size; i++) {
            addNode();
        }

    }


    public void addNode() {
        matrix[nodes][nodes] = 0;
        nodes++;
    }

    public void addEdge(int n1, int n2, int cost) {
        if(n1 < nodes && n2 < nodes && n1 >= 0 && n2 >=0) {
            matrix[n1][n2] = cost;
            matrix[n2][n1] = cost;
        }
    }

    public void randomlyGenerate(int maxDistance, int perchanceZeros) {
        int cost = 0;
        for(int i=0; i<nodes; i++) {
            for(int j=i; j<nodes; j++) {
                if(j!=i) {
                    if(100.0 * Math.random() < perchanceZeros) {
                        cost = 0;
                    }
                    else {
                        cost = 1+ (int) ((maxDistance) * Math.random());
                    }

                    addEdge(i, j, cost);
                }
            }
        }
        matrix[(int) (nodes/2)][0] = 0;
        matrix[0][(int) (nodes/2)] = 0;
        Pathfinding pf = new Pathfinding(0, (int) (nodes/2), this);
        if (!noIslands() || (pf.findPath() < maxDistance*2)){
            randomlyGenerate(maxDistance, perchanceZeros);
        }


    }

    public int getCost(int n1, int n2) {
        return matrix[n1][n2];

    }

    public int[] getConnections(int n1) {
        int[] returnArray = new int[nodes];
        for (int i=0; i<nodes; i++) {
            returnArray[i] = matrix[i][n1];
        }
        return returnArray;
    }

    public boolean noIslands(){
        int[] islandArray = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            islandArray[i] = 0;
        }
        islandArray[0] = 1;
        boolean progressing = true;
        int[] nodeConnectionArray = new int[nodes];
        while(progressing == true && !fullOfNotZeros(islandArray)){
            progressing = false;
            for(int i=0; i<nodes; i++){
                if(islandArray[i]== 1){
                    nodeConnectionArray = getConnections(i);
                    for(int j=0; j<nodes; j++){
                        if (nodeConnectionArray[j] != 0 && i != j && islandArray[j] == 0){
                            islandArray[j] = 1;
                            progressing = true;
                        }
                    }
                    islandArray[i] = 2;
                }
            }
        }
        return progressing;
    }

    public boolean fullOfNotZeros(int[] array){
        boolean yesIndeed = true;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0){
                yesIndeed = false;
                break;
            }
        }
        return yesIndeed;
    }

    public String toString() {
        String returnString = "";
        for (int i = 0; i<nodes; i++) {
            for(int j=0; j< nodes; j++) {
                returnString = returnString + matrix[i][j] + " ";

                //A 0 value for a connection means there is no connection
            }
            returnString = returnString + "\n";
        }
        return returnString;

    }

    public Node[] graphMaker(){
        Node[] node = new Node[this.nodes];
        double theta = 2*Math.PI/nodes;
        for (int row=0; row < nodes; row++){
            double x = Math.cos(theta * row);
            double y = Math.sin(theta * row);
            node[row] = new Node( x*250,  y*250, matrix[row]);
        }
        return node;
    }

    public int getSize() {
        return nodes;
    }
}






