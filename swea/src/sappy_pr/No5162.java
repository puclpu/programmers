package sappy_pr;

import java.util.Scanner;

public class No5162 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			
			int bread = 0;
			if (A < B) {
				bread = C / A;
			} else {
				bread = C / B;
			}
			System.out.println("#" + test_case + " " + bread);
		}
		
		sc.close();
	}

}
