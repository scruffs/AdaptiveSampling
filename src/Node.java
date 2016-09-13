import java.util.ArrayList;

/**
 * Created by laine on 13/09/2016.
 */
public class Node {
    static ArrayList<Node> allNodes = new ArrayList<Node>;
    static int numNodes;

    private int nodeDepth;
    private double maxX;
    private double minX;
    private Leaf[] nodeLeaves = new Leaf[3];
    private final int nodeId;
    private final int originNode;
    private final int originLeaf;
    private final double maxY;
    private int maxLeaf;

    public Node(Leaf origLeaf) {
        numNodes++;

    }

}
