package sappy_pr;

import java.util.Scanner;

public class No1284 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int P = sc.nextInt(); // A사 1리터당 요금
			int Q = sc.nextInt(); // B사 R리터 이하 요금
			int R = sc.nextInt(); // B사 월간 기본 사용량
			int S = sc.nextInt(); // B사 1L당 요금
			int W = sc.nextInt(); // 사용하는 수도의 양 W리터
			
			// A사 요금 계산
			int A = P * W;
			
			// B사 요금 계산
			int B = 0;
			if (W < R) {
				B = Q;
			} else {
				B = Q + (W-R) * S;
			}
			
			if (A < B) {
				System.out.println(A);
			} else {
				System.out.println(B);
			}
		}
		
		sc.close();
	}

}
