package sappy_pr;

import java.util.Scanner;

public class No1_11th {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			// input
			int N = sc.nextInt();
			int[] num = new int[N];
			for (int i = 0; i < num.length; i++) {
				num[i] = sc.nextInt();
			}
			// process
			int round = 0;
			boolean moved = true;
			while (moved) {
				moved = false;
				// 1
				for (int i = 0; i < num.length-1; i+=2) {
					if (num[i] > num[i+1]) {
						int tmp = num[i];
						num[i] = num[i+1];
						num[i+1] = tmp;
						moved = true;
					}
				}
				// 2
				for (int i = 1; i < num.length-1; i+=2) {
					if (num[i] > num[i+1]) {
						int tmp = num[i];
						num[i] = num[i+1];
						num[i+1] = tmp;
						moved = true;
					}
				}
				if (moved) {
					round++;
				} else {
					break;
				}
			}
			System.out.println("#"+test_case+" "+round);
		}
	}

}
