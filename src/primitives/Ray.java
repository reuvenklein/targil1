package primitives;

public class Ray {
    Point3D _p0;
    Vector _dir;

    public Ray(Point3D _p0, Vector _dir) {
        this._p0 = _p0;
        this._dir = _dir;

    }

    public Point3D get_p0() {
        return _p0;
    }

    public Vector get_dir() {
        return _dir;
    }
}
