package sappy_pr;

import java.util.Scanner;

public class No10580 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] line = new int[N][2];
			for (int i = 0; i < N; i++) {
				line[i][0] = sc.nextInt();
				line[i][1] = sc.nextInt();
			}
			
			int count = 0;
			for (int i = 0; i < line.length; i++) {
				for (int j = i+1; j < line.length; j++) {
					if (line[i][0] < line[j][0] && line[i][1] > line[j][1]
							|| line[i][0] > line[j][0] && line[i][1] < line[j][1]) {
						count++;
					}
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
		
		sc.close();
	}

}
