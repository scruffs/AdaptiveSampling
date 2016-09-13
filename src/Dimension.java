import java.util.ArrayList;

/**
 * Created by laine on 13/09/2016.
 * This class represents the dimensions that need to be optimised by the sampler.
 */
public class Dimension {
    // Make and array list to hold all dimensions created and a count of the total number of dims.
    public static ArrayList<Dimension> myDims = new ArrayList<Dimension>();
    private static int num_dims;


    private String name;
    private double paramMin;
    private double paramMax;
    private double paramDelta;

    public static int getNum_dims() {
        return num_dims;
    }

    public String getName (){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getParamMin() {
        return paramMin;
    }

    public void setParamMin(double paramMin) {
        this.paramMin = paramMin;
    }

    public void setParamDelta(double paramDelta) {
        this.paramDelta = paramDelta;
    }

    public double getParamDelta() {
        return paramDelta;
    }

    public void setParamMax(double paramMax) {
        this.paramMax = paramMax;
    }

    public double getParamMax() {
        return paramMax;
    }

    // the constructor must have all parameters set upon construction.
    // It also adds each new dimension to the static ArrayList and increments the total number of dims.
    public Dimension(String name, double paramMin, double paramMax, double paramDelta){
        setName(name);
        setParamMin(paramMin);
        setParamMax(paramMax);
        setParamDelta(paramDelta);
        myDims.add(this);
        num_dims++;
    }
}
