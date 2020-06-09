package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {
    private List<Intersectable> _geometries=new LinkedList<>();


    public Geometries(Intersectable... _geometries) {

        add(_geometries);
    }

    public void add(Intersectable... geometries) {

            _geometries.addAll(Arrays.asList(geometries));

        }


    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        List<GeoPoint> intersections = null;
        for (Intersectable geometry : _geometries)
         {
          List<GeoPoint> allIntersections = geometry.findIntersections(ray);
             if (allIntersections != null) {
                 if(intersections==null) {
                     intersections = new LinkedList<>();
                 }
                 intersections.addAll(allIntersections);
             }



        }
        return  intersections;
    }



        }


