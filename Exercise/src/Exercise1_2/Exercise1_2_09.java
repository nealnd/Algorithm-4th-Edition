package Exercise1_2;
import edu.princeton.cs.algs4.Counter;
import java.util.Arrays;

public class Exercise1_2_09 {
    public static int rank(int key, int []a, Counter counter)
    {

        int lo = 0;
        int hi = a.length - 1;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            counter.increment();
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }

        return -1;

    }
    
    public static void main(String[] args) {
        Counter counter = new Counter("counter");
        int[] a = { 10, 9, 5, 7, 3, 1, 6, 4, 11, 242, 324, 663 };
        Arrays.sort(a);
        int key = 4;
        rank(key, a, counter);
        System.out.println(counter);

    }
    
}
