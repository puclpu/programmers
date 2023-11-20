package sappy_pr;

import java.util.Scanner;

public class No3456 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			int d = 0;
			if (a == b) {
				d = c;
			} else if (a == c) {
				d = b;
			} else {
				d = a;
			}
			System.out.println("#"+test_case+" "+d);
		}

	}

}
