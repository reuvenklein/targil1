package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.List;

public class Geometries implements Intersectable {
    private List<Intersectable> _geometries;
    public  Geometries()
    {
        _geometries=new ArrayList<>();
    }

    public Geometries(Intersectable... _geometries) {
        add(_geometries);
    }

    public void add(Intersectable... geometries) {
        for (Intersectable geometry : geometries
        ) {
            _geometries.add(geometry);

        }
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersection = null;
        for (Intersectable geometry : _geometries
        ) {
             intersection = geometry.findIntersections(ray);
             if (intersection == null)
                    intersection = new ArrayList<>();
                intersection.addAll(findIntersections(ray));



        }
        return  intersection;
    }

}
