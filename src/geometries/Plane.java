package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Plane implements Geometry  {
    Point3D p;
    Vector normal;

    public Plane(Point3D vertex, Point3D vertex1, Point3D vertex2) {
        p=vertex;
        normal=null;
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
        return null;
    }
    public Vector getNormal() {
        return getNormal(null);
    }
}
