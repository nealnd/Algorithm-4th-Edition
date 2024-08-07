package Exercise1_1;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;
public class BinarySearch {
    public static int rank(int key, int[]a)
    {
        int lo=0;
        int hi=a.length-1;
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            if(key<a[mid]) hi=mid-1;
            else if(key>a[mid]) lo=mid+1;
            else return mid;
        }
        return -1;
    }
    @Deprecated
    public static void main(String[] args) {
        int[] whitelist=In.readInts(args[0]);
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty())
        {
            int key=StdIn.readInt();
            if(rank(key, whitelist)<0)
            StdOut.println(key);
        
    }

    }
}
