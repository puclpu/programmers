package sappy_pr;

import java.util.Scanner;

public class No16910 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			
			int count = 0;
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= N; j++) {
					if (i * i + j * j <= N * N) {
						if (i > 0 && j > 0) {
							count += 4;
						} else if (i == 0 && j == 0) {
							count++;
						} else {
							count += 2;
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
		
		sc.close();
	}

}
