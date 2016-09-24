import java.util.ArrayList;

/**
 * Created by laine on 13/09/2016.
 */
public class Leaf {
    public static int numLeaves;
    public static ArrayList<Leaf> allLeaves = new ArrayList<>();

    private final int idNum;
    private int depth;
    private final Params leafParams;
    private final double delta;
    private final double yVal;
    private final int myNode;
    private boolean expanded = false;

    public void expandLeaf() {
        if (expanded == false) {
            Node newNode = new Node(this);
            expanded = true;
            allLeaves.remove(this);
        }
        else {
            System.out.println("Leaf is already expanded!");
        }
    }

    // Constructor
    public Leaf(Params inputParams, double inputDelta, int nodeIn, int inDepth) {
        numLeaves++;
        idNum = numLeaves;
        depth = inDepth;
        leafParams = inputParams;
        delta = inputDelta;
        myNode = nodeIn;
        double xVal = leafParams.getMyParams().get(0);
        yVal = 418.9829 - xVal * Math.sin(Math.sqrt(Math.abs(xVal)));
    }
    // Constructor overrides yVal
    public Leaf(Params inputParams, double inputDelta, int nodeIn, int inDepth, double inYVal) {
        numLeaves++;
        idNum = numLeaves;
        depth = inDepth;
        leafParams = inputParams;
        delta = inputDelta;
        myNode = nodeIn;
        yVal = inYVal;
    }

    public int getIdNum() {
        return idNum;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Params getLeafParams() {
        return leafParams;
    }

    public double getDelta() {
        return delta;
    }

    public double getyVal() {
        return yVal;
    }

    public int getMyNode() {
        return myNode;
    }

    public boolean getExpanded() {
        return expanded;
    }
}
