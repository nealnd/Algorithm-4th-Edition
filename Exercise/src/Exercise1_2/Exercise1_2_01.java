package Exercise1_2;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_2_01 {

    public static Point2D[] generatePoint2ds(int N)
    {
        Point2D[] x = new Point2D[N];
        for (int i = 0; i < N; i++) {
            x[i] = new Point2D(StdRandom.uniformDouble(), StdRandom.uniformDouble());
        }

        return x;
    }

    public static double mindistance(Point2D[] x)
    {
        double distance = x[0].distanceTo(x[1]);
        double temp = 0;
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = i + 1; j < x.length; j++) {
                temp = x[i].distanceTo(x[j]);
                if (temp < distance)
                    distance = temp;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
    
        int N = 100;
        System.out.println(mindistance(generatePoint2ds(N)));
    }
}