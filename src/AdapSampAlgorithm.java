import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by laine on 07/10/2016.
 */
public class AdapSampAlgorithm {

    public void AdapSamp() {

        // Make the first dimension
        Dimension test = new Dimension("test1", -1000, 1000, 2);

        // Create a instance of parameters
        Params myParams = new Params(0.0);

        // Create the first leaf with the parameters given above. This will be the centre of the parameter space
        Leaf myLeaf = new Leaf(myParams, 1000, 0, 0, 0);
        Leaf.allLeaves.add(myLeaf);

        // Open a printwriter instance to write everything to file
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("test.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Write header for output file
        StringBuilder sb = new StringBuilder();
        sb.append("x_val,y_val,depth,delta,LeafId,originLeaf\n");
        pw.write(sb.toString());

        // Expand this first leaf to generate the starting points
        myLeaf.expandLeaf(pw);

        // This is the actual algorithm to expand nodes around the maximum yVal leaves
        for (int i = 0; i < 18; i++) {
            // Find the max yVal leaf at each node depth
            for (int j = 1; j <= i + 1; j++) {
                Leaf maxLeaf = null;
                double testMax= -1000.0;
                for (Leaf in : Leaf.allLeaves) {
                    if (in.getDepth() == j & in.getExpanded() == false & in.getyVal() > testMax) {
                        maxLeaf = in;
                        testMax = in.getyVal();
                    }
                }
                // Check that an unexpanded leaf is available for each depth. Then expand it and write the data to file
                if (maxLeaf != null) {
                    System.out.println("Expanding!");
                    maxLeaf.expandLeaf(pw);

                }
            }

        }

        // Close print writer
        assert pw != null;
        pw.close();
    }
}
