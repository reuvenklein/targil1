package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import static java.lang.Math.sqrt;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
    public Vector getNormal(Point3D p)
    {
        Vector v=p.subtract(_center);
        Vector n=v.normalize();
        return n;
    }

    @Override
    public List<Point3D> findIntersections(Ray ray)
    {
        Point3D p1=null;
        Point3D p2=null;
          Vector u=_center.subtract(ray.get_p0());
         double tm=ray.get_dir().dotProduct(u);
         double d=sqrt(u.length()*u.length()-tm*tm);
         if(d>_radius)
             return null;
         double tn=sqrt(_radius*_radius-d*d);
         double t1=tm+tn;
         double t2=tm-tn;
        List<Point3D> intersects=new ArrayList<>();
         if(t1>0) {
             p1 = ray.get_p0().add(ray.get_dir().scale(t1));
             if(p1.subtract(_center).lengthSquared()-_radius*_radius==0)
                 intersects.add(p1);
             else p1=null;
         }
        if (t2 > 0) {
            p2 = ray.get_p0().add(ray.get_dir().scale(t2));
            if (p2.subtract(_center).lengthSquared() - _radius * _radius == 0)
                intersects.add(p2);
            else
                p2=null;
        }

            if(p1!=null||p2!=null)
               return intersects;
            return null;









    }
}
