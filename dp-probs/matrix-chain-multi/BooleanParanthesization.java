package src.com.pack.mcm;

import java.util.HashMap;
import java.util.Map;

public class BooleanParanthesization {
	
	static Map<String, Integer> map;
	
	public static void main(String[] args) {
		
		String str = "T|T&F^T";
		int n = str.length();
		map =  new HashMap<String, Integer>();
		System.out.println(countParenth(str, 0, n-1, true));

	}

	private static int countParenth(String str, int i, int j, boolean isTrue) {
		
		
		if(i>j) {
			return 0;
		}
		if(i==j) {
			if(isTrue)
			return (str.charAt(i) == 'T') ? 1 : 0;
			else 
				return (str.charAt(i) == 'F') ? 1 : 0;
		} 
		
		StringBuilder sb = new StringBuilder();
		sb .append(i+"_"+j+"_"+isTrue);
		
		if(map.containsKey(sb.toString())) {
			return map.get(sb.toString());
		}
		
		
		int ans=0;
		for(int k=i+1;k<j;k+=2) {
			int lT = countParenth(str, i, k-1, true);
			int lF = countParenth(str, i, k-1, false);
			int rT = countParenth(str, k+1, j, true);
			int rF = countParenth(str, k+1, j, false);
					
			if(str.charAt(k)=='&') {
				if(isTrue==true) {
					ans = ans+ lT*rT;
				} else {
					ans = ans+ lT*rF+rT*lF+lF*rF;
				}
			} else if(str.charAt(k)=='|') {
				if(isTrue==true) {
					ans = ans+lT*rT+lT*rF+rT*lF;
				} else {
					ans = ans+ lF*rF;
				}
			} else if(str.charAt(k)=='^') {
				if(isTrue==true) {
					ans = ans+lT*rF+rT*lF;
				} else {
					ans = ans+lT*rT+lF*rF;
				}
			}			
		}		
		map.put(sb.toString(), ans);
		return ans;
	}

}
