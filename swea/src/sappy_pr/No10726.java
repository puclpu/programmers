package sappy_pr;

import java.util.Scanner;

public class No10726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			long M = sc.nextLong();
			
			String bit = "ON";
			if (M == 0)
				bit = "OFF";
			int count = 0;
			while (M > 0 && count < N) {
				if (M % 2 != 1) {
					bit = "OFF";
					break;
				}
				count++;
			}
			
			System.out.println("#" + test_case + " " + bit);
		}
		
		sc.close();
	}
}
