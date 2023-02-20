import javax.swing.*;

public class tester {

    public static void main(String[] args) {
        Graph myG = new Graph(10);
        System.out.println(myG);
        myG.randomlyGenerate(4, 50);
        System.out.println(myG);
        int[] firstNode = myG.getConnections(3);
        for(int i=0; i<10; i++) {
            System.out.print(firstNode[i]);
            if (i == 9) {
                System.out.println();
            }
        }
        System.out.println("Showing Bryan how GIT works");
        System.out.println("testing");


        TFrame frame = new TFrame(800, 800, "Main Frame"); // or new TFrame(); without a name

        JLabel label = new JLabel("Not Fortnite"); // creates a label with text "Not Fortnite"
        label.setText("Fortnite"); //changes text to "Not Fortnite"

        DisplayGraphics m = new DisplayGraphics();
        frame.add(m);
    }

}
