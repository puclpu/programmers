package sappy_pr;

import java.util.Scanner;

public class No2806_11th {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			
			// input
			int N = sc.nextInt();
			
			// process
			NS nq = new NS();
			int n = nq.solution(N);
			
			// output
			
		}
	}

}
class NS {
	int[] arr;
	int n;
	int Q;
	
	public int solution(int N) {
		arr = new int[N];
		Q = N;
		
		dfs(0);
		return n;
	}
	
	private void dfs (int depth) {
		if (depth == Q) {
			n++;
		} else {
			for (int i = 0; i < Q; i++) {
				arr[depth] = i;
				if (check(depth)) {
					dfs(depth+1);
				}
			}
		}
	}
	private boolean check(int depth) {
		for (int i = 0; i < depth; i++) {
			if (arr[i] == arr[depth])
				return false;
			if (Math.abs(depth-i) == Math.abs(arr[depth]-arr[i]))
				return false;
		}
		return true;
	}
}