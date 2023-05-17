package sappy_pr;

import java.util.Arrays;
import java.util.Scanner;

public class No1860 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] time = new int[N];
			boolean possible = true;
			
			for (int i = 0; i < N; i++) {
				time[i] = sc.nextInt();
			}
			Arrays.sort(time);
			
			for (int i = 0; i < N; i++) {
				if (time[i] == 0) {
					possible = false;
					break;
				} else {
					int made = (time[i]/M) * K;
					int out = i;
					if (made - out <= 0) {
						possible = false;
						break;
					}
				}
			}
			
			System.out.print("#" + test_case + " ");
			if (possible) {
				System.out.println("Possible");
			} else {
				System.out.println("Impossible");
			}
		}
		
		sc.close();
	}

}
