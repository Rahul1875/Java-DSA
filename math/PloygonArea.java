package src.com.pack.maths;

class Point {
	
	double x;
	double y;
	public Point(double m, double n) {
		x = m;
		y = n;
	}
}


public class PloygonArea {

	public static void main(String[] args) {
		
		double sum  = 0.0;
		Point[] vertices = new Point[3];	
		 
		vertices[0] = new Point(-4, 2);
		vertices[1] = new Point(5,-2);
		vertices[2] = new Point(5,4);
		
		int n = vertices.length;
		System.out.println("n"+n);
		for(int i=0;i<n;i++) {
			sum+=crossProduct(vertices[i], vertices[(i+1)%n]);
		}
		System.out.println("Area of Polygon: "+ Math.abs(sum/2.0));

	}
	
	static double crossProduct(Point a, Point b) {
		System.out.println("sum "+(a.x * b.y - a.y*b.x));
		return (a.x * b.y - a.y*b.x);
		
	}

}
