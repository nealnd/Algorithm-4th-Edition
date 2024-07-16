package Exercise2_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise2_3_17 {
    private Exercise2_3_17() {
    }

    private static boolean less(Comparable v, Comparable w) {
        if (v == w)
            return false;
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], v)) {
            }
            while (less(v, a[--j])) {
            }
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            if (less(a[temp], a[i]))
                temp = i;
            exch(a, temp, a.length-1);
        }
        //show(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1,hi);
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        Integer[] a = { 4, 1, 2, 6, 3, 5, 7, 8, 7, 9, 15, 13 };
        show(a);
        sort(a);
        show(a);
    }
}
