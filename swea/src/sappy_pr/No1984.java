package sappy_pr;

import java.util.Scanner;

public class No1984 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int max = sc.nextInt();
			int min = sc.nextInt();
			int sum = max + min;
			for (int i = 0; i < 8; i++) {
				int n = sc.nextInt();
				sum += n;
				if (max < n)
					max = n;
				if (min > n)
					min = n;
			}
			sum = sum - max - min;
			double answer = Math.round(sum);
			System.out.println("#" + test_case + " " + (int)answer);
		}
		
		sc.close();
	}

}
