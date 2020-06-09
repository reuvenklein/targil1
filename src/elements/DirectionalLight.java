package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource {
    protected Vector _direction;

    /**
     * constructor
     *
     * @param _intensity
     */
    public DirectionalLight(Color _intensity,Vector direction) {
        super(_intensity);
        this._direction=direction;
    }

    @Override
    public Color getIntensity(Point3D p) {
        return super.get_intensity();
    }

    @Override
    public Vector getL(Point3D p) {
       return _direction;
    }
}
