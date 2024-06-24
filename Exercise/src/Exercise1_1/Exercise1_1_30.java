
public class Exercise1_1_30 {
    public static boolean[][] bool_array(int N)
    {

        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = areRelativelyPrime(i, j);
            }
        }
        return a;

    }

    public static int gcd(int i,int j)
    {
        if (j == 0)
            return i;

        return gcd(j, i % j);

    }

    public static boolean areRelativelyPrime(int a,int b)
    {
        return gcd(a, b) == 1;
    }


    public static void main(String[] args) {
        
        int N = 50;
        for (int i = 0; i < N; i++)
        {
            for(int j=0;j<N;j++)
                System.out.print(areRelativelyPrime(i, j)+" ");
            System.out.println("\n");
                
            
        }
      
    }
}
