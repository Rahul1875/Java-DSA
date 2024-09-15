package src.com.pack.misc;

import java.util.Arrays;

public class WaystoCoverDist {
	
	static int[] t ;
	
	public static void main(String[] args) {
		
		int dist = 4; 
		t = new int[dist+1];
	    Arrays.fill( t, -1);
		
        System.out.println(printCountRec(dist));

	}

	private static int printCountRec(int dist) {
		
		if(dist<0) {
			return 0;
		}
		if(dist==0) {
			return 1;
		}
		if(t[dist]!=-1) {
			return t[dist];
		}
		
		
		int x = printCountRec(dist-1);
		int y = printCountRec(dist-2);
		int z = printCountRec(dist-3);
		
		return x+y+z;
		
	}

}
