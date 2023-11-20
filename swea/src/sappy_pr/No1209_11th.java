package sappy_pr;

import java.util.Arrays;
import java.util.Scanner;

public class No1209_11th {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 1;
		for (int testcase = 1; testcase <= T; testcase++) {
			// input
			int tc = sc.nextInt();
			int[][] arr = new int[5][5];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// process
			int[] hor = new int[arr.length];
			int[] ver = new int[arr.length];
			int[] dia = new int[2];
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					// 가로 덧셈
					hor[i] += arr[i][j];
					// 세로 덧셈
					ver[j] += arr[i][j];
					// 대각선 덧셈
					if (i == j) 
						dia[0] += arr[i][j];
					if (i + j == arr.length-1) 
						dia[1] += arr[i][j];
				}
			}
			
			int max = hor[0];
			for (int i = 1; i < hor.length; i++) {
				if (max < hor[i])
					max = hor[i];
				if (max < ver[i])
					max = ver[i];
			}
			for (int i = 0; i < dia.length; i++) {
				if (max < dia[i])
					max = dia[i];
			}
			
			// output
			System.out.println("#"+testcase+" "+max);
		}
	}

}
