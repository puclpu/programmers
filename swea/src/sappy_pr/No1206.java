package sappy_pr;

import java.util.Scanner;

public class No1206 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		int T = sc.nextInt();
		int T = 1;
//		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int count = 0;
			int N = sc.nextInt();
			int[] building = new int[N];
			for (int i = 0; i < N; i++) {
				building[i] = sc.nextInt();
			}
			
			int[] ar = {-2, -1, 1, 2};
			for (int i = 2; i < building.length-2; i++) {
				int max = -1;
				for (int j = 0; j < ar.length; j++) {
					if (building[i + ar[j]] > max)
						max = building[i + ar[j]];
				}
				
				if (building[i] > max) {
					count += building[i] - max;
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
		
		sc.close();
	}

}
