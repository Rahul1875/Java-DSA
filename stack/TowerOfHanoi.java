package src.com.pack.stack;

import java.util.Scanner;

public class TowerOfHanoi {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int plates = sc.nextInt();
		
		TOH(plates, 'A','C','B');

	}

	private static void TOH(int n, char intialRod, char finalRod, char middleRod) {
		
		if(n<1) {
			return;
		}
		TOH(n-1, intialRod, middleRod, finalRod);
		System.out.println("Move disk "+ n+ " from Rod "+ intialRod + " finalRod "+finalRod);
		TOH(n-1, middleRod, finalRod, intialRod);
		
	}

}
