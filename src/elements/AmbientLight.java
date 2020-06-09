package elements;

import primitives.Color;

public class AmbientLight extends Light {
     Color iA;

    public AmbientLight(Color iA,double kA)
    {
        super(iA.scale(kA));
    }
    public AmbientLight(Color iA)
    {
        this(iA,1.d);
    }

}
