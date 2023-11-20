package sappy_pr;

import java.util.LinkedList;
import java.util.Scanner;

public class No7102 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] sf = new int[N+M+1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					sf[i+j]++;
				}
			}
			
			int max = 0;
			LinkedList<Integer> queue = new LinkedList<>();
			for (int i = 1; i < sf.length; i++) {
				if (sf[i] > max) {
					max = sf[i];
					queue.clear();
					queue.add(i);
				} else if (sf[i] == max) {
					queue.add(i);
				}
			}
			
			System.out.print("#"+test_case);
			while(!queue.isEmpty()) {
				System.out.print(" "+queue.poll());
			}
			System.out.println();
		}

	}
}