import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Dave on 13/09/2016.
 * Each leaf
 */
public class Leaf {
    public static int numLeaves;
    public static ArrayList<Leaf> unexpandedLeaves = new ArrayList<>();
    private static PrintWriter printWriter = null;

    private final int idNum;
    private int depth;
    private final CoOrds leafCoOrds;
    private final double delta;
    private final double yVal;
    private final int myNode;
    private final int originLeaf;


    public void ExpandLeaf() {
        if (CheckDeltaMin()) {
            Node ExpandingNode = new Node(this);
            unexpandedLeaves.remove(this);
            WriteExpandingNodeToFile(ExpandingNode);
        } else {
            System.out.println("Node already expanded to max depth!");
        }
    }

    public boolean CheckDeltaMin() {
        return delta / 3 > Dimension.allDims.get(0).getDimDelta();
    }

    public void WriteExpandingNodeToFile(Node ExpandingNode) {
        for (Leaf leafToWrite : ExpandingNode.getNodeLeaves()) {
            leafToWrite.WriteEachLeaf();
        }
    }

    public void WriteEachLeaf() {printWriter.write(BuildStringForFile());}

    public String BuildStringForFile() {
        return this.leafCoOrds.getMyCoOrds().get(0) + "," + this.yVal + "," + this.depth + "," + this.delta + "," + this.idNum + "," + this.originLeaf + "\n";
    }

    public void OpenPrintWriterToFile() {
        try {
            printWriter = new PrintWriter(new File("NewData.csv"));
            AddHeaderToFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void AddHeaderToFile() {
        StringBuilder sb = new StringBuilder();
            sb.append("x_val,y_val,depth,delta,LeafId,originLeaf\n");
            printWriter.write(sb.toString());
    }

    // Close print writer
    public static void ClosePrintWriter() {
        Objects.requireNonNull(printWriter).close();
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
}
