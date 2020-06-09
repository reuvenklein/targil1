package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.List;
import java.util.Objects;

public interface Intersectable {
    public static  class GeoPoint
    {
        public Geometry geometry;
        public Point3D point;
/**
 * Constructor for GeoPoint
 */

        public GeoPoint(Geometry geometry, Point3D point) {
            this.geometry = geometry;
            this.point = point;
        }

        public Geometry getGeometry() {
            return geometry;
        }

        public Point3D getPoint() {
            return point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GeoPoint geoPoint = (GeoPoint) o;
            return Objects.equals(geometry, geoPoint.geometry) &&
                    Objects.equals(point, geoPoint.point);
        }


    }
    List<GeoPoint> findIntersections(Ray ray);
}
