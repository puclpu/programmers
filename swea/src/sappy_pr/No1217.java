package sappy_pr;

import java.util.Scanner;

public class No1217 {

	public static void main(String[] args) {
		// 재귀호출
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int L = cul(N, M);
		System.out.println(L);
		
		sc.close();
	}
	
	public static int cul(int n, int m) {
		int L = 1;
		
		if (m != 0) {
			L = n * cul(n, --m);
		}
		
		return L;
	}

}
