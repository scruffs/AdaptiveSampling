import java.util.ArrayList;

/**
 * Created by laine on 13/09/2016.
 * This class represents the dimensions that need to be optimised by the sampler.
 */
public class Dimension {
    // Make and array list to hold all dimensions created and a count of the total number of dims.
    public static ArrayList<Dimension> allDims = new ArrayList<Dimension>();
    private static int numDims;


    private String name;
    private double dimMin;
    private double dimMax;
    private double dimDelta;

    public static int getNumDims() {
        return numDims;
    }

    public String getName (){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDimMin() {
        return dimMin;
    }

    public void setDimMin(double dimMin) {
        this.dimMin = dimMin;
    }

    public void setDimDelta(double dimDelta) {
        this.dimDelta = dimDelta;
    }

    public double getDimDelta() {
        return dimDelta;
    }

    public void setDimMax(double dimMax) {
        this.dimMax = dimMax;
    }

    public double getDimMax() {
        return dimMax;
    }

    // the constructor must have all parameters set upon construction.
    // It also adds each new dimension to the static ArrayList and increments the total number of dims.
    public Dimension(String name, double dimMin, double dimMax, double dimDelta){
        setName(name);
        setDimMin(dimMin);
        setDimMax(dimMax);
        setDimDelta(dimDelta);
        allDims.add(this);
        numDims++;
    }
}
