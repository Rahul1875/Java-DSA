package src.com.pack.stack;

import java.util.Stack;

public class MatchParanthesis {

	   public static void main(String args[]) {

	        System.out.println(checkParenthensies("{(b)}"));
	        System.out.println(checkParenthensies("{(a},b)"));
	        System.out.println(checkParenthensies("{)(}"));
	    }

	    public static boolean checkParenthensies(String s) {
	        Stack<Character> stack  = new Stack<Character>();
	        for(int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            if(c == '[' || c == '(' || c == '{' ) {     
	                stack.push(c);
	            } else if(c == ']') {
	                if(stack.isEmpty() || stack.pop() != '[') {
	                    return false;
	                }
	            } else if(c == ')') {
	                if(stack.isEmpty() || stack.pop() != '(') {
	                    return false;
	                }           
	            } else if(c == '}') {
	                if(stack.isEmpty() || stack.pop() != '{') {
	                    return false;
	                }
	            }

	        }
	        return stack.isEmpty();
	    }

}
