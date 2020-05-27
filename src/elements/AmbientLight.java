package elements;

import primitives.Color;

public class AmbientLight {
     Color iA;

    public AmbientLight(Color iA,double kA) {
        this.iA = iA.scale(kA);
    }
    public AmbientLight(Color iA)
    {
        this(iA,1.d);
    }
    public Color getIntensity()
    {
        return iA;
    }
}
