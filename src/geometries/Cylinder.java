package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube {
   double _height;

    public Cylinder(double _radius, Ray _axisRay, double _height) {
        super(_radius, _axisRay);
        this._height = _height;
    }

    public Cylinder(RadialGeometry radial, Ray _axisRay, double _height) {
        super(radial, _axisRay);
        this._height = _height;
    }

    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }
}
