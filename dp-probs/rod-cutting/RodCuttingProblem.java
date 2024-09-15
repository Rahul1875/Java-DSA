package src.com.pack.rod;

import java.util.Arrays;

public class RodCuttingProblem {

	static int[] t ;
	
	public static void main(String[] args) {
		
		
		// length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int price [] = { 1, 5, 8, 9, 10, 17, 17, 20 };

		// rod length
		int n = 4;	
		
		t = new int[n+1];
	    	    Arrays.fill( t, -1);

		System.out.println("Profit is " + rodCut(price, n));

	}

	private static int rodCut(int[] price, int n) {
		
		
		if(n<=0) {
			return 0;
		}
		
		if(t[n]!=-1) {
			return t[n];
		}
		
		int cost = Integer.MIN_VALUE;
		
		for(int i=1;i<=n;i++) {		
			cost = Integer.max(cost,price[i-1]+rodCut(price, n-i));

		}
		
		return t[n] = cost;
	}

}
