package sappy_pr;

import java.util.Scanner;

public class No2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int sum = 0;
			int N = sc.nextInt();
			if (N == 1) {
				sum = sc.nextInt();
			} else {				
				int[][] farm = new int[N][N];
				for (int i = 0; i < farm.length; i++) {
					String line = sc.next();
					for (int j = 0; j < farm.length; j++) {
						farm[i][j] = line.charAt(j) - '0';
					}
				}
				
				for (int i = 0; i < farm.length; i++) {
					int mid = N / 2;
					int start = Math.abs(mid-i);
					for (int j = start; j < N-start; j++) {
						sum += farm[i][j];
					}
				}
			}
			System.out.println("#"+test_case+" "+sum);
		}
		
		sc.close();
	}

}
