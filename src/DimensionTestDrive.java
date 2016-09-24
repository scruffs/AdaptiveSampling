import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * Created by laine on 13/09/2016.
 */

public class DimensionTestDrive {

    public static void main(String[] args) {

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
        Leaf.allLeaves.add(myLeaf);
        System.out.println("Leaf yVal = " + myLeaf.getyVal());
        System.out.println("Leaf depth is " + myLeaf.getDepth());
        System.out.println("First leaf delta is " + myLeaf.getDelta());

        System.out.println("Leaf List length is " + Leaf.allLeaves.size());

        myLeaf.expandLeaf();
        System.out.println("Leaf List length is " + Leaf.allLeaves.size());

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("test.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            sb.append(Leaf.allLeaves.get(i).getLeafParams().getMyParams().get(0));
            sb.append(", ");
            sb.append(Leaf.allLeaves.get(i).getyVal());
            sb.append(", ");
            sb.append(Leaf.allLeaves.get(i).getDepth());
            sb.append("\n");
        }
        pw.write(sb.toString());


        for (int i = 0; i < 10; i++) {
            for (int j = Node.maxDepth; j > 0; j--) {
                Leaf maxLeaf = null;
                double testMax= 0.0;
                for (Leaf in : Leaf.allLeaves) {
                    if (in.getDepth() == j & in.getExpanded() == false & in.getyVal() > testMax) {
                        maxLeaf = in;
                        testMax = in.getyVal();
                    }
                }
                if (maxLeaf != null) {
                    System.out.println("Expanding!");
                    maxLeaf.expandLeaf();
                    System.out.println("The y val is " + maxLeaf.getyVal());
                    System.out.println("The x val is " + maxLeaf.getLeafParams().getMyParams().get(0));
                    System.out.println("Node depth is " + maxLeaf.getDepth());

                    StringBuilder sb2 = new StringBuilder();

                    Leaf lowLeaf = Leaf.allLeaves.get(Leaf.allLeaves.size()-3);
                    Leaf hiLeaf = Leaf.allLeaves.get(Leaf.allLeaves.size()-1);

                    sb2.append(lowLeaf.getLeafParams().getMyParams().get(0));
                    sb2.append(", ");
                    sb2.append(lowLeaf.getyVal());
                    sb2.append(", ");
                    sb2.append(lowLeaf.getDepth());
                    sb2.append("\n");
                    sb2.append(hiLeaf.getLeafParams().getMyParams().get(0));
                    sb2.append(", ");
                    sb2.append(hiLeaf.getyVal());
                    sb2.append(", ");
                    sb2.append(hiLeaf.getDepth());
                    sb2.append("\n");

                    pw.write(sb2.toString());

                }
            }
        }


        pw.close();


//
//        System.out.println("Num of Nodes is  " + Node.numNodes);
//        System.out.println("Size of node list is " + Node.allNodes.size());
//        System.out.println("Num of leaves is " + Leaf.numLeaves);
//
//        int myLeafMax = Node.allNodes.get(0).findMax();
//
//        System.out.println("Max leaf is " + myLeafMax);
//        System.out.println("The y val is " + Node.allNodes.get(0).getNodeLeaves()[myLeafMax].getyVal());
//        System.out.println("The x val is " + Node.allNodes.get(0).getNodeLeaves()[myLeafMax].getLeafParams().getMyParams().get(0));
//        System.out.println("Node depth is " + Node.allNodes.get(0).getNodeLeaves()[myLeafMax].getDepth());
//        System.out.println("Second leaf delta is " + Node.allNodes.get(0).getNodeLeaves()[myLeafMax].getDelta());
//
//        System.out.println("The max depth is " + Node.maxDepth);
//
//        Node.allNodes.get(0).getNodeLeaves()[myLeafMax].expandLeaf();
//        System.out.println("Leaf List length is " + Leaf.allLeaves.size());
//
//        System.out.println("Num of Nodes is  " + Node.numNodes);
//        int myLeafMax2 = Node.allNodes.get(1).findMax();
//
//        System.out.println("Max leaf is " + myLeafMax2);
//        System.out.println("The y val is " + Node.allNodes.get(1).getNodeLeaves()[myLeafMax2].getyVal());
//        System.out.println("The x val is " + Node.allNodes.get(1).getNodeLeaves()[myLeafMax2].getLeafParams().getMyParams().get(0));
//        System.out.println("Node depth is " + Node.allNodes.get(1).getNodeLeaves()[myLeafMax2].getDepth());
//        System.out.println("Third leaf delta is " + Node.allNodes.get(1).getNodeLeaves()[myLeafMax2].getDelta());
//
//        System.out.println("The max depth is " + Node.maxDepth);
//
//        System.out.println("all Leaves is " + Leaf.allLeaves.get(2).getyVal());

    }

}
