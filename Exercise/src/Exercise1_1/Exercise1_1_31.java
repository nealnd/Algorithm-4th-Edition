
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_1_31 {
    
	private static class Point
	{
		private double x;
		private double y;
		public Point(double x,double y)
		{
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args)
	{
        int N = Integer.parseInt(args[0]);
        double p =Double.parseDouble(args[1]);
		StdDraw.setPenRadius(0.005);
		double x0=0.5,y0=0.5,r=0.4;
		StdDraw.circle(x0, y0, r);
		StdDraw.setPenRadius(0.05);
		Point [] points=new Point[N];
		for (int i = 0; i <N ; i++) 
		{
			double angle=i*2*Math.PI/N;
			double x=x0+r*Math.sin(angle);
			double y=y0+r*Math.cos(angle);
			points[i]=new Point(x, y);
			StdDraw.point(points[i].x, points[i].y);
		}
		StdDraw.setPenRadius(0.005);
		for (int i = 0; i <N ; i++) 
		{
			for (int j = i+1; j <N ; j++) 
			{
				if(StdRandom.bernoulli(p))
					StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
			}
		}
	}
}