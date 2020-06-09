package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light implements LightSource {
    Point3D _position;
    double _kC,_kL,_kQ;
    /**
     * constructor
     *
     * @param _intensity
     */
    public PointLight(Color _intensity,Point3D position,double kc,double kl,double kq) {
        super(_intensity);
        this._position=new Point3D(position);
        this._kC=kc;
        this._kL=kl;
        this._kQ=kq;
    }
    //overriding light getIntensity
    @Override
    public Color get_intensity()
    {
        return super.get_intensity();
    }
    @Override
    public Color getIntensity(Point3D p)
    {
      Color IL=_intensity.reduce(_kC+_kL*p.distance(_position)+_kQ*p.distanceSquared(_position));
      return IL;
    }

    @Override
    public Vector getL(Point3D p)
    {
        Vector v= new Vector(p,_position);
        v.normalized();
        return v;
    }
}
