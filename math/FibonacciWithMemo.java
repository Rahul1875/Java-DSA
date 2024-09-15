package src.com.pack.gen;

import java.util.Scanner;

public class FibonacciWithMemo {
	
	static int []fibarr;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		fibarr = new int[n+1];
		System.out.println(fib(n));
	}

	private static int fib(int n) {
		
		if(n<=1) {
			return n;
		}
		if(fibarr[n] !=0) {
			return fibarr[n];
		}else {
			fibarr[n] = fib(n-1) + fib(n-2);
			return fibarr[n];
		}
	}
}
