import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by laine on 13/09/2016.
 */

public class DeterministicOptimisticOptimisation {

    public static void main(String[] args) {

        // Make the first dimension
        Dimension test = new Dimension("schwef_x", -1000, 1000, 2);

        // Create an instance of parameters
        CoOrds startingCoOrds = new CoOrds(0.0);

        Leaf startingLeaf = new Leaf(startingCoOrds, 1000, 0, 0, 0);
        Leaf.unexpandedLeaves.add(startingLeaf);
        startingLeaf.OpenPrintWriterToFile();
        startingLeaf.ExpandLeaf();


        new SOOAlgorithm().AdapSamp();

        Leaf.ClosePrintWriter();

        new UnitTester().PerformUnitTest();

    }


}
