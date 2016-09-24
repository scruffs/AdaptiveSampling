import java.util.ArrayList;

/**
 * Created by laine on 13/09/2016.
 */
public class Node {
    public static ArrayList<Node> allNodes = new ArrayList<Node>();
    public static int numNodes;

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
    public Node(Leaf inputLeaf) {
        numNodes++;
        nodeId = numNodes;
        originLeaf = inputLeaf.getIdNum();
        originNode = inputLeaf.getMyNode();
        nodeDepth = inputLeaf.getDepth() + 1;

        // Calculate the centres of the new leaves
        double leafCenter = inputLeaf.getLeafParams().getMyParams().get(0);
        double leafDelta = inputLeaf.getDelta();
        double leafSpace = leafDelta/2;
        double newLeafDelta = leafDelta/3;

        // generate new leaves
        Params params0 = new Params(leafCenter - leafSpace);
        Params params2 = new Params(leafCenter + leafSpace);
        nodeLeaves[0] = new Leaf(params0, newLeafDelta, nodeId, nodeDepth);
        nodeLeaves[1] = new Leaf(inputLeaf.getLeafParams(), newLeafDelta, nodeId, nodeDepth, inputLeaf.getyVal());
        nodeLeaves[2] = new Leaf(params2, newLeafDelta, nodeId, nodeDepth);



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
