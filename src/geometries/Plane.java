package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static primitives.Util.alignZero;

public class Plane implements Geometry  {
    Point3D p;
    Vector normal;

    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        p= new Point3D(p1);
        Vector u=new Vector(p1,p2);
        Vector v=new Vector(p1,p3);
        Vector n=u.crossProduct(v);
       normal= n.normalize();

    }

    public Plane(Point3D p, Vector normal) {
        this.p = p;
        this.normal = normal;

    }
    //  public Plane(Point3D vertex_x, Point3D vertex_y, Point3D vertex_z) {
//        Vector v1=new Vector(vertex_x,vertex_y);
 //   }

    @Override
    public Vector getNormal(Point3D p) {
        return normal;
    }
    public Vector getNormal() {
        return getNormal(null);
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
       double t=alignZero(normal.dotProduct(p.subtract(ray.get_p0()))/normal.dotProduct(ray.get_dir()));
       Point3D p1=ray.get_p0().add(ray.get_dir().scale(t));
       List<Point3D> intersects=new ArrayList<>();
       if(t>0)
       {
           intersects.add(p1);
           return intersects;
       }
       return null;






    }
}
