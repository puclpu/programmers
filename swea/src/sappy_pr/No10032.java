package sappy_pr;

import java.util.Scanner;

public class No10032 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int minus = 0;
			
			if (N % K != 0) {
				minus = 1;
			}
			
			System.out.println("#" + test_case + " " + minus);
		}
		
		sc.close();
	}

}
