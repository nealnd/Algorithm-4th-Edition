
public class Exercise1_1_19 {
    public static long[] F(int N) {
        if(N<2) N=2;
        long[] array = new long[N];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < N; i++)
            array[i] = array[i - 2] + array[i - 1];
        return array;
    }
    public static void main(String[]args) {
        int N=Integer.parseInt(args[0]);
        for(int i=0;i<N;i++)
        System.out.println(i+" "+F(N)[i]);
    }
}
