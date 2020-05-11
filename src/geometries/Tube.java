package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

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
    public Vector getNormal(Point3D p)
    {
        double t=_axisRay.get_dir().dotProduct(p.subtract(_axisRay.get_p0()));
        Point3D O=_axisRay.get_p0().add(_axisRay.get_dir().scale(t));
        Vector v=p.subtract(O);
        Vector n=v.normalize();
        return  n;

    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
