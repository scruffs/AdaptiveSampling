import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Dave on 13/09/2016.
 * Each leaf
 */
public class Leaf {
    public static int numLeaves;
    public static ArrayList<Leaf> unexpandedLeaves = new ArrayList<>();

    private final int idNum;
    private int depth;
    private final CoOrds leafCoOrds;
    private final double delta;
    private final double yVal;
    private final int myNode;
    private final int originLeaf;
    private boolean expanded = false;

    public void ExpandLeaf(PrintWriter pw) {
        if (CheckDeltaMinAndExpanded()) {
            Node ExpandingNode = new Node(this);
            expanded = true;
            unexpandedLeaves.remove(this);
            WriteExpandingNodeToFile(ExpandingNode, pw);
        }
        else {
            System.out.println("Leaf is already expanded!");
        }
    }

    public boolean CheckDeltaMinAndExpanded() {
        return !expanded && delta/3 > Dimension.allDims.get(0).getDimDelta();
    }

    public void WriteExpandingNodeToFile(Node ExpandingNode, PrintWriter pw) {
        for (Leaf leafToWrite : ExpandingNode.getNodeLeaves()) {
            leafToWrite.WriteEachLeaf(pw);
        }
    }

    public void WriteEachLeaf(PrintWriter pw) {
        pw.write(BuildStringForFile());
    }

    public String BuildStringForFile() {
        return this.leafCoOrds.getMyCoOrds().get(0) + "," + this.yVal + "," + this.depth + "," + this.delta + "," + this.idNum + "," + this.originLeaf + "\n";
    }

    // Constructor
    public Leaf(CoOrds inputCoOrds, double inputDelta, int nodeIn, int inDepth, int inLeaf) {
        numLeaves++;
        idNum = numLeaves;
        depth = inDepth;
        leafCoOrds = inputCoOrds;
        delta = inputDelta;
        myNode = nodeIn;
        originLeaf = inLeaf;
        double xVal = leafCoOrds.getMyCoOrds().get(0);
        yVal = 418.9829 - xVal * Math.sin(Math.sqrt(Math.abs(xVal)));
    }
    // Constructor
    public Leaf(CoOrds inputCoOrds, double inputDelta, Node originNode) {
        numLeaves++;
        idNum = numLeaves;
        depth = originNode.getNodeDepth();
        leafCoOrds = inputCoOrds;
        delta = inputDelta;
        myNode = originNode.getNodeId();
        originLeaf = originNode.getOriginLeaf();
        double xVal = leafCoOrds.getMyCoOrds().get(0);
        yVal = 418.9829 - xVal * Math.sin(Math.sqrt(Math.abs(xVal)));
    }
    // Constructor overrides yVal
    public Leaf(CoOrds inputCoOrds, double inputDelta, Node originNode, double inYVal) {
        numLeaves++;
        idNum = numLeaves;
        depth = originNode.getNodeDepth();
        leafCoOrds = inputCoOrds;
        delta = inputDelta;
        myNode = originNode.getNodeId();
        originLeaf = originNode.getOriginLeaf();
        yVal = inYVal;
    }

    public int getIdNum() {
        return idNum;
    }

    public int getDepth() {
        return depth;
    }

    public CoOrds getLeafCoOrds() {
        return leafCoOrds;
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
