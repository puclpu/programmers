package sappy_pr;

import java.util.Scanner;

public class No1209 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 2; test_case++) {
			int T = sc.nextInt();
			int[][] arr = new int[100][100];
			int[] h = new int[100];
			int[] v = new int[100];
			int[] d = new int[2];
			int max = 0;
			for (int i = 0; i < arr.length; i++) {
				int hsum = 0;
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
					hsum = hsum + arr[i][j];
					v[j] = v[j] + arr[i][j];
				}
				h[i] = hsum;
				d[0] = d[0] + arr[i][i];
				d[1] = d[1] + arr[i][99-i];
				if (h[i] > max)
					max = h[i];
			}
			for (int i = 0; i < v.length; i++) {
				if (v[i] > max)
					max = v[i];
			}
			for (int i = 0; i < d.length; i++) {
				if (d[i] > max)
					max = d[i];
			}
			System.out.println("#"+T+" "+max);
		}
		
		sc.close();
	}

}
