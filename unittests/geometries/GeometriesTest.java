package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeometriesTest {

    Plane plane=new Plane((new Point3D(1,0,0)),new Point3D(0,1,0),new Point3D(0,0,1));
    Sphere sphere = new Sphere(1d, new Point3D(1, 0, 0));
    @Test
    void findIntersections() {
        // =============== Boundary Values Tests ==================
      


    }
}