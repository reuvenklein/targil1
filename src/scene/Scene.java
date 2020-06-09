package scene;

import elements.*;
import geometries.Geometries;
import geometries.Intersectable;
import primitives.Color;
import java.util.LinkedList;
import java.util.List;

public class Scene {
    private String name;
    private Color background;
    private AmbientLight ambientLight;
    private Camera camera;
    private double distance;
    private Geometries _geometries = new Geometries();
    private List<LightSource> _Lights=null;
    public Scene(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public AmbientLight getAmbientLight() {
        return ambientLight;
    }

    public void setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
    }

    public Geometries getGeometries() {
        return _geometries;
    }

    public void setGeometries(Geometries geometries) {
        this._geometries = geometries;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<LightSource> get_Lights() {
        return _Lights;
    }
    public void addLights(LightSource lights) {
        if (_Lights == null) {
            _Lights = new LinkedList<>();
        }
        _Lights.add(lights);
    }

    public void addGeometries(Intersectable... geometries) {

        for (Intersectable geometry:geometries)
              {
                  _geometries.add(geometry);
            
        }
            _geometries.add(geometries);
    }
}
