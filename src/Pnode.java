public class Pnode {
    private int fCost;
    private int gCost;
    private int hCost;
    private int val;
    public Pnode(int v) {
        val = v;
    }

    public void calculateFCost() {
        fCost = gCost + hCost;
    }
    public void calculateGCost() {

    }
    public void calculateHCost() {

    }

    public int getFCost() {
        return fCost;
    }
    public int getGCost() {
        return gCost;
    }
    public  int getHCost() {
        return hCost;
    }
    public int getVal() {
        return val;
    }

}
