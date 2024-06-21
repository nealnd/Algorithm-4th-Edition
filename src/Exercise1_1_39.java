import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class Exercise1_1_39 {

    @Deprecated
    public static int[] arrays(int N) {

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = 100000 + StdRandom.uniform(900000);
        }
        return a;
    }
    @Deprecated
    public static void main(String[] args) {

        int T = 10000;
        int N = 100000;
        int[] a1 = new int[N];
        int[] a2 = new int[N];


      //  int[] a1 = arrays(N);
      
       // int[] a2 = arrays(N);
        int count = 0;
        for (int j = 0; j < T; j++)
        {
 
                a1 = arrays(N);
                a2 = arrays(N);
                Arrays.sort(a1);
    
    
            for (int i = 0; i < a2.length; i++) {
            
                if (BinarySearch.rank(a2[i], a1) > 0)
                    count++;
            }

        }
       
        StdOut.println("N=" + N + ": " + (double) count / T);
        
    }
}
