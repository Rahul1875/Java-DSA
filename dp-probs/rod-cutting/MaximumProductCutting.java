package src.com.pack.rod;

import java.util.Arrays;

public class MaximumProductCutting {

	static int[] t ;
	
	public static void main(String[] args) {
		
		int n = 15;		// 3 x 5 times
		
		t = new int[n+1];
	    Arrays.fill( t, -1);
		
		System.out.println("Maximum Profit is " + rodCut(n));

	}

	private static int rodCut(int n) {
			
		if(n<=1) {
			return n;
		}
		
		if(t[n]!=-1) {
			return t[n];
		}
		
		int cost = n;
		
		for(int i=1;i<=n;i++) {		
			cost = Integer.max(cost,(i)*rodCut(n-i));

		}
		
		return t[n] = cost;
	}

}
