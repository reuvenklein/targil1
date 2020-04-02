package primitives;

import javafx.geometry.Point2D;

import java.util.Objects;


import static java.lang.Math.sqrt;

public class Vector {
    Point3D head;

    public Vector(Point3D head) {
        this.head = head;
        if(this.head.equals(Point3D.ZERO))
            throw new IllegalArgumentException ("vector is equals to 0");
    }
    public Vector(Vector vector){this.head=vector.head;}
    //constructor checks if vector equals zero and if it does throws error.
    public Vector(Coordinate  x, Coordinate y,Coordinate z)
    {
//k
        head = new Point3D(x, y, z);
        if(this.head.equals(Point3D.ZERO))
            throw new IllegalArgumentException ("vector is equals to 0");

    }
    public Vector(double x, double y, double z) {
        this(new Coordinate(x), new Coordinate(y), new Coordinate(z));
    }



    public Point3D getHead() {
        return new Point3D(head.x,head.y,head.z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return head.equals( vector.head);
    }
    //gets a vector in function and adds that vector to the vector that we have
    public Vector add(Vector vector)
    {
        return new Vector(this.head.x.get()+ vector.head.x.get(),
                this.head.x.get() + vector.head.y.get(),
                this.head.z.get() + vector.head.z.get());
    }
    //subtracts one vector from the other one
    public Vector subtract(Vector vector)
    {
        return new Vector(vector.head.x.get()- this.head.x.get(),
                vector.head.x.get() - this.head.y.get(),
                vector.head.z.get() - this.head.z.get());
    }
    //function gets a number and adds it to the vector and returns a new vector
    public Vector scale(int number)
    {
        return new Vector(this.head.x.get()*number,
                this.head.y.get()*number,
                this.head.z.get()*number
                );
    }


    public double dotProduct(Vector edge2) {
        return (this.head.x.get()*edge2.head.x.get()+this.head.y.get()*edge2.head.y.get()
        +this.head.z.get()*edge2.head.z.get());
    }



    public Vector crossProduct(Vector edge2) {
        return new Vector(this.head.y.get()*edge2.head.z.get()-this.head.z.get()*edge2.head.y.get(),
                this.head.z.get()*edge2.head.x.get()-this.head.x.get()*edge2.head.z.get(),
                this.head.x.get()*edge2.head.y.get()-this.head.y.get()*edge2.head.x.get()

                );
    }
    public double lengthSquared()
    {
        return this.head.x.get()* this.head.x.get()+head.y.get()* this.head.y.get()+head.z.get()* this.head.z.get();
    }

    public double length() {
       return sqrt(lengthSquared());
    }
    public Vector normalize()
    {
        this.head= new Point3D(this.head.x.get()/length(),this.head.y.get()/length(),
                this.head.z.get()/length());
        return this;
    }
    public Vector normalized()
    {
       return new Vector(normalize());
    }
}
