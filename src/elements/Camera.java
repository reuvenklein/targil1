package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

public class Camera {
   private Point3D _p0;
   private Vector _vUp;
   private Vector _vTo;
   private Vector _vRight;

    public Camera(Point3D _p0, Vector _vto, Vector vup) {
        this._p0 = new Point3D(_p0);
        this._vTo = new Vector(_vto);
        this._vUp = new Vector(vup);
        if (_vto.dotProduct(_vUp) != 0)
            throw new IllegalArgumentException("the vectors need to be orthogonal");
        _vRight = this._vTo.crossProduct(this._vUp).normalize();

    }

    public Point3D get_p0() {
        return _p0;
    }

    public Vector get_vUp() {
        return _vUp;
    }

    public Vector get_vTo() {
        return _vTo;
    }

    public Vector get_vRight() {
        return _vRight;
    }

    public Ray constructRayThroughPixel(int nX, int nY, int j, int i,
                                        double screenDistance, double screenWidth, double screenHeight) {
        Point3D pc = _p0.add(_vTo.scale(screenDistance));
        double Ry = screenHeight / nY;
        double Rx = screenWidth / nX;
        double yi = (i - nY / 2d) * Ry + Ry / 2d;
        double xj = (j - nX / 2d) * Rx + Rx / 2d;
        Point3D pij = pc;
        if (!isZero(xj)) {
            pij = pij.add(_vRight.scale(xj));
        }
        if (!isZero(yi)) {
            pij = pij.add(_vUp.scale(-yi));
        }
        Vector vij = pij.subtract(_p0).normalize();
        return new Ray(_p0, vij);

    }

}
