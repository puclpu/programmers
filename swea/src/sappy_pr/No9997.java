package sappy_pr;

import java.util.Scanner;

public class No9997 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			int theta = sc.nextInt();

			// process
			int m = theta * 2;
			int h = m / 60;
			m = m - h * 60;
			
			// output
			System.out.println("#"+test_case+" "+h+" "+m);
		}

	}

}
