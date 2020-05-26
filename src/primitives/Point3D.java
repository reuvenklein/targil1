package primitives;

import java.util.Objects;
import static java.lang.Math.sqrt;
public class Point3D {
    Coordinate x;
    Coordinate y;
    Coordinate z;
    public final static Point3D ZERO = new Point3D(0.0, 0.0, 0.0);
    public Point3D(Point3D p1)
    {
        this.x=p1.x;
        this.y=p1.y;
        this.z=p1.z;
    }

    public Point3D(Coordinate x, Coordinate y, Coordinate z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D(double x, double y, double z) {
        this(new Coordinate(x), new Coordinate(y), new Coordinate(z));
    }

    public Coordinate getX() {
        return new Coordinate(x);
    }

    public Coordinate getY() {
        return new Coordinate(y);
    }

    public Coordinate getZ() {
        return new Coordinate(z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return x.equals(point3D.x) &&
                y.equals(point3D.y) &&
                z.equals(point3D.z);
    }

    @Override
    public String toString() {
        return "{" +
                x +
                ", " + y +
                "," + z +
                '}';
    }



    public Vector subtract(Point3D p1) {
        return new Vector(new Point3D(this.x.get() - p1.x.get(),
                this.y.get() - p1.y.get(),
                this.z.get() - p1.z.get())

        );
    }

    public Point3D add(Vector p1) {
        return new Point3D(this.x.get() + p1.head.x.get(),
                this.y.get() + p1.head.y.get(),
                this.z.get() + p1.head.z.get()
        );
    }

    public double distanceSquared(Point3D p1)
    {
        return (p1.x.get()-this.x.get())*(p1.x.get()-this.x.get())+(p1.y.get()-this.y.get())*(p1.y.get()-this.y.get())+(p1.z.get()-this.z.get())*(p1.z.get()-this.z.get());
    }


    public Point3D subtract(Vector v) {
        return new Point3D(this.x.get() - v.head.x.get(),
                this.y.get() -v.head.y.get(),
                this.z.get() - v.head.z.get());
    }

    public double distance(Point3D point) {
        return sqrt(this.distanceSquared(point));
    }
}

