package sappy_pr;

import java.util.Scanner;

public class No12004 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			String answer = "No";
			for (int i = 9; i > 0; i--) {
				if (N % i == 0 && N / i <= 9)
					answer = "Yes";
			}
			System.out.println("#" + test_case + " " + answer);
		}
		
		sc.close();
	}

}
