package sappy_pr;

import java.util.LinkedList;
import java.util.Scanner;

public class No1228 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			int N = sc.nextInt();
			LinkedList<String> list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				list.add(sc.next());
			}
			int C = sc.nextInt();
			for (int i = 0; i < C; i++) {
				String command = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				for (int j = 0; j < y; j++) {
					list.add(x, sc.next());
				}
			}
			
			// output
			System.out.print("#"+test_case);
			for (int i = 0; i < 10; i++) {
				System.out.print(" "+list.get(i));
			}
			System.out.println();
		}

	}

}
