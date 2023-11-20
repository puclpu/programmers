package sappy_pr;

import java.util.Scanner;

public class No2805_11th {
	// start 33
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			// intput
			int N = sc.nextInt();
			if(N == 1) {
				int sum = sc.nextInt();
				System.out.println("#"+testcase+" "+sum);
				continue;
			}
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					farm[i][j] = sc.nextInt();
				}
			}
			
			// process
			int sum = 0;
			int area = 0;
			int middle = N / 2;
			for (int i = 0; i < farm.length; i++) {
				for (int j = middle-area; j <= middle+area; j++) {
					sum += farm[i][j];
				}
				System.out.println(sum);
				if (area < middle) {
					area++;
				} else {
					area--;
				}
			}
			// output
			System.out.println("#"+testcase+" "+sum);
		}
	}

}
