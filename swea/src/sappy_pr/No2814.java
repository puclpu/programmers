package sappy_pr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class No2814 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			ArrayList<ArrayList<Integer>> node = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				ArrayList<Integer> list = new ArrayList<>();
				node.add(list);
			}
			
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				node.get(x-1).add(y);
				node.get(y-1).add(x);
			}
			
			
		}
		
		sc.close();
	}

}