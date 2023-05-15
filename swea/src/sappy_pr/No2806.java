package sappy_pr;

import java.util.Scanner;

public class No2806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int Q = N; // Queen의 갯수
			int[][] chess = new int[N][N]; // N * N 보드
			
			
		}
		
		sc.close();
	}
	
}

class Nqueen {
	int answer = 0;
	private void dfs(int[][] chess, int q, int Q) {
		if (q == Q) {
			answer++;
		} else {
			
		}
	}
}