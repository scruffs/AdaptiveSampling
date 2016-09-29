import java.io.PrintWriter;
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
    private final int originLeaf;
    private boolean expanded = false;

    public void expandLeaf() {
        if (!expanded) {
            new Node(this);
            expanded = true;
            allLeaves.remove(this);
        }
        else {
            System.out.println("Leaf is already expanded!");
        }
    }

    public void writeLeaf(PrintWriter pw) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.leafParams.getMyParams().get(0));
        sb.append(", ");
        sb.append(this.yVal);
        sb.append(", ");
        sb.append(this.depth);
        sb.append(", ");
        sb.append(this.delta);
        sb.append(", ");
        sb.append(this.idNum);
        sb.append(", ");
        sb.append(this.originLeaf);
        sb.append("\n");

        pw.write(sb.toString());
    }

    // Constructor
    public Leaf(Params inputParams, double inputDelta, int nodeIn, int inDepth, int inLeaf) {
        numLeaves++;
        idNum = numLeaves;
        depth = inDepth;
        leafParams = inputParams;
        delta = inputDelta;
        myNode = nodeIn;
        originLeaf = inLeaf;
        double xVal = leafParams.getMyParams().get(0);
        yVal = 418.9829 - xVal * Math.sin(Math.sqrt(Math.abs(xVal)));
    }
    // Constructor overrides yVal
    public Leaf(Params inputParams, double inputDelta, int nodeIn, int inDepth,int inLeaf, double inYVal) {
        numLeaves++;
        idNum = numLeaves;
        depth = inDepth;
        leafParams = inputParams;
        delta = inputDelta;
        myNode = nodeIn;
        originLeaf = inLeaf;
        yVal = inYVal;
    }

    public int getIdNum() {
        return idNum;
    }

    public int getDepth() {
        return depth;
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
