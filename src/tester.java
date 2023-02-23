
public class tester {

    public static void main(String[] args) {
        Graph myG = new Graph(10);
        System.out.println(myG);
        myG.randomlyGenerate(4, 80);
        System.out.println(myG);
        System.out.println(myG.Islands());


    }

}
