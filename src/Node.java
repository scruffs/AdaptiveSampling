import java.util.ArrayList;

/**
 * Created by laine on 13/09/2016.
 *
 */
public class Node {
    public static ArrayList<Node> allNodes = new ArrayList<Node>();
    public static int numNodes;
    public static int maxDepth;

    private int nodeDepth;
    private Leaf[] nodeLeaves = new Leaf[3];
    private final int nodeId;
    private final int originNode;
    private final int originLeaf;
    private double maxY;
    private int maxLeaf;

    public int findMax() {
        int start = -1;

        for (int i = 2; i > -1; i--) {
            if (nodeLeaves[i].getExpanded() == false) {
                maxY = nodeLeaves[i].getyVal();
                start = i;
            }
        }

        for (int i = start; i < 3; i++) {
            if (start == -1) {
                System.out.println("Node completely expanded!");
                return 0;
            }
            if (nodeLeaves[i].getyVal() > maxY & nodeLeaves[i].getExpanded() == false) {
                maxY = nodeLeaves[i].getyVal();
                maxLeaf = i;
            }
        }
        return maxLeaf;
    }

    // constructor
    public Node(Leaf ExpandingLeaf) {
        numNodes++;
        nodeId = numNodes;
        originLeaf = ExpandingLeaf.getIdNum();
        originNode = ExpandingLeaf.getMyNode();
        nodeDepth = ExpandingLeaf.getDepth() + 1;

        CheckSetMaxDepth();

        // Calculate the centres of the new leaves
        double leafCenter = ExpandingLeaf.getLeafCoOrds().getMyCoOrds().get(0);
        double leafDelta = ExpandingLeaf.getDelta();
        double newLeafDelta = leafDelta/3;

        // generate new leaves
        CoOrds[] newCoOrds = NewNodeCoOrds(leafCenter, newLeafDelta);
        FillNodeLeaves(newCoOrds, newLeafDelta, ExpandingLeaf);

        if (newLeafDelta > Dimension.allDims.get(0).getDimDelta()) {
            for (int i = 0; i < 3; i++) {
                Leaf.unexpandedLeaves.add(nodeLeaves[i]);
            }
        }

        // Add this node to the ArrayList of nodes.
        allNodes.add(this);
    }

    private void CheckSetMaxDepth() {
        if (nodeDepth > maxDepth) {
            maxDepth = nodeDepth;
        }
    }

    private CoOrds[] NewNodeCoOrds(double leafCenter, double newLeafDelta) {
        CoOrds[] NewCoOrds = new CoOrds[3];
        for (int i = -1; i < 2; i++) {
            NewCoOrds[i + 1] = new CoOrds(leafCenter + (i * 2 * newLeafDelta));
        }
        return NewCoOrds;
    }

    private void FillNodeLeaves(CoOrds[] newCoOrds, double newLeafDelta, Leaf ExpandingLeaf) {
        nodeLeaves[0] = new Leaf(newCoOrds[0], newLeafDelta, Node.this);
        nodeLeaves[1] = new Leaf(newCoOrds[1], newLeafDelta, nodeId, nodeDepth, originLeaf, ExpandingLeaf.getyVal());
        nodeLeaves[2] = new Leaf(newCoOrds[2], newLeafDelta, Node.this);
    }

    public double getMaxY() {
        return maxY;
    }

    public int getMaxLeaf() {
        return maxLeaf;
    }

    public int getNodeDepth() {
        return nodeDepth;
    }

    public int getNodeId() {
        return nodeId;
    }

    public int getOriginLeaf() { return originLeaf; }

    public Leaf[] getNodeLeaves() {
        return nodeLeaves;
    }
}
