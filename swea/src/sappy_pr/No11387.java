package sappy_pr;

import java.util.Scanner;

public class No11387 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int D = sc.nextInt();
			int L = sc.nextInt();
			int N = sc.nextInt();
			int sum = 0;
            for(int i = 0; i < N; i++) {
            	sum += D  + D * i * L * 0.01;
            }
			
			System.out.println("#" + test_case + " " + sum);
		}
		
		sc.close();
	}

}
