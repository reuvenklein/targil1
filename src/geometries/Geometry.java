package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;

public abstract class Geometry implements Intersectable {
    protected Material _material;
   protected Color _emission;
    public Geometry(Color _emission,Material _material) {
        this._emission = _emission;
        this._material=_material;
    }

    public Material get_material() {
        return _material;
    }

    public Geometry(Color _emission) {
        this(_emission,new Material(0d,0d,0));
    }

    public Geometry()
    {
        this(Color.BLACK,new Material(0d,0d,0));
    }
    public Color get_emission() {
        return _emission;
    }



    public abstract Vector getNormal(Point3D p);
}
