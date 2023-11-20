package sappy_pr;

import java.util.Scanner;

public class No9700 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			double p = sc.nextDouble();
			double q = sc.nextDouble();
			
			double s1 = (1-p) * q;
			double s2 = p * (1-q) * q;
			
			System.out.print("#"+test_case+ " ");
			if (s1 < s2) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			System.out.println(s1 + " " + s2);
		}

	}

}
