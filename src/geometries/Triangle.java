package geometries;

import primitives.*;

import java.util.LinkedList;
import java.util.List;

import static primitives.Util.isZero;

public class Triangle extends  Polygon {

          public Triangle(Point3D p1,Point3D p2,Point3D p3)
          {
              super(p1,p2,p3);
          }

    public Triangle(Color emissionLight, Point3D p1, Point3D p2, Point3D p3) {
        super(emissionLight,p1,p2,p3);
    }
    public Triangle(Color emissionLight, Material material, Point3D p1, Point3D p2, Point3D p3) {
        super(emissionLight,material,p1,p2,p3);
    }


    public List<GeoPoint> findIntersections(Ray ray)
    {
        List<GeoPoint>intersect=_plane.findIntersections(ray);
        if(intersect==null)
            return null;
        Vector v1=_vertices.get(0).subtract(ray.get_p0());
        Vector v2=_vertices.get(1).subtract(ray.get_p0());
        Vector v3=_vertices.get(2).subtract(ray.get_p0());
        Vector N1=(v1.crossProduct(v2)).normalize();
        Vector N2=(v2.crossProduct(v3)).normalize();
        Vector N3=(v3.crossProduct(v1)).normalize();
       double d1=ray.get_dir().dotProduct(N1);
       double d2=ray.get_dir().dotProduct(N2);
       double d3=ray.get_dir().dotProduct(N3);
       if(isZero(d1)||isZero(d2)||isZero(d3))
           return null;
       if(d1>0&&d2>0&&d3>0||d1<0&&d2<0&&d3<0) {
           List<GeoPoint> result = new LinkedList<>();
           for (GeoPoint geo:intersect)
           {
               result.add(new GeoPoint(this,geo.getPoint()));
           }
           return result;
       }

      return null;
    }
}

