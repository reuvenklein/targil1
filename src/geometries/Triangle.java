package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.isZero;

public class Triangle extends  Polygon {
    Point3D p1,p2,p3;
          public Triangle(Point3D p1,Point3D p2,Point3D p3) {
              super(p1,p2,p3);
          }

    public Vector getNormal(Point3D point) {
        return _plane.getNormal();
    }
    public List<Point3D> findIntersections(Ray ray)
    {
        List<Point3D>intersect=_plane.findIntersections(ray);
        if(intersect==null)
            return null;
        Vector v1=p1.subtract(ray.get_p0());
        Vector v2=p2.subtract(ray.get_p0());
        Vector v3=p3.subtract(ray.get_p0());
        Vector N1=(v1.crossProduct(v2)).normalize();
        Vector N2=(v2.crossProduct(v3)).normalize();
        Vector N3=(v3.crossProduct(v1)).normalize();
       double d1=ray.get_dir().dotProduct(N1);
       double d2=ray.get_dir().dotProduct(N2);
       double d3=ray.get_dir().dotProduct(N3);
       if(isZero(d1)||isZero(d2)||isZero(d3))
           return null;
       if(d1>0&&d2>0&&d3>0||d1<0&&d2<0&&d3<0)
           return intersect;
       else return null;


    }
}

