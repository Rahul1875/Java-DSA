package src.com.pack.stack;

public class MAHinBinaryRectangle {

	public static void main(String[] args) {
		
		int[][] hist = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1,1 }, { 1, 1, 0, 0 } };
		int n = hist.length;
		int m = hist[0].length;
		
		int[] v1 = new int[m];
		for(int j=0;j<m;j++) {
			v1[j] = hist[0][j];
		}
		
		for(int x: v1) {
			System.out.print(x);
		}
		
		int max = MAH(v1,v1.length);
		
		for(int i =1;i<n;i++) {
			for(int j=0;j<m;j++) {
				
				if(hist[i][j]==0) {
					v1[j]=0;
				} else {
					v1[j]=v1[j]+hist[i][j];
				}
			}
			System.out.println();
			for(int x: v1) {
				System.out.print(x);
			}
			max = Math.max(max, MAH(v1, v1.length));
		}

	}

	private static int MAH(int[] v1, int length) {
		// TODO Auto-generated method stub
		return 0;
	}

}
