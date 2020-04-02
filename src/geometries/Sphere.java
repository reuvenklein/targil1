package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere extends   RadialGeometry {
    Point3D _center;

    public Sphere(double _radius, Point3D _center) {
        super(_radius);
        this._center = _center;
    }

    public Sphere(RadialGeometry radial, Point3D _center) {
        super(radial);
        this._center = _center;
    }

    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }
}
