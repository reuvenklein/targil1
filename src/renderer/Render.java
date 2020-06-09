package renderer;

import elements.AmbientLight;
import elements.*;
import geometries.Intersectable;
import primitives.Color;
import primitives.Point3D;
import primitives.*;
import scene.Scene;
import static geometries.Intersectable.GeoPoint;

import java.awt.*;
import java.util.List;


public class Render {
    private ImageWriter _imagewriter;
    private Scene _scene;
    public Render(ImageWriter imageWriter, Scene scene) {
        this._imagewriter=imageWriter;
        this._scene=scene;
    }

    public void printGrid(int interval, java.awt.Color color) {

        int nx=_imagewriter.getNx();
        int ny=_imagewriter.getNy();
        for (int i = 0; i < ny; i++) {
            for (int j = 0; j < nx; j++) {

                if (i % interval == 0 || j % interval == 0)
                    _imagewriter.writePixel(j,i,color);

            }
        }
    }

    public void writeToImage() {
        _imagewriter.writeToImage();;
    }

    public void renderImage() {
        Camera camera=_scene.getCamera();
        Intersectable geometries=_scene.getGeometries();
        java.awt.Color background=_scene.getBackground().getColor();
        AmbientLight ambientlight=_scene.getAmbientLight();
        int width=(int)_imagewriter.getWidth();
        int height=(int)_imagewriter.getHeight();
        double distance=_scene.getDistance();
         Ray ray;
        int nx=_imagewriter.getNx();
        int ny=_imagewriter.getNy();
        for (int i=0; i<ny ; i++) {
            for (int j = 0; j <nx ; j++) {
                 ray=camera.constructRayThroughPixel(nx,ny,i,j,distance,width,height);
                List<GeoPoint> intersections=_scene.getGeometries().findIntersections(ray);
                if(intersections==null)
                {
                    _imagewriter.writePixel(j,i,background);

                }
                else
                {
                    GeoPoint closetPoint=getClosetPoint(intersections);

                _imagewriter.writePixel(j,i,calcColor(closetPoint).getColor());
            }
            
        }


    }



}

    private Color calcColor(GeoPoint intersection) {
        Color color = _scene.getAmbientLight().get_intensity();
        color = color.add(intersection.geometry.get_emission());
        Vector v = intersection.point.subtract(_scene.getCamera().get_p0()).normalize();
        Vector n = intersection.geometry.getNormal(intersection.point);
        Material material = intersection.geometry.get_material();
        int nShininess = material.get_nShininess();
        double kd = material.get_kD();
        double ks = material.get_kS();
        for (LightSource lightSource : _scene.get_Lights()) {
            Vector l=lightSource.getL(intersection.point);
            if(sign(n.dotProduct(l))==sign(n.dotProduct(v)))
            {
                Color lightIntensity=lightSource.getIntensity((intersection.point));
                color=color.add(calcDiffusive(kd,l,n,lightIntensity),
                                 calcSpecular(ks,l,n,v,nShininess,lightIntensity));
            }
        }
        return color;

    }
    private GeoPoint getClosetPoint(List<GeoPoint> intersectionpoints) {
        Point3D p0 = _scene.getCamera().get_p0();
        GeoPoint p1 = null;
        double minDist = Double.MAX_VALUE;
        double currentdistance = 0;
        for (GeoPoint geoPoint : intersectionpoints
        ) {
            currentdistance = p0.distance(geoPoint.getPoint());
            if (currentdistance < minDist) {
                minDist = currentdistance;
                p1 = geoPoint;
            }
        }
        return p1;

    }
    private Color calcSpecular(double ks,Vector l,Vector n,Vector v,int nShininess,Color IL)
    {
        double ln=l.dotProduct(n);
        Vector r=l.add(n.scale(-2*ln));
        double vr=v.dotProduct(r);
        Color specular=IL.scale(ks*Math.pow(-vr,nShininess));
        return specular;
    }
    private Color calcDiffusive(double kD,Vector l,Vector n,Color IL)
    {
        double ln=l.dotProduct(n);
        Color diffusive=IL.scale(kD*Math.abs(ln));
        return diffusive;
    }
    private boolean sign(double vn)
    {
        boolean positive;
        if(vn>0)
            positive=true;
        else
            positive=false;
        return positive;

    }
}
