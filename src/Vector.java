import java.util.Objects;
import static java.lang.Math.sqrt;

/**
 * Entity for vector
 * @author GaryZhang
 */
public class Vector {
    public double x;
    public double y;
    public double z;
    public double magnitude;

    public Vector(String[] coordinates) {
        this.x = Double.parseDouble(coordinates[0]);
        this.y = Double.parseDouble(coordinates[1]);
        this.z = Double.parseDouble(coordinates[2]);
        this.magnitude = sqrt(s(x) + s(y) + s(z));
    }

    public static double s(double a) {
        return a * a;
    }

    public Vector(double[] coordinates) {
        this.x = coordinates[0];
        this.y = coordinates[1];
        this.z = coordinates[2];
    }

    @Override
    public String toString() {
        return "<" + x + "," + y + "," + z + "> , Magnitude " + magnitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(x, vector.x) && Objects.equals(y, vector.y) && Objects.equals(z, vector.z) && Objects.equals(magnitude, vector.magnitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, magnitude);
    }

    public Vector magnified(double factor) {
        this.x = this.x * factor;
        this.y = this.y * factor;
        this.z = this.z * factor;
        return this;
    }

    public Vector unitVec() {
        double base = sqrt(s(x) + s(y) + s(z));
        Vector unit = new Vector(new double[]{x, y, z});
        unit.magnified(1/base);
        return unit;
    }
}
