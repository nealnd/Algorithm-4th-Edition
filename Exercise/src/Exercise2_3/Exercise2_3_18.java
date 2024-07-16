package Exercise2_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise2_3_18 {
    private Exercise2_3_18() {

    }

    private static boolean less(Comparable v, Comparable w) {
        if (v == w)
            return false;
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int median3(Comparable[] a, int i, int j, int k) {
        if (less(a[i], a[j])) {
            if (less(a[j], a[k]))
                return j;
            else {
                if (less(a[i], a[k]))
                    return k;
                else
                    return i;
            }
        } else {
            if (less(a[j], a[k])) {
                if (less(a[i], a[k]))
                    return i;
                else
                    return k;
            }

            else
                return j;
        }

    }

    private static int partition(Comparable[] a, int lo, int hi) {

        int i = lo, j = hi + 1;

        int m = median3(a, lo, lo + (hi - lo + 1) / 2, hi);
        exch(a, m, lo);
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi)
                    break;
            }
            while (less(v, a[--j])) {
                if (j == lo)
                    break;
            }
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, j, lo);
        return j;
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
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
