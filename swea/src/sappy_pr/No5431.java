package sappy_pr;

import java.util.Scanner;

public class No5431 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			boolean[] submit = new boolean[N+1];
			for (int i = 0; i < K; i++) {
				int stu = sc.nextInt();
				submit[stu] = true;
			}
			System.out.print("#"+test_case);
			for (int i = 1; i < submit.length; i++) {
				if (!submit[i])
					System.out.print(" "+i);
			}
			System.out.println();
		}

	}

}
