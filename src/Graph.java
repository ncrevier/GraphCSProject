


public class Graph {

    int[][] matrix;
    int nodes;



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
        matrix[nodes][nodes] = 9;
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
                    if(100 * Math.random() < perchanceZeros) {
                        cost = 0;
                    }
                    else {
                        cost = 1+ (int) ((maxDistance) * Math.random());
                    }

                    addEdge(i, j, cost);
                }
            }
        }


    }

    public int getCost(int n1, int n2) {
        return matrix[n1][n2];

    }

    public int[] getOneNodeConnections(int n1) {
        int[] returnArray = new int[nodes];
        for (int i=0; i<nodes; i++) {
            returnArray[i] = matrix[i][n1];
        }
        return returnArray;
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



}

