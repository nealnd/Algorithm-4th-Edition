
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

@Deprecated
public class Exercise1_1_36 {
    public static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + StdRandom.uniform(N - i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void main(String[] args) {
        int M = 10;
        int N = 5000;
        int[] a = new int[M];
        int[][] countnum=new int[M][M];
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < M; j++) {
                a[j] = j;
            }
            shuffle(a);
            for (int i = 0; i < M; i++)
                countnum[a[i]][i]++;

        }
        for(int i=0;i<M;i++)
        {
            for(int j=0;j<M;j++)
                StdOut.print(countnum[i][j] + " ");
            StdOut.println("\n");
        }
    }
}
