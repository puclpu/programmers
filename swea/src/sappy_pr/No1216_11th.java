package sappy_pr;

import java.util.Scanner;

public class No1216_11th {
	
//1
//cbcabbac
//bbabcaba
//abcbcaca
//baccaabb
//bcbcacbc
//cabacccb
//caaaccab
//cbabacac

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=1;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			int tc = sc.nextInt();
			
			char[][] arr = new char[8][8];
			for (int i = 0; i < arr.length; i++) {
				String str = sc.next();
				for (int j = 0; j < str.length(); j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			// process
			int max = 0;
			for (int x = 0; x < arr.length-1; x++) {
				for (int y = 0; y < arr[x].length-1; y++) {
					System.out.println(max);
					// 가로
					for (int i = arr.length-1; i > y; i--) {
						if (arr[x][y] == arr[x][i]) {
							// 대칭 확인
							boolean pd = true;
							int hp1 = y+1, hp2 = i-1;
							for(; hp1 < hp2; hp1++, hp2--) {
								if (arr[x][hp1] != arr[x][hp2]) {
									pd = false;
									break;
								}
							}
							if (pd && i-y+1 > max) // 대칭이고 max보다 길면
								max = i-y+1;
						}
					}
					// 세로
					for (int i = arr.length-1; i > x; i--) {
						if(arr[x][y] == arr[i][y]) {
							// 대칭 확인
							boolean pd = true;
							int vp1 = x+1, vp2 = i-1;
							for(; vp1 < vp2; vp1++, vp2--) {
								if (arr[vp1][y] != arr[vp2][y]) {
									pd = false;
									break;
								}
							}
							if (pd && i-x+1 > max)
								max = i-x+1;
						}
					}
				}
			}
			// output
			System.out.println("#"+tc+" "+max);
		}
	}
}
