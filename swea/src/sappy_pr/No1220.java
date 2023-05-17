package sappy_pr;

import java.util.Scanner;

public class No1220 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				boolean fn = false;
				for (int j = 0; j < arr.length; j++) {
					if(arr[j][i] == 1)
						fn = true;
					if(fn && arr[j][i] == 2) {
						count++;
						fn = false;
					}
				}
			}
			System.out.println("#"+test_case + " " + count);
		}
		
		sc.close();
	}

}
