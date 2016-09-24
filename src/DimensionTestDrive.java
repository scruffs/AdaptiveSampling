import java.util.ArrayList;

/**
 * Created by laine on 13/09/2016.
 */
public class DimensionTestDrive {

    public static void main(String[] args) {
        //Leaf.numLeaves = 0;

        Dimension test = new Dimension("test1", -500, 500, 0.1);
        String name = test.getName();
        System.out.println("name = " + name);
        double min = test.getParamMin();
        System.out.println("min = " + min);
        double max = test.getParamMax();
        System.out.println("max = " + max);
        double delta = test.getParamDelta();
        System.out.println("delta = " + delta);

        System.out.println("No. of Dims = " + test.getNum_dims());

        Params myParams = new Params(0.0);
        System.out.println("Params; 0 is " + myParams.getMyParams().get(0));

        Leaf myLeaf = new Leaf(myParams, 500, 0, 0);
        System.out.println("Leaf yVal = " + myLeaf.getyVal());

        myLeaf.expandLeaf();
        System.out.println("Num of Nodes is  " + Node.numNodes);
        System.out.println("Size of node list is " + Node.allNodes.size());
        System.out.println("Num of leaves is " + Leaf.numLeaves);

        int myLeafMax = Node.allNodes.get(0).findMax();

        System.out.println("Max leaf is " + myLeafMax);
        System.out.println("The y val is " + Node.allNodes.get(0).getNodeLeaves()[myLeafMax].getyVal());
        System.out.println("The x val is " + Node.allNodes.get(0).getNodeLeaves()[myLeafMax].getLeafParams().getMyParams().get(0));

    }

}
