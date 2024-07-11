package Exercise2_2;

import edu.princeton.cs.algs4.*;
import java.util.Comparator;


public class BottomUpMergeSort {
    
    private BottomUpMergeSort() {

    }
private static boolean less(Comparable v,Comparable w)
{
    return v.compareTo(w) < 0;
}

public static void show(Comparable[]a)
{
    for (int i = 0; i < a.length; i++) {
        StdOut.print(a[i] + " ");
    }
    StdOut.println();
}

private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
    for (int k = lo; k <= hi; k++) {
        aux[k] = a[k];
    }

    int i = lo, j = mid + 1;
    for(int k=lo;k<=hi;k++)
    {
        if (i > mid)
            a[k] = aux[j++];
        else if (j > hi)
            a[k] = aux[i++];
        else if (less(aux[j], aux[i]))
            a[k] = aux[j++];
        else
            a[k] = aux[i++];
    }
    StdOut.printf("merge(a,%4d,%4d,%4d)", lo, mid, hi);
    show(a);
}


public static void sort(Comparable[] a) {
    int n = a.length;
    Comparable[] aux = new Comparable[n];
    for (int len = 1; len < n; len *= 2) {
        for (int lo = 0; lo < n - len; lo += len + len) {
            int mid = lo + len - 1;
            int hi = Math.min(lo + len + len - 1, n - 1);
            merge(a, aux, lo, mid, hi);
            //show(a);
        }
    }

}
public static void main(String[] args) {
    Character[] a = { 'N', 'E', 'Q', 'S', 'U', 'Y', 'E', 'I', 'N', 'O', 'S', 'T' ,'Z'};
    sort(a);
    //show(a);

}

}
