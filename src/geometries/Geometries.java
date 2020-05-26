package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Geometries implements Intersectable {
    private List<Intersectable> _geometries=new ArrayList<>();


    public Geometries(Intersectable... _geometries) {

        add(_geometries);
    }

    public void add(Intersectable... geometries) {

            _geometries.addAll(Arrays.asList(geometries));

        }


    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersections = null;
        for (Intersectable geometry : _geometries)
         {
          List<Point3D> allIntersections = geometry.findIntersections(ray);
             if (allIntersections != null) {
                 if(intersections==null) {
                     intersections = new ArrayList<>();
                 }
                 intersections.addAll(allIntersections);
             }



        }
        return  intersections;
    }



        }


