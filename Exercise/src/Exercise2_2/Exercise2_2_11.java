package Exercise2_2;

import java.util.Comparator;

import edu.princeton.cs.algs4.StdOut;

public class Exercise2_2_11 {
    private static final int CUTOFF = 0;

    private Exercise2_2_11() {
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++]; // to ensure stability
            else
                a[k] = aux[i++];
        }

        StdOut.printf("merge(a  ,%4d,%4d,%4d)", lo, mid, hi);
        show(a);
        StdOut.printf("merge(aux,%4d,%4d,%4d)", lo, mid, hi);
        show(aux);
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        // if (hi <= lo) return;
        if (hi <= lo + CUTOFF) {
            InsertionSort(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, a, lo, mid);//the swap is important 
        sort(aux, a, mid + 1, hi);

        if (!less(aux[mid + 1], aux[mid])) {
            System.arraycopy(aux, lo, a, lo, hi - lo + 1);
            return;
        }

        merge(a, aux, lo, mid, hi);
    }

    private static void InsertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && (less(a[j], a[j - 1])); j--)
                exch(a, j, j - 1);
        }

    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void show(Object[] a) {
        StdOut.print(a+" /");
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        Integer[] a = { 4, 1, 2, 6 }; //3, 5 ,7};//, 8, 7, 9, 15, 13 };
        show(a);
        sort(a);
        show(a);

    }

}
