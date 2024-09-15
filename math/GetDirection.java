package src.com.pack.maths;

public class GetDirection {

	public static void main(String[] args) {
		
		Point A = new Point(-30, 10);
		Point B = new Point(29, -15);
		Point P = new Point(15, -10);
		
		B = substract(B,A);
		P = substract(P,A);
		double crossProduct = crossProduct(B, P);
		
		if(crossProduct>0) {
			System.out.println("POINT IS LEFT OF LINE");
		} else if(crossProduct<0) {
			System.out.println("POINT IS RIGHT OF LINE");
		} else {
			System.out.println("POINT IS ON THE LINE");
		}
		
	}
	
	static double crossProduct(Point a, Point b) {
		return (a.x * b.y - a.y*b.x);
		
	}

	private static Point substract(Point m, Point a) {
		
		Point result = new Point(0, 0);
		result.x = m.x - a.x;
		result.y = m.y - a.y;
		
		return result;
		
	}

}
