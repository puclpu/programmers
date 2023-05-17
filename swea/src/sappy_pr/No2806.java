package sappy_pr;

import java.util.Scanner;

public class No2806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			Nqueen nq = new Nqueen();
			int count = nq.n_queens(N);
			System.out.println("#"+ test_case + " " + count);
		}
		
		sc.close();
	}
	
}

class Nqueen {
	int answer = 0;
	int[] arr;
	int Q;
	public int n_queens(int N) {
		arr = new int[N];
		Q = N;
		
		dfs(0);
		
		return answer;
	}
	
	public void dfs (int depth) {
		if (depth == Q) {
			answer++;
		} else {
			for (int i = 0; i < Q; i++) {
				arr[depth] = i;
				if (possible(depth)) {
					dfs(depth+1);
				}
			}
		}
	}
	
	private boolean possible(int depth) {
		for (int i = 0; i < depth; i++) {
			// 열에 일치하는게 있는지 판별
			if (arr[i] == arr[depth]) {
				return false;
			} // 대각선에 일치하는게 있는지 판별
			else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
				return false;
			}
		}
		return true;
		
	}
}