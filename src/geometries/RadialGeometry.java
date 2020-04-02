package geometries;

public abstract class RadialGeometry implements Geometry {
    double _radius;

    public RadialGeometry(double _radius) {
        this._radius = _radius;
    }
    public RadialGeometry(RadialGeometry radial)
    {
        this._radius=radial._radius;
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
