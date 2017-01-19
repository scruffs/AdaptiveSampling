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


    }
}
