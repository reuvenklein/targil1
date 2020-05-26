package elements;

import primitives.Color;

public class AmbientLight {
    private Color Intensity;
    private int ka;

    public AmbientLight(Color intensity, int ka) {
        this.Intensity = intensity;

    }

    public void setIntensity(Color Intensity) {
        this.Intensity = Intensity;
    }
    public java.awt.Color GetIntensity()
    {
        return this.Intensity.getColor();
    }

}
