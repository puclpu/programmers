package sappy_pr;

import java.util.Arrays;
import java.util.Scanner;

public class No4466 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] score = new int[N];
			for (int i = 0; i < score.length; i++) {
				score[i] = sc.nextInt();
			}
			// process
			Arrays.sort(score);
			int sum = 0;
			for (int i = 0; i < K; i++) {
				sum += score[score.length-1-i];
			}
			// output
			System.out.println("#"+test_case+" "+sum);
		}
	}

}
