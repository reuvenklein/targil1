package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class SpotLight extends PointLight {
    private Vector _direction;

    /**
     * constructor
     *
     * @param _intensity
     * @param position
     * @param kc
     * @param kl
     * @param kq
     */
    public SpotLight(Color _intensity, Point3D position,Vector direction, double kc, double kl, double kq) {
        super(_intensity, position, kc, kl, kq);
        this._direction=new Vector(direction.normalized());
    }
    @Override
    public Color getIntensity(Point3D p)
    {
        Color IL=_intensity.scale(Math.max(0, _direction.dotProduct(getL(p)))).reduce(_kC+_kL*p.distance(_position)+_kQ*p.distanceSquared(_position));
        return IL;
    }
}


