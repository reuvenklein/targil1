package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Tube extends  RadialGeometry {
    Ray _axisRay;

    public Tube(double _radius, Ray _axisRay) {
        super(_radius);
        this._axisRay = _axisRay;
    }

    public Tube(RadialGeometry radial, Ray _axisRay) {
        super(radial);
        this._axisRay = _axisRay;
    }

    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }
}
