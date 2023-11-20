package sappy_pr;

import java.util.Arrays;
import java.util.Scanner;

public class No6958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] com = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					com[i] += sc.nextInt();
				}
			}
			
			Arrays.sort(com);
			int count = 1;
			for (int i = com.length-2; i >= 0; i--) {
				if (com[i] == com[com.length-1]) {
					count++;
				} else {
					break;
				}
			}
			
			System.out.println("#"+test_case+" "+count + " "+com[com.length-1]);
		}

	}

}
