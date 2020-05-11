package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube {
    Ray _axis;

    public Cylinder(double _radius, Ray _axisRay) {
        super(_radius, _axisRay);
    }

    public Cylinder(RadialGeometry radial, Ray _axisRay) {
        super(radial, _axisRay);
    }

    public Vector getNormal(Point3D p) {
        return null;
    }
}
