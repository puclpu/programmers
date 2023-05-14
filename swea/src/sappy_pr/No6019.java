package sappy_pr;

import java.util.Scanner;

public class No6019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			double D = sc.nextInt(); // 기차 전면부 사이 거리
			int A = sc.nextInt(); // A의 속력
			int B = sc.nextInt(); // B의 속력
			int F = sc.nextInt(); // 파리의 속력
			
			double dis = D;
			double bug = 0;

			boolean ab = true; // true = a -> b, false = b -> a
			while(dis > 0) {
				double t = 0.0;
				if (ab) {
					t = dis / (B + F);
					ab = false;
				} else {
					t = dis / (A + F);
					ab = true;
				}
				dis = dis - t * (A + B);
				bug += F * t;
			}
			System.out.print("#"+test_case+" ");
			System.out.printf("%.6f", bug);
			System.out.println();
		}
		
		sc.close();
	}

}
