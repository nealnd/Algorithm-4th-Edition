package Exercise2_3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise2_3_16 {

	private static void best(int [] a,int lo,int hi)
	{
		//try to lay the mid in the first position in the array
	/* 	for (int i = lo; i <=hi ; i++) 
		{
			assert a[i]==i;
		}
            */
		if(hi<=lo)
			return;
		int mid=lo+(hi-lo)/2;
		best(a, lo, mid-1);
		best(a, mid+1, hi);
		exch(a,lo,mid);//
	
	}
	public static int [] best(int n)
	{
		int [] a=new int[n];
		for (int i = 0; i <n ; i++) 
		{
			a[i]=i;
		}
		best(a,0,n-1);
		return a;
	}
	private static void exch(int [] a,int i,int j)
	{
		int swap=a[i];
		a[i]=a[j];
		a[j]=swap;
	}
	public static void main(String[] args) {
		String alphabet = "ABCDEFGH";
		int n = 8;
		int[] a = best(n);
		for (int i = 0; i < n; i++)
		{
			StdOut.print(alphabet.charAt(a[i]));

		}
		StdOut.println();
	}
}
