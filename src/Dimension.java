/**
 * Created by laine on 13/09/2016.
 */
public class Dimension {
    private String name;
    private float paramMin;
    private float paramMax;
    private float paramDelta;

    public String getName (){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getParamMin() {
        return paramMin;
    }

    public void setParamMin(float paramMin) {
        this.paramMin = paramMin;
    }

    public void setParamDelta(float paramDelta) {
        this.paramDelta = paramDelta;
    }

    public float getParamDelta() {
        return paramDelta;
    }

    public void setParamMax(float paramMax) {
        this.paramMax = paramMax;
    }

    public float getParamMax() {
        return paramMax;
    }

    public Dimension(String name, float paramMin, float paramMax, float paramDelta){
        setName(name);
        setParamMin(paramMin);
        setParamMax(paramMax);
        setParamDelta(paramDelta);
    }
}
