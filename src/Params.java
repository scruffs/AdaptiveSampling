import java.util.ArrayList;

/**
 * Created by laine on 13/09/2016.
 * The parameter class holds all the values for each dimension at a specifc measurement point
 */
public class Params {

    // this ArrayList will hold a value for all dims to set the current param vals for a leaf.
    public ArrayList<Double> myParams = new ArrayList<Double>();

    public Params(double... input) {
        int numb = Dimension.getNum_dims();
        if (input.length != numb) {
            System.out.println("Trying to input too many parameters!");
            return;
        }
        else {
            for (int i = 0; i < input.length; ++i) {
                // check for the correct number of params for dimensions.
                // then populate the Arraylist with a param value for all dims.
                if (input[i] <= Dimension.myDims.get(i).getParamMax() & input[i] >= Dimension.myDims.get(i).getParamMin()) {
                    myParams.add(input[i]);
                }
                else {
                    System.out.println("Dimension " + i + " is out of range!");
                }
            }
        }
    }

    public ArrayList<Double> getMyParams() {
        return myParams;
    }
}
