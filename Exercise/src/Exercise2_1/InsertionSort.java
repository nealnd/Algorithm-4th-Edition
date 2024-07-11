package Exercise2_1;

import java.util.Comparator;
import edu.princeton.cs.algs4.*;

public class InsertionSort {
    private InsertionSort() {
    }
    
    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[]a, int i,int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[]a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();

    }

    public static boolean isSorted(Comparable[]a)
    {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;

        }

        return true;
    }

    public static void sort(Comparable[]a)
    {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);

            }
           // show(a);
        }
        

    }
    
    public static void main(String[]args)
    {
        Character[] a = { 'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T','I','O','N'};
    
        InsertionSort.sort(a);
        show(a);
    }
}
