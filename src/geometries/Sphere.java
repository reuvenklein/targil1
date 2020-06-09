package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.*;
import static java.lang.Math.sqrt;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Sphere extends RadialGeometry {
    Point3D _center;

    public Sphere (double _radius, Point3D _center) {
        super(_radius);
        this._center =new Point3D( _center);
    }

    public Sphere(RadialGeometry radial, Point3D _center) {
        super(radial);
        this._center = new Point3D(_center);
    }

    public Sphere(Color color, Material material, double i, Point3D _center) {
        super(color,material,i);
        this._center=new Point3D(_center);
    }

    @Override
    public Vector getNormal(Point3D p)
    {
        Vector v=p.subtract(_center);
        Vector n=v.normalize();
        return n;
    }

    @Override
    public List<GeoPoint> findIntersections(Ray ray)
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
        List<GeoPoint> intersects=new LinkedList<>();
         if(t1>0) {
             p1 = ray.get_p0().add(ray.get_dir().scale(t1));
             intersects.add(new GeoPoint(this, p1));
         }
             else p1=null;

        if (t2 > 0) {
            p2 = ray.get_p0().add(ray.get_dir().scale(t2));
            intersects.add(new GeoPoint(this, p2));
        }
            else
                p2=null;


            if(p1!=null||p2!=null)
               return intersects;
            return null;
    }
}
