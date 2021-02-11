/**
 * Class that defines vector operations
 * @author GaryZhang
 */
public class VectorOperationUtil {

    public static double dotProduct(Vector a, Vector b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    public static Vector crossProduct(Vector a, Vector b) {
        double i,j,k;
        i = a.y*b.z - a.z*b.y;
        j = a.z*b.x - a.x*b.z;
        k = a.x*b.y - a.y*b.x;
        return new Vector(new double[]{i,j,k});
    }

    public static double angleCosine(Vector a, Vector b) {
        return a.equals(b) ? 0.0 :dotProduct(a,b)/(a.magnitude*b.magnitude);
    }

    public static Vector[] projectionVec(Vector a, Vector b) {
        double fac1 = dotProduct(a,b)/Vector.s(b.magnitude);
        double fac2 = dotProduct(a,b)/Vector.s(a.magnitude);
        return new Vector[]{b.magnified(fac1),a.magnified(fac2)};
    }
}
