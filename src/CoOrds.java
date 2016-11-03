import java.util.ArrayList;

/**
 * Created by laine on 13/09/2016.
 * The coordinate values for each leaf are stored in an array list of dimensions
 */
public class CoOrds {

    // this ArrayList will hold a value for all dims to set the current values for a leaf.
    public ArrayList<Double> myCoOrds = new ArrayList<Double>();

    //Constructor
    public CoOrds(double... dimValues) {
        if (CheckNumDimensions(dimValues.length)) {
            FillMyCoOrds(dimValues);
            return;
        }
        System.out.println("Number of dimensions incorrect!");
    }

    public boolean CheckNumDimensions(int dimValues) {
        return dimValues == Dimension.getNumDims();
    }

    public void FillMyCoOrds(double[] dimValues) {
        for (int i = 0; i < dimValues.length; ++i) {
            if (CheckMinMaxValues(dimValues[i], i)) {
                myCoOrds.add(dimValues[i]);
            }
            else {
                System.out.println("Dimension " + i + " is out of range!");
            }
        }
    }

    public boolean CheckMinMaxValues(double dimValue, int i){
        return dimValue <= Dimension.allDims.get(i).getParamMax() & dimValue >= Dimension.allDims.get(i).getParamMin();
    }

    public ArrayList<Double> getMyCoOrds() {
        return myCoOrds;
    }
}
