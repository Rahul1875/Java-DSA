package src.com.pack.stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStringByStack {
	
	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		String str = sc.next();
		
		String rstr = reverse(str);
		
		System.out.println("Reverse of the String : "+rstr);
		
	}

	private static String reverse(String str) {
		
		int len = str.length();
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<len;i++) {
			stack.push(str.charAt(i));	
		}
		
		StringBuilder strb = new StringBuilder();
		while(!stack.isEmpty()) {
			strb.append(stack.pop());
		}	
		return strb.toString();
	}

}
