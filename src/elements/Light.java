package elements;

import primitives.Color;

public abstract class  Light {
    protected Color _intensity;
/**
 * constructor
 * @param _intensity
 *
 */
    public Light(Color _intensity) {
        this._intensity = _intensity;
    }

    public Color get_intensity() {
        return new Color(_intensity);
    }
}
