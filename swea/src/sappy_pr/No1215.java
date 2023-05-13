package sappy_pr;

import java.util.Scanner;

public class No1215 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int pd = sc.nextInt();
		
		char[][] arr = new char[8][8];
		for (int i = 0; i < arr.length; i++) {
			String line = sc.next();
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j + pd - 1 < arr.length) {
					int point = 1;
					for (int h = 0; h < pd / 2; h++) {
						if (arr[i][j+h] != arr[i][j+pd-1-h])
							point = 0;
					}
					count += point;
				}
				if (i + pd - 1 < arr.length) {
					int point = 1;
					for (int v = 0; v < pd / 2; v++) {
						if (arr[i+v][j] != arr[i+pd-1-v][j])
							point = 0;
					}
					count += point;
				}
			}
		}
		
		System.out.println(count);
		
		sc.close();
	}

}
