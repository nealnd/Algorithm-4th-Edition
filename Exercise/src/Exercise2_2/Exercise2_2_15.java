package Exercise2_2;

import java.util.Comparator;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise2_2_15 {
    private Exercise2_2_15() {
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static Queue<Comparable> merge(Queue<Comparable> a, Queue<Comparable> b) {

        Queue<Comparable> Merge = new Queue<>();

        while (true) {
            if (a.isEmpty() && b.isEmpty())
                break;
            else if (a.isEmpty())
                Merge.enqueue(b.dequeue());
            else if (b.isEmpty())
                Merge.enqueue(a.dequeue());
            else if (less(a.peek(), b.peek()))
                Merge.enqueue(a.dequeue());
            else
                Merge.enqueue(b.dequeue());

        }

        return Merge;

    }

    private static void sort(Queue<Queue<Comparable>> a) {

        while (a.size() > 1) {
            a.enqueue(merge(a.dequeue(), a.dequeue()));

        }

    }

    // asume that it generates Queue<Integer>
    private static Queue<Queue<Comparable>> Generate(int N) {
        Queue<Queue<Comparable>> a = new Queue<>();
        for (int i = 0; i < N; i++) {
            Queue<Comparable> j = new Queue<>();
            j.enqueue(N - i);
            a.enqueue(j);
        }
        
        return a;
    }

    public static void main(String[] args) {

        Queue<Queue<Comparable>> a = Generate(20);
        sort(a);
        for (Comparable item : a.peek()) {
            StdOut.print(item + " ");

        }

    }
}
