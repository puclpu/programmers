package sappy_pr;

import java.util.Scanner;

public class No1974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int answer = 1;
			
			int[][] sdoku = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sdoku[i][j] = sc.nextInt();
				}
			}
			
			// 가로, 세로
			for (int i = 0; i < sdoku.length; i++) {
				int[] nine_h = new int[9]; // horizontal
				int[] nine_v = new int[9]; // vertical
				for (int j = 0; j < 9; j++) {
					nine_h[sdoku[i][j] - 1]++;
					nine_v[sdoku[j][i] - 1]++;
				}
				
				for (int j = 0; j < 9; j++) {
					if (nine_h[j] != 1) {
						answer = 0;
					}
					if (nine_v[j] != 1) {
						answer = 0;
					}
				}
			}
			
			// 3 * 3
			for(int i = 0; i < sdoku.length; i += 3) {
				for (int j = 0; j < sdoku.length; j += 3) {
					int[] nine = new int[9];
					for (int h = i; h < i+3; h++) {
						for (int v = j; v < j+3; v++) {
							nine[sdoku[h][v] - 1]++;
						}
					}
					for (int k = 0; k < nine.length; k++) {
						if (nine[k] != 1) {
							answer = 0;
						}
					}
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		sc.close();
	}

}
