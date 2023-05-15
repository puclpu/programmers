package sappy_pr;

import java.util.Scanner;

public class No1873 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] board = new char[H][W];
			int tx = 0, ty = 0;
			for (int i = 0; i < H; i++) {
				String wline = sc.next();
				for (int j = 0; j < W; j++) {
					board[i][j] = wline.charAt(j);
					if (board[i][j] == '^' || board[i][j] == 'v'
							|| board[i][j] == '<' || board[i][j] == '>') {
						tx = i;
						ty = j;
					}
				}
			}
			int N = sc.nextInt();
			char[] insert = new char[N];
			String si = sc.next();
			for (int i = 0; i < N; i++) {
				insert[i] = si.charAt(i);
			}
			
			for (int i = 0; i < insert.length; i++) {
				switch (insert[i]) {
				case 'U' :
					if (tx > 0 && board[tx-1][ty] == '.') { // 한 칸위가 평지
						board[tx-1][ty] = '^';
						board[tx][ty] = '.';
						tx = tx-1;
					} else {
						board[tx][ty] = '^';
					}
					break;
				case 'D' :
					if (tx < H-1 && board[tx+1][ty] == '.') {
						board[tx+1][ty] = 'v';
						board[tx][ty] = '.';
						tx = tx + 1;
					} else {
						board[tx][ty] = 'v';
					}
					break;
				case 'L' :
					if (ty > 0 && board[tx][ty-1] == '.') {
						board[tx][ty-1] = '<';
						board[tx][ty] = '.';
						ty = ty - 1;
					} else {
						board[tx][ty] = '<';
					}
					break;
				case 'R' :
					if (ty < W-1 && board[tx][ty+1] == '.') {
						board[tx][ty+1] = '>';
						board[tx][ty] = '.';
						ty = ty + 1;
					} else {
						board[tx][ty] = '>';
					}
					break;
				case 'S' :
					switch (board[tx][ty]) {
						case '^' :
							for (int j = tx; j >= 0; j--) {
								if (board[j][ty] == '*') {
									board[j][ty] = '.';
									break;
								} else if (board[j][ty] == '#') {
									break;
								}
							}
							break;
						case 'v' :
							for (int j = tx; j < H; j++) {
								if (board[j][ty] == '*') {
									board[j][ty] = '.';
									break;
								} else if (board[j][ty] == '#') {
									break;
								}
							}
							break;
						case '<' :
							for (int j = ty; j >= 0; j--) {
								if (board[tx][j] == '*') {
									board[tx][j] = '.';
								} else if (board[tx][j] == '#') {
									break;
								}
							}
							break;
						case '>' :
							for (int j = tx; j < W; j++) {
								if (board[tx][j] == '*') {
									board[tx][j] = '.';
									break;
								} else if (board[tx][j] == '#') {
									break;
								}
							}
							break;
					}
					break;
				}
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
		}
		
		sc.close();
	}

}
