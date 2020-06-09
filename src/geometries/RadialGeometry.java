package geometries;

import primitives.Color;
import primitives.Material;

public abstract class RadialGeometry extends Geometry {
    double _radius;
/**
 * @param _radius
 * @param emissionLight
 */

    public RadialGeometry(Color emissionLight, double _radius) {
        super(emissionLight);
        set_radius(_radius);
    }
    public RadialGeometry(Color emissionLight, Material material, double _radius) {
        super(emissionLight,material);
        set_radius(_radius);
    }
    public RadialGeometry(double _radius)
    {
        super();
        set_radius(_radius);
    }

    public RadialGeometry(RadialGeometry radial)
    {
        this._radius=radial._radius;
    }

    public void set_radius(double _radius) {
        if(_radius<=0)
            throw new IllegalArgumentException("radius"+ _radius+ "is not a valid value");
        this._radius = _radius;
    }

    public double get_radius() {
        return _radius;
    }

    @Override
    public String toString() {
        return "RadialGeometry{" +
                "_radius=" + _radius +
                '}';
    }
}
