package sappy_pr;

import java.util.Scanner;

public class No2817 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[] num = new int[N];
			for (int i = 0; i < num.length; i++) {
				num[i] = sc.nextInt();
			}

			DFS dfs = new DFS();
			int answer = dfs.dfs_get(N, K, num);

			System.out.println("#" + test_case + " " + answer);
		}

		sc.close();
	}

}

class DFS {
	int answer = 0;
	int[] numbers;

	public int dfs_get(int N, int K, int[] num) {
		numbers = num;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			dfs(N, K, sum, i);
		}
		return answer;
	}

	private void dfs(int N, int K, int sum, int i) {
		sum += numbers[i];
		if (sum == K) {
			answer++;
		} else {
			for (int j = i + 1; j < N; j++) {
				dfs(N, K, sum, j);
			}
		}
	}
}