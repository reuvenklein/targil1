package primitives;

public class Material {
   private final double _kD;
    private final double _kS;
    private final int _nShininess;

    public Material(double kD, double kS, int nShininess) {
        _kD = kD;
        _kS = kS;
        _nShininess = nShininess;
    }

    public double get_kD() {
        return _kD;
    }

    public double get_kS() {
        return _kS;
    }

    public int get_nShininess() {
        return _nShininess;
    }
}
