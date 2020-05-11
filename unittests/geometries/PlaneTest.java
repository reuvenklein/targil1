package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

     Plane plane=new Plane((new Point3D(1,0,0)),new Point3D(0,1,0),new Point3D(0,0,1));
    @Test
    void getNormal() {
        Plane p=new Plane(new Point3D(0,1,0),new Point3D(1,0,0),new Point3D(0,0,1));
        Vector v=p.getNormal();

        Plane p1=new Plane(new Point3D(1,0,0),new Point3D(0,0,1),new Point3D(0,1,0));
        Vector v1=p.getNormal();

        assertEquals(v,v1);
    }


    @Test
    void findIntersection () {
        // ============ Equivalence Partitions Tests ==============
        //Ray is neither orthogonal nor parallel to the plane

        //Ray intersects the plane
        assertEquals(Arrays.asList(new Point3D(0.16666666666666663, 0.16666666666666663,0.6666666666666666)),
                plane.findIntersections(new Ray(new Point3D(-0.5,-0.5,0),new Vector(1,1,1))),
                "Ray intersects plane");

        //Ray does not intersect the plane
        assertNull(plane.findIntersections(new Ray(new Point3D(4,0,0),new Vector(1,1,1))),
                "Ray does not intersect plane");

        // =============== Boundary Values Tests ==================

        //Ray is parallel to the plane







    }
}