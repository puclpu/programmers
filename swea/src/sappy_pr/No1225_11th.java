package sappy_pr;

import java.util.Scanner;

public class No1225_11th {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			int tc = sc.nextInt();
			int[] num = new int[8];
			for (int i = 0; i < num.length; i++) {
				num[i] = sc.nextInt();
			}
			
			// process
			int sub_num = 1;
			while(num[7] > 0) { // 감소된 숫자가 0보다 작으면 중지
				// 첫 번째 숫자 감소
				int first = num[0] - sub_num;
				// 배열 정리
				for (int i = 1; i < num.length; i++) {
					num[i-1] = num[i];
				}
				// 감소된 첫 번째 숫자를 맨 뒤로
				num[7] = first;
				// 차감될 수
				if (sub_num < 5) {
					sub_num++;
				} else {
					sub_num = 1;
				}
			}
			// 맨 뒤 숫자가 0보다 작으면 0으로
			if (num[7] < 0)
				num[7] = 0;
			
			// output
			System.out.print("#" + test_case);
			for (int i = 0; i < num.length; i++) {
				System.out.print(" " + num[i]);
			}
			System.out.println();
		}

	}

}
