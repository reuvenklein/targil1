package geometries;

import primitives.*;

import java.util.LinkedList;
import java.util.List;

import static primitives.Util.alignZero;

public class Plane extends Geometry  {
    Point3D p;
    Vector normal;

    public Plane(Color emissionLight, Material material, Point3D p1, Point3D p2, Point3D p3) {
        super(emissionLight,material);

        setNormal(p1, p2, p3);

    }

    private void setNormal(Point3D p1, Point3D p2, Point3D p3) {
        p= new Point3D(p1);
        Vector u=new Vector(p1,p2);
        Vector v=new Vector(p1,p3);
        Vector n=u.crossProduct(v);
        normal= n.normalize();
    }

    public Plane(Color emissionLight,Material material,Point3D p, Vector normal) {
        super(emissionLight,material);
        this.p = p;
        this.normal = normal;

    }

    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        super();
        setNormal(p1,p2,p3);

    }


    @Override
    public Vector getNormal(Point3D p) {
        return normal;
    }
    public Vector getNormal() {
        return getNormal(null);
    }

    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
       double t=alignZero(normal.dotProduct(p.subtract(ray.get_p0()))/normal.dotProduct(ray.get_dir()));
       Point3D p1=ray.get_p0().add(ray.get_dir().scale(t));
       List<GeoPoint> intersects=new LinkedList<>();
       if(t>0)
       {
           intersects.add(new GeoPoint(this,p1));
           return intersects;
       }
       return null;






    }
}
