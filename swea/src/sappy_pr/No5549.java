package sappy_pr;

import java.util.Scanner;

public class No5549 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			String num = sc.next();
			int last = num.charAt(num.length()-1);
			System.out.print("#"+test_case+" ");
			if (last % 2 == 0) {
				System.out.println("Even");
			} else {
				System.out.println("Odd");
			}
		}

	}

}
