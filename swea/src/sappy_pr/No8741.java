package sappy_pr;

import java.util.Scanner;

public class No8741 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			String[] word = new String[3];
			for (int i = 0; i < word.length; i++) {
				word[i] = sc.next();
			}
			
			// process
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < word.length; i++) {
				sb.append(word[i].charAt(0));
			}
			
			// output
			System.out.println("#"+test_case+" "+sb.toString().toUpperCase());
		}

	}

}
