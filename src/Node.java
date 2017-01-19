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
    private final int LeavesPerNode = 3;


    // constructor
    public Node(Leaf ExpandingLeaf) {
        numNodes++;
        nodeId = numNodes;
        originLeaf = ExpandingLeaf.getIdNum();
        originNode = ExpandingLeaf.getMyNode();
        nodeDepth = ExpandingLeaf.getDepth() + 1;

        CheckSetMaxDepth();
        CoOrds[] CoOrdsForNewLeaves = NewNodeCoOrds(ExpandingLeaf);
        FillNodeLeaves(CoOrdsForNewLeaves, ExpandingLeaf);
        AddLeavesToUnexpandedList();
        allNodes.add(this);
    }

    private void CheckSetMaxDepth() {
        if (nodeDepth > maxDepth) {
            maxDepth = nodeDepth;
        }
    }

    private CoOrds[] NewNodeCoOrds(Leaf ExpandingLeaf) {
        CoOrds[] NewCoOrds = new CoOrds[LeavesPerNode];
        for (int i = -1; i < 2; i++) {
            NewCoOrds[i + 1] = new CoOrds(LeafCentre(ExpandingLeaf) + (i * 2 * NewLeafDelta(ExpandingLeaf)));
        }
        return NewCoOrds;
    }

    private void FillNodeLeaves(CoOrds[] newCoOrds, Leaf ExpandingLeaf) {
        nodeLeaves[0] = new Leaf(newCoOrds[0], NewLeafDelta(ExpandingLeaf), Node.this);
        nodeLeaves[1] = new Leaf(newCoOrds[1], NewLeafDelta(ExpandingLeaf), Node.this, ExpandingLeaf.getyVal());
        nodeLeaves[2] = new Leaf(newCoOrds[2], NewLeafDelta(ExpandingLeaf), Node.this);
    }

    private double LeafCentre(Leaf ExpandingLeaf) {
        return ExpandingLeaf.getLeafCoOrds().getMyCoOrds().get(0);
    }

    private double NewLeafDelta(Leaf ExpandingLeaf) {
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
