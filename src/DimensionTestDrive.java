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

        Params myParams = new Params(301.6);
        System.out.println("Params; 0 is " + myParams.getMyParams().get(0));

        Leaf myLeaf = new Leaf(myParams);
        System.out.println("Leaf yVal = " + myLeaf.getyVal());

    }

}
