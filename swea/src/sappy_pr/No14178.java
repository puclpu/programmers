package sappy_pr;

import java.util.Scanner;

public class No14178 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int water = 0;

			int N = sc.nextInt();
			int D = sc.nextInt();

			int i;
			for(i = 1 + D; i < N - D; i += 2 * D + 1) {
				water++;
			}
			if (i - 2 * D -1 < N)
				water++;
			
			System.out.println("#" + test_case + " " + water);
		}
		
		sc.close();
	}

}
