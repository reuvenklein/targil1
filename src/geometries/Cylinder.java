package geometries;

import primitives.*;

public class Cylinder extends Tube {
    Ray _axis;

    public Cylinder( double _radius, Ray _axisRay) {
        super(_radius, _axisRay);
    }

    public Cylinder(RadialGeometry radial, Ray _axisRay) {
        super(radial, _axisRay);
    }

    public Vector getNormal(Point3D p) {
        return null;
    }
}
