package src.com.pack.knapsack;

import java.util.Arrays;

// Knapsack Problem - With Memoization

public class Knapsack01 {

	static int[][] t ;
	
	public static void main(String[] args) {
		
	       int val[] = new int[] { 60, 100, 120 }; 
	       int wt[] = new int[] { 10, 20, 30 }; 
	       int W = 50; 
	       int n = val.length; 
	       t = new int[n+1][W+1];
	       for(int x=0;x<t.length;x++)
	    	    Arrays.fill( t[x], -1);
	       System.out.println(knapSack(wt, val,W, n));

	}

	private static int knapSack(int[] wt, int[] val, int W, int n) {
			
		if(n==0||W==0) {
			return 0;
		}
		
		if(t[n][W] != -1) {
			return t[n][W];
		}
		
		if(wt[n-1]<=W) {
			return t[n][W] = max((val[n-1]+knapSack(wt, val, W-wt[n-1], n-1)),knapSack(wt, val, W, n-1));
		} else {
			return t[n][W] = knapSack(wt, val, W, n-1);
		}
	}

	private static int max(int a, int b) {
		
		return (a > b) ? a : b;
	}

}
