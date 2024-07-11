package Exercise2_2;

import java.util.Comparator;

public class Exercise2_2_10 {

    public void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int i = 0; i <= mid; i++)
            aux[i] = a[i];
        for (int i = mid + 1; i <= hi; i++)
            aux[i] = a[hi + mid + 1 - i];
        int i = lo, j = hi;
        for (int k = 0; k <= hi; k++) {
            if (less(aux[j], aux[i]))
                a[k] = aux[j--];
            else
                a[k] = aux[i++];
        }

    }

    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i] + " ");
        // System.out.println();
    }

    public static void main(String[] args) {
        Integer[] a = { 1, 4, 5, 2, 3, 6 };
        Integer[] aux = new Integer[a.length];
        Exercise2_2_10 test = new Exercise2_2_10();
        test.merge(a, aux, 0, 2, 5);
        test.show(a);
    }
}
