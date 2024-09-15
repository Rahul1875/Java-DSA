package src.com.pack.unboundedknap;

public class MinCoinChangeProblem {

	public static void main(String[] args) {
		
		int coins[] =  {9, 6, 5, 1}; 
	    int n = coins.length; 
	    int sum = 11; 
	    System.out.println("Minimum coins required is "+ minCoins(coins, n, sum) ); 
	    

	}

	private static int minCoins(int[] coins, int n, int sum) {
		
		int[][] t  = new int[n+1][sum+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0 || j==0) {
					if(i==0) t[i][j] = Integer.MAX_VALUE-1;
					if(j==0 && i!=0) t[i][j] = 0;
				} else if(i==1) {
					if(j%coins[0]==0) {
						t[i][j] = j/coins[0];
					} else {
						t[i][j] = Integer.MAX_VALUE-1;
					}
				}
				else if(coins[i-1] <= j) {
					t[i][j]= min((1+t[i][j-coins[i-1]]), t[i-1][j]);
				} else {
					t[i][j] = t[i-1][j]; 
				}
			}
			
		}
		
		return t[n][sum];
	}

	private static int min(int a, int b) {
		
		return (a<b)? a:b;
	}

}
