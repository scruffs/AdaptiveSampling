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
    private Leaf ExpandingLeaf;
    private final int nodeId;
    private final int originNode;
    private final int originLeaf;
    private double maxY;
    private int maxLeaf;
    private final int LeavesPerNode = 3;


    // constructor
    public Node(Leaf InputLeaf) {
        numNodes++;
        nodeId = numNodes;
        ExpandingLeaf = InputLeaf;
        originLeaf = ExpandingLeaf.getIdNum();
        originNode = ExpandingLeaf.getMyNode();
        nodeDepth = ExpandingLeaf.getDepth() + 1;

        CheckSetMaxDepth();
        CoOrds[] CoOrdsForNewLeaves = NewNodeCoOrds();
        FillNodeLeaves(CoOrdsForNewLeaves);
        AddLeavesToUnexpandedList();
        allNodes.add(this);
    }

    private void CheckSetMaxDepth() {
        if (nodeDepth > maxDepth) {
            maxDepth = nodeDepth;
        }
    }

    private CoOrds[] NewNodeCoOrds() {
        CoOrds[] NewCoOrds = new CoOrds[LeavesPerNode];
        for (int i = -1; i < 2; i++) {
            NewCoOrds[i + 1] = new CoOrds(LeafCentre() + (i * 2 * NewLeafDelta()));
        }
        return NewCoOrds;
    }

    private void FillNodeLeaves(CoOrds[] newCoOrds) {
        nodeLeaves[0] = new Leaf(newCoOrds[0], NewLeafDelta(), Node.this);
        nodeLeaves[1] = new Leaf(newCoOrds[1], NewLeafDelta(), Node.this, ExpandingLeaf.getyVal());
        nodeLeaves[2] = new Leaf(newCoOrds[2], NewLeafDelta(), Node.this);
    }

    private double LeafCentre() {
        return ExpandingLeaf.getLeafCoOrds().getMyCoOrds().get(0);
    }

    private double NewLeafDelta() {
        return ExpandingLeaf.getDelta()/ LeavesPerNode;
    }

    private void AddLeavesToUnexpandedList() {
        for (int i = 0; i < LeavesPerNode; i++) {
            Leaf.unexpandedLeaves.add(nodeLeaves[i]);
        }
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
