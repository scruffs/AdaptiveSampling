/**
 * Created by Dave on 07/10/2016.
 * The implementation of the Simultaneous Optimistic Optimisation algorithm developed by Remi Munos.
 * A description can be found at http://chercheurs.lille.inria.fr/~munos/papers/files/FTML2012.pdf.
 */
public class SOOAlgorithm {
    private final int startIterations = 0;
    private final int endIterations = 22;
    private Leaf maxLeaf = null;
    private double testMax;
    private int testNodeDepth;

    public void AdapaptiveSampling() {
        // This is the actual algorithm to expand nodes around the maximum yVal leaves
        for (int i = startIterations; i < endIterations ; i++) {
            // Find the max yVal leaf at each node depth or below
            for (testNodeDepth = Node.maxDepth; testNodeDepth > 0; testNodeDepth--) {
                ResetTestValues();
                FindMaxUnxpandedLeaf();

                // Check that an unexpanded leaf is available for each depth.
                // Then expand it and write the data to file
                if (maxLeaf != null) {
                    System.out.println("Expanding!" + maxLeaf.getDepth());
                    maxLeaf.ExpandLeaf();
                    testNodeDepth = maxLeaf.getDepth();
                }
            }
        }
    }

    private void ResetTestValues() {
        testMax = -1000.0;
        maxLeaf = null;
    }

    private void FindMaxUnxpandedLeaf() {
        for (Leaf in : Leaf.unexpandedLeaves) {
            if (TestIfBiggerThanMax(in)) {
                maxLeaf = in;
                testMax = in.getyVal();
            }
        }
    }

    private boolean TestIfBiggerThanMax(Leaf in){
        return CheckNodeDepth(in) & CheckIfMax(in);
    }

    private boolean CheckNodeDepth(Leaf in){
        return in.getDepth() <= testNodeDepth;
    }

    private boolean CheckIfMax(Leaf in){
        return in.getyVal() > testMax;
    }
}
