package src.com.pack.stack;

import java.util.Stack;

public class PostfixEvaluation {

	public static void main(String[] args) {
		
		String str = "23*54*+9-";			
		System.out.println("Result of Evaluation: "+evaluate(str));
	}

	private static int evaluate(String str) {
			
		Stack<Integer> stack = new Stack<Integer>();

		for(char ch : str.toCharArray()) {			
			if(Character.isDigit(ch)) {
				stack.push(ch-'0');
			}else {
				int y = stack.pop();
				int x = stack.pop();
				
				if(ch == '+') {
					stack.push(x+y);
				}else if(ch == '-') {
					stack.push(x-y);
				}else if(ch == '*') {
					stack.push(x*y);
				}else if(ch == '/') {
					stack.push(x/y);
				}  
			}
		}
		return stack.pop();
	}
}
