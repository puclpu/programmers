package sappy_pr;

import java.util.Scanner;

public class No1220_11th {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 1;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			int len = sc.nextInt(); // 한 변의 길이
			int[][] arr = new int[len][len];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// process
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				boolean sn = false;
				for (int j = 0; j < arr.length; j++) {
					if (arr[j][i] == 1)
						sn = true;
					if (sn && arr[j][i] == 2) {
						count++;
						sn = false;
					}
				}
			}
			
			// output
			System.out.println("#"+test_case+" "+count);
		}

	}

}
