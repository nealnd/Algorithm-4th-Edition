package Exercise2_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class Exercise2_2_16 {
    private Exercise2_2_16() {
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (j > hi)
                a[k] = aux[i++];
            else if (i > mid)
                a[k] = aux[j++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    private static ArrayList<Integer> FindKey(Comparable[] a) {

        ArrayList<Integer> mid = new ArrayList<>();
        int i = 0;
        mid.add(0);
        while (i < a.length - 1) {

            if (!less(a[i + 1], a[i]))
                ;
            else {
                if (i != 0)
                    mid.add(i);
            }

            i++;

        }
        if (mid.getLast() != a.length - 1)
            mid.add(a.length - 1);
        return mid;
    }

    private static void sort(Comparable[] a, ArrayList<Integer> m) {

        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int len = 1; len < m.size(); len = 2 * len) {
            for (int lo = 0; lo < m.size() - len; lo += len + len) {
                int mid = lo + len-1;
                int hi = Math.min(lo + len + len-1, m.size() - 1);
                merge(a, aux, m.get(lo), m.get(mid), m.get(hi));
            }

        }
    }

    private static void sort(Comparable[] a) {
        ArrayList<Integer> m = FindKey(a);
        sort(a, m);
    }

    private static void show(Object[] a) {
        //StdOut.print(a + " /");
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        Integer[] a = { 4, 1, 2, 6, 3, 5, 7, 8, 7, 9, 15, 13,8,7,6,18 };
        show(a);
        sort(a);
        show(a);

    }

}
