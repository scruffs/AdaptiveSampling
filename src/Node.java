import java.io.PrintWriter;
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
                System.out.println("Node completly expanded!");
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
    public Node(Leaf inputLeaf, PrintWriter pw) {
        numNodes++;
        nodeId = numNodes;
        originLeaf = inputLeaf.getIdNum();
        originNode = inputLeaf.getMyNode();
        nodeDepth = inputLeaf.getDepth() + 1;

        // Make sure maxDepth is set properly
        if (nodeDepth > maxDepth) {
            maxDepth = nodeDepth;
        }

        // Calculate the centres of the new leaves
        double leafCenter = inputLeaf.getLeafCoOrds().getMyCoOrds().get(0);
        double leafDelta = inputLeaf.getDelta();
        double newLeafDelta = leafDelta/3;

        // generate new leaves
        CoOrds coOrds0 = new CoOrds(leafCenter - (2 * newLeafDelta));
        CoOrds coOrds2 = new CoOrds(leafCenter + (2 * newLeafDelta));
        nodeLeaves[0] = new Leaf(coOrds0, newLeafDelta, nodeId, nodeDepth, originLeaf);
        nodeLeaves[1] = new Leaf(inputLeaf.getLeafCoOrds(), newLeafDelta, nodeId, nodeDepth, originLeaf, inputLeaf.getyVal());
        nodeLeaves[2] = new Leaf(coOrds2, newLeafDelta, nodeId, nodeDepth, originLeaf);

        for (int i = 0; i < 3; i++) {
            nodeLeaves[i].writeLeaf(pw);
        }

        if (newLeafDelta > Dimension.allDims.get(0).getParamDelta()) {
            for (int i = 0; i < 3; i++) {
                Leaf.allLeaves.add(nodeLeaves[i]);
            }
        }

        // Add this node to the ArrayList of nodes.
        allNodes.add(this);
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

    public Leaf[] getNodeLeaves() {
        return nodeLeaves;
    }
}
