package sappy_pr;

import java.util.Scanner;

public class No5215_11th {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			// input
			int N = sc.nextInt(); // 재료 수
			int L = sc.nextInt(); // 제한 칼로리
			int[] score = new int[N]; // 점수
			int[] kcal = new int[N]; // 칼로리
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}

			// process
			Buger buger = new Buger();
			int best = buger.findBest(N, L, score, kcal);
			
			// output
			System.out.println("#"+testcase+" "+best);
		}
	}
}
class Buger {
	int n;
	int limit;
	int[] score;
	int[] kcal;
	int max = 0;
	
	public int findBest(int N, int L, int[] s, int[] kc) {
		n = N;
		limit = L;
		score = s;
		kcal = kc;
		
		dfs(-1, 0, 0);
		
		return max;
	}
	
	private void dfs(int depth, int sum_score, int sum_kcal) {
		if (depth < n) {
			if (depth != -1) {
				sum_score += score[depth];
				sum_kcal += kcal[depth];
			}
			if (sum_kcal <= limit) {
				if (sum_score > max)
					max = sum_score;
				for (int i = depth+1; i < n; i++)
					dfs(i, sum_score, sum_kcal);
			}
		}
	}
}