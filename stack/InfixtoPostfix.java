package src.com.pack.stack;

import java.util.Stack;

public class InfixtoPostfix {

	public static void main(String[] args) {
		
		String str = "A+B*(C^D-E)";
		System.out.println("POSTFIX FORM IS : "+evaluate(str));
	}

	private static String evaluate(String str) {
		
		Stack<Character> stack = new Stack<Character>();
		String result="";
		
		for(char c : str.toCharArray()) {
			
			if(Character.isDigit(c) || Character.isLetter(c)) {
				result = result+c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				char x = stack.pop();
				while(x != '(') {
					result += x;
					x = stack.pop();
				} 
			} else if(precedence(c)>0) {
				
				while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
						result +=stack.pop();
				}			
				stack.push(c);
			}
		}	
        for (int i = 0; i <=stack.size() ; i++) {
            result += stack.pop();
        }
        return result;
	}

	private static int precedence(char c) {
		
		switch(c) {
			case '+' :
			case '-' :
				return 1;
			case '*' :
			case '/' :
				return 2;
			case '^' :
				return 3;
		}
			return -1;			
	}

}
