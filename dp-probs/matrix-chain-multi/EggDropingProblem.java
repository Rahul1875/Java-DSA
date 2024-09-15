package src.com.pack.mcm;

public class EggDropingProblem {
	
	static int[][] t;
	
	public static void main(String[] args) {
		
		 int e = 2, f = 10; 
		 t =  new int[51][51];
	        System.out.print("Minimum number of "
	                         + "trials in worst case with "
	                         + e + " eggs and " + f 
	                         + " floors is : " + eggDrop(e, f)); 
	    }

	private static int eggDrop(int e, int f) {
		
		if(e==1) {
			return f;
		}
		if(f==0||f==1) {
			return f;
		}
		
		if(t[e][f]!=0) {
			return t[e][f];
		}
		
		int min = Integer.MAX_VALUE;
		for(int k=1;k<=f;k++) {
			int res = 1+ Math.max(eggDrop(e-1, f-1), eggDrop(e, f-k));
			min = Math.min(min, res);
		}
		
		return t[e][f] = min;
	} 

	

}
