package sappy_pr;

import java.util.Arrays;
import java.util.Scanner;

public class No1860_11th {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for (int testcase = 1; testcase <= T; testcase++) {
			// input
			int N = sc.nextInt(); // people
			int M = sc.nextInt(); // sec
			int K = sc.nextInt(); // fish
			
			int[] people = new int[N];
			for (int i = 0; i < people.length; i++) {
				people[i] = sc.nextInt();
			}
			
			// 손님 정렬
			Arrays.sort(people);
			
			boolean flag = true;
			for (int i = 0; i < people.length; i++) {
				int made = people[i] / M * K; // 만든 물고기
				int left = made - i;
				if (left <= 0) {
					flag = false;
					break;
				}
			}
			
			// output
			System.out.print("#" + testcase);
			if (flag) {
				System.out.println(" Possible");
			} else {
				System.out.println(" Imopssible");
			}
		}
	}

}
