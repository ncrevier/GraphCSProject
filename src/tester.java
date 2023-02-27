
public class tester {

    public static void main(String[] args) {
        Graph myG = new Graph(10);
//        System.out.println(myG);
        myG.randomlyGenerate(4, 50);
        System.out.println(myG);
//        int[] firstNode = myG.getConnections(3);
//        for(int i=0; i<10; i++) {
//            System.out.print(firstNode[i]);
//            if (i == 9) {
//                System.out.println();
//            }
//        }
//        System.out.println("Showing Bryan how GIT works");
//        System.out.println("testing");
        Game game = new Game(6, 5, 50, 5);


    }

}
