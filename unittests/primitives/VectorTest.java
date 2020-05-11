package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void add() {
        Vector v1 = new Vector(0.0, 1.0, 0.0);
        Vector v2 = new Vector(1.0, 0.0, 0.0);
        Vector v3 = v1.add(v2);
        assertEquals(new Vector(1.0, 1.0, 0.0), v3);
    }
    @Test
    void subtract() {
        Vector v1=new Vector(1.0,1.0,1.0);
        Vector v2=new Vector(-1.0,-1.0,-1.0);
        v1=v1.subtract(v2);
        assertEquals(new Vector(2.0,2.0,2.0),v1);
        assertEquals(new Vector(-3.0,-3.0,-3.0),v2.subtract(v1));
    }


    @Test
    void scale() {
        Vector v1=new Vector(1.0,1.0,1.0);
        Vector v=v1.scale(2);
        assertEquals(new Vector(2.0,2.0,2.0),v1);
    }

    @Test
    void dotProduct() {
        Vector v1=new Vector(1.0,1.0,1.0);
        Vector v2=new Vector(1.0,1.0,2.0);
        double v3=v1.dotProduct(v2);
        assertEquals(4.0,v3);


    }

    @Test
    void crossProduct() {

    }

    @Test
    void lengthSquared() {
    }

    @Test
    void normalize() {
        Vector v1 = new Vector(1.0, 2.0, 3.0);
        v1.normalize();
        assertEquals(new Vector(1.0, 1.0, 1.0), v1.length());
    }
}
