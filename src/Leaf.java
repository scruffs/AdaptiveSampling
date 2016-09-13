/**
 * Created by laine on 13/09/2016.
 */
public class Leaf {
    static int numLeaves;

    private final int idNum;
    private int depth = 0;
    private final Params leafParams;
    private final double yVal;
    private boolean expanded = false;

    public Leaf(Params inputParams) {
        numLeaves++;
        idNum = numLeaves;
        leafParams = inputParams;
        double xVal = leafParams.getMyParams().get(0);
        yVal = 418.9829 - xVal * Math.sin(Math.sqrt(Math.abs(xVal)));
    }

    public int getIdNum() {
        return idNum;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Params getLeafParams() {
        return leafParams;
    }

    public double getyVal() {
        return yVal;
    }
}