package src.com.pack.mcm;

public class ScrambledString {

	public static void main(String[] args) {
		
		String S1 = "great"; 
	    String S2 = "rgeat";
	    
	    if (isScramble(S1, S2)) { 
	        System.out.println("Yes"); 
	    } 
	    else { 
	    	System.out.println("Yes");; 
	    } 

	}

	private static boolean isScramble(String s1, String s2) {
		
		if(s1.length()!=s2.length()) {
			return false;
		}
		
		if(s1.equals(s2)) {
			return true;
		}
		
		int n = s1.length();
		
		if(n<=1) {
			return false;
		}
		
		for(int i=1;i<n;i++) {
			if((isScramble(s1.substring(0, i), s2.substring(n-i))) && 
					(isScramble(s1.substring(i), s2.substring(0,n-i)))) {
				return true;
			}
			if((isScramble(s1.substring(0, i), s2.substring(0,i))) && 
					(isScramble(s1.substring(i), s2.substring(i)))) {
				return true;
			}
		}
			
		return false;
	}

}
