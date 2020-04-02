package primitives;

import java.util.Objects;

public class Point3D {
    Coordinate x;
    Coordinate y;
    Coordinate z;
    public final static Point3D ZERO = new Point3D(0.0, 0.0, 0.0);

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

    public double distanceSquared(Point3D p1, Point3D p2)
    {
        return (p1.x.get()-p2.x.get())*(p1.x.get()-p2.x.get())+(p1.y.get()-p2.y.get())*(p1.y.get()-p2.y.get())+(p1.z.get()-p2.z.get())*(p1.z.get()-p2.z.get());
    }




}

