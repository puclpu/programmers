package sappy_pr;

import java.util.Scanner;

public class No13229 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			String S = sc.next();
			
			// process
			String[] week = {"SUN","MON","TUE","WED","THU","FRI", "SAT"};
			
			// output
			for (int i = 0; i < week.length; i++) {
				if (S.compareTo(week[i]) == 0) {
					System.out.println("#"+test_case+" "+(7-i));
					break;
				}
			}
			
		}
	}

}
