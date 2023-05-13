package sappy_pr;

import java.util.Scanner;

public class No9229 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] snack = new int[N];
			for(int i = 0; i < N; i++)
				snack[i] = sc.nextInt();
			
			int max = -1;
			for(int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					int sum = snack[i] + snack[j];
					if (max < sum && sum <= M)
						max = snack[i] + snack[j];
				}
			}
			System.out.println("#" + test_case + " " + max);
		}
		
		sc.close();
	}

}
