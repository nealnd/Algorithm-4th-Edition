package Exercise5_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MSD {
    private static final int BITS_PER_BYTE = 8;
    private static final int BITS_PER_INT = 32;
    private static final int R = 256;
    private static final int CUTOFF = 0;//just for test, normally is about 10;

    private MSD() {
    }

    public static void sort(String[] a) {
        int n = a.length;
        String[] aux = new String[n];
        sort(a, 0, n - 1, 0, aux);
    }

    private static int charAt(String s, int d) {
        if (d == s.length())
            return -1;
        return s.charAt(d);
    }

    private static void sort(String[] a, int lo, int hi, int d, String[] aux) {
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }

        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            count[c + 2]++;
        }

        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];

        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            aux[count[c + 1]++] = a[i];
        }

        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];

        for (int r = 0; r < R; r++)
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1, aux);

    }

    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
                exch(a, j, j - 1);
    }

    private static boolean less(String v, String w, int d) {
        // assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i))
                return true;
            if (v.charAt(i) > w.charAt(i))
                return false;
        }
        return v.length() < w.length();
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        String[] a = { "i", "am", "a","cute","boy" };
        int n = a.length;
        sort(a);
        for (int i = 0; i < n; i++)
            StdOut.println(a[i]);
    }

}
