import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Dave on 07/10/2016.
 * The implementation of the Simultaneous Optimistic Optimisation algorithm developed by Remi Munos.
 * A description can be found at http://chercheurs.lille.inria.fr/~munos/papers/files/FTML2012.pdf.
 */
public class SOOAlgorithm {

    public void AdapSamp() {

        // Make the first dimension
        Dimension test = new Dimension("schwef_x", -1000, 1000, 2);

        // Create an instance of parameters
        CoOrds myCoOrds = new CoOrds(0.0);

        // Create the first leaf with the parameters given above. This will be the centre of the parameter space
        Leaf startingLeaf = new Leaf(myCoOrds, 1000, 0, 0, 0);
        Leaf.unexpandedLeaves.add(startingLeaf);
        startingLeaf.OpenPrintWriterToFile();
        startingLeaf.ExpandLeaf();

        // This is the actual algorithm to expand nodes around the maximum yVal leaves
        for (int i = 0; i < 22; i++) {
            // Find the max yVal leaf at each node depth or below
            for (int j = Node.maxDepth; j > 0; j--) {
                Leaf maxLeaf = null;
                double testMax= -1000.0;
                for (Leaf in : Leaf.unexpandedLeaves) {
                    if (in.getDepth() <= j & !in.getExpanded() & in.getyVal() > testMax) {
                        maxLeaf = in;
                        testMax = in.getyVal();
                    }
                }
                // Check that an unexpanded leaf is available for each depth. Then expand it and write the data to file
                if (maxLeaf != null) {
                    System.out.println("Expanding!" + maxLeaf.getDepth());
                    maxLeaf.ExpandLeaf();
                    j = maxLeaf.getDepth();
                }
            }

        }

        Leaf.ClosePrintWriter();

        // Unit tests against known .csv file
        File unitTest = new File("UnitTestData.csv");
        File newOutput = new File("NewData.csv");
        boolean areFilesEqual = false;
        try {
            areFilesEqual = FileUtils.contentEquals(unitTest, newOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File testing produces " + areFilesEqual + " result!");
    }
}
