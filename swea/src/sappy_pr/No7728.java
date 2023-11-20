package sappy_pr;

import java.util.HashSet;
import java.util.Scanner;

public class No7728 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			String number = sc.next();
			
			// process
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < number.length(); i++) {
				set.add(number.charAt(i)-'0');
			}
			
			// output
			System.out.println("#"+test_case+" "+set.size());
		}

	}

}
