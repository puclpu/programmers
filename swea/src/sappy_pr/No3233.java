package sappy_pr;

import java.util.Scanner;

public class No3233 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int ab = A / B;
			long sum = ab * (1 + (1 + 2 * (ab - 1))) / 2;
			System.out.println("#" + test_case + " " + sum);
		}
		
		sc.close();
	}

}
