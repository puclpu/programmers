package sappy_pr;

import java.util.Scanner;

public class No5215 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			int[][] grade_cal = new int[N][2];
			for (int i = 0; i < N; i++) {
				grade_cal[i][0] = sc.nextInt(); // grade
				grade_cal[i][1] = sc.nextInt(); // cal
			}
			Best_Combi bc = new Best_Combi();
			int grade = bc.find_best(grade_cal, N, L);
			System.out.println("#"+test_case+" "+grade);
		}

		sc.close();
	}

}

class Best_Combi {
	int[][] arr;
	int max = 0;
	int limit = 0;
	int n = 0;

	public int find_best(int[][] grade_cal, int N, int L) {
		arr = grade_cal;
		limit = L;
		n = N;
		dfs(-1, 0, 0);
		return max;
	}

	private void dfs(int depth, int sum, int cal) {
		if (depth < n) {
			if (depth != -1) {
				sum = sum + arr[depth][0];
				cal = cal + arr[depth][1];
				if (cal <= limit && max < sum)
					max = sum;
			}
			if (cal <= limit) {
				for (int i = depth + 1; i < n; i++) {
					dfs(i, sum, cal);
				}
			}
		}

	}

}