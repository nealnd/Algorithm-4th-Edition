package Exercise2_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Exercise2_2_14 {
    private Exercise2_2_14() {
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

    public static void main(String[] args) {

        Queue<Comparable> queue1 = new Queue<>();
        queue1.enqueue(1);
        queue1.enqueue(3);
        queue1.enqueue(5);
        queue1.enqueue(7);
        queue1.enqueue(9);

        Queue<Comparable> queue2 = new Queue<>();
        queue2.enqueue(2);
        queue2.enqueue(4);
        queue2.enqueue(5);
        queue2.enqueue(8);

        Queue<Comparable> mergedQueue = merge(queue1, queue2);

        StdOut.print("Merged queues: ");
        for (Comparable item : mergedQueue) {
            StdOut.print(item + " ");
        }
    }
}