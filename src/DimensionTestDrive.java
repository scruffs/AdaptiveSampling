/**
 * Created by laine on 13/09/2016.
 */
public class DimensionTestDrive {

    public static void main(String[] args) {
        Dimension test = new Dimension("test1", 0.1, 21.1, 0.1);
        Dimension test2 = new Dimension("test2", 0.1, 21.1, 0.1);
        String name = test.getName();
        System.out.println("name = " + name);
        double min = test.getParamMin();
        System.out.println("min = " + min);
        double max = test.getParamMax();
        System.out.println("max = " + max);
        double delta = test.getParamDelta();
        System.out.println("delta = " + delta);

        System.out.println("Test1 name = " + test2.myDims.get(0).getName());
        System.out.println("Test2 name = " + test2.myDims.get(1).getName());
        System.out.println("No. of Dims = " + test.getNum_dims());
        Dimension test3 = new Dimension("test3", 0.1, 21.1, 0.1);
        System.out.println("No. of Dims = " + test2.getNum_dims());


        Params myParams = new Params(10.1, 10.1, 11);
        System.out.println("Params; 0 is " + myParams.getMyParams().get(0) + " 1 is "+ myParams.getMyParams().get(1) + " 2 is " + myParams.getMyParams().get(2));

    }

}
