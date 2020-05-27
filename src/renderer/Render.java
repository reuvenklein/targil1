package renderer;

import elements.AmbientLight;
import elements.*;
import geometries.Intersectable;
import primitives.Color;
import primitives.Point3D;
import primitives.*;
import scene.Scene;

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
                List<Point3D> intersections=_scene.getGeometries().findIntersections(ray);
                if(intersections==null)
                {
                    _imagewriter.writePixel(j,i,background);

                }
                else
                {
                    Point3D closetPoint=getClosetPoint(intersections);
                _imagewriter.writePixel(j-1,i-1,calcColor(closetPoint).getColor());
            }
            
        }


    }



}

    private Color calcColor(Point3D closetPoint) {

        return _scene.getAmbientLight().getIntensity();
    }

    private Point3D getClosetPoint(List<Point3D> intersectionpoints) {
        Point3D p0 = _scene.getCamera().get_p0();
        Point3D p1 = null;
        double minDist = Double.MAX_VALUE;
        double currentdistance = 0;
        for (Point3D point : intersectionpoints
        ) {
            currentdistance = p0.distance(point);
            if (currentdistance < minDist) {
                minDist = currentdistance;
                p1 = point;
            }
        }
        return p1;

    }
}
