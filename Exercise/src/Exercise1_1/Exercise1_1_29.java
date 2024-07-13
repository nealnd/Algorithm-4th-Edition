package Exercise1_1;
import java.util.Arrays;

public class Exercise1_1_29 {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        int mid = a.length;
        while ((lo <= hi) && (a[hi] >= key)) {
            mid = lo + (hi - lo) / 2;
            if (key <= a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
        }
        return mid;
    }

    public static int count(int key,int[]a){
        return (rank(key+1,a)-rank(key,a));
        
    }

    public static void main(String[] args) {
        int[] whitelist = { 0, 0, 1, 1, 1, 2, 3, 4, 4, 6, 6, 7, 8, 7, 5 };
        Arrays.sort(whitelist);
        System.out.println(rank(1, whitelist));
        System.out.println(count(1,whitelist));
    }

}
