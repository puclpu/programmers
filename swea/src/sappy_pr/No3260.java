package sappy_pr;

import java.math.BigInteger;
import java.util.Scanner;

public class No3260 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			BigInteger A = sc.nextBigInteger();
			BigInteger B = sc.nextBigInteger();
			
			BigInteger sum = A.add(B);
			System.out.print("#" + test_case + " " + sum);
		}
		
		sc.close();
	}

}
