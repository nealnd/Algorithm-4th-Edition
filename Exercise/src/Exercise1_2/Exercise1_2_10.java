package Exercise1_2;
import edu.princeton.cs.algs4.StdDraw;

public class Exercise1_2_10 {
    public static class VisualCounter {
        private int count;
        private int operator;
        private int N;
        private int max;

        public VisualCounter(int N, int max) {
            this.N = N;
            this.max = Math.abs(max);
            StdDraw.setXscale(0, N + 1);
            StdDraw.setYscale(-max * 2, max * 2);
            StdDraw.line(0, 0, N + 1, 0);
            StdDraw.line(0.2, -max * 2, 0.2, max * 2);
            StdDraw.setPenRadius(0.01);
        }

        public void increment() {
            operator++;
            count++;
            StdDraw.point(operator, count);
            if (operator > N || Math.abs(count) > max)
                throw new RuntimeException();
        }

        public void decline() {
            operator++;
            count--;
            StdDraw.point(operator, count);
            if (operator > N || Math.abs(count) > max)
                throw new RuntimeException();
        }

        public int tally() {
            return count;
        }

        public String toString() {
            return "operator:" + operator + " count:" + count;
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int max = 3;
        VisualCounter visualCounter = new VisualCounter(N, max);
        visualCounter.increment();
        visualCounter.increment();
        visualCounter.increment();
        visualCounter.decline();
        visualCounter.decline();
        System.out.println(visualCounter);
    }
}
