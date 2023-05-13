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
			
			boolean[][] visited = new boolean[N][N];
		}
		
		sc.close();
	}
	
}

class Solution {
	int answer = 0;
	
	public int solution(int[][] chess, boolean[][] visited) {
		
		
		
		return answer;
	}
	
	private void dfs(int x, int y, int[][] chess, boolean[][] visited, int count) {
		if (count == chess.length) {
			answer++;
		} else if (x == chess.length && y == chess.length) {
			
		} else {
			if (visited[x][y]) {
				
			} else {
				chess[x][y] = 1;
				
			}
		}
	}
}
