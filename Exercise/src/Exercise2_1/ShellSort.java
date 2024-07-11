package Exercise2_1;
import edu.princeton.cs.algs4.*;
import java.util.Comparator;

public class ShellSort {
    private ShellSort() {
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
        int h = 1;
        while (h < n / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
                //show(a);
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Character[] a = { 'E', 'A', 'S', 'Y', 'S','H','E','L','L','S','O','R','T','Q', 'U', 'E', 'S', 'T','I','O','N'};

        ShellSort.sort(a);
        show(a);
    }
}
