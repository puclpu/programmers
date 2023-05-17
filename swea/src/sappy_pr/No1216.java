package sappy_pr;

import java.util.Scanner;

public class No1216 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int ts = sc.nextInt();
			char[][] arr = new char[100][100];
//			char[][] arr = new char[8][8];
			for (int i = 0; i < arr.length; i++) {
				String line = sc.next();
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = line.charAt(j);
				}
			}
			
			int max = 0;
			for (int i = 0; i < arr.length-1; i++) {
				for (int j = 0; j < arr.length-1; j++) {
					char start = arr[i][j];
					// hor
					for (int k = arr.length-1; k > j; k--) {
						if (arr[i][k] == start) { // start와 end가 같으면
							// 나머지 대칭 확인
//							System.out.println("hor" + i + " " + j + k);
							boolean flag = true;
							for (int m = 1; m <= (k-j+1)/2; m++) {
								if (arr[i][j+m] != arr[i][k-m])
									flag = false;
							}
							if (flag && k-j+1 > max) { // true면 가장 길이가 긴 회문
								max = k - j + 1;
//								System.out.println(max);
							}
						}
					}
					
					// ver
					for (int k = arr.length-1; k > i; k--) {
						if (arr[k][j] == start) {
							// 나머지 대칭 확인
//							System.out.println("ver" + j + " " + i + k);
							boolean flag = true;
							for (int m = 1; m <= (k-i+1)/2; m++) {
								if (arr[i+m][j] != arr[k-m][j])
									flag = false;
							}
							if (flag && k-i+1 > max) { // true면 가장 길이가 긴 회문
								max = k - i + 1;
//								System.out.println(max);
							}
						}
					}
				}
			}
			
			System.out.println("#"+ts+" " + max);
		}
		
		sc.close();
	}
}
