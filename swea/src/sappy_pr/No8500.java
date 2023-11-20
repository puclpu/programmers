package sappy_pr;

import java.util.Arrays;
import java.util.Scanner;

public class No8500 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			int N = sc.nextInt();
			int[] A = new int[N];
			for (int i = 0; i < A.length; i++) {
				A[i] = sc.nextInt();
			}
			
			// process
			Arrays.sort(A);
			int seat = 0;
			for (int i = 0; i < A.length-1; i++) {
				seat += A[i]+1;
			}
			seat += A[A.length-1] * 2 + 1;
			
			// output
			System.out.println("#"+test_case+" "+seat);
		}

	}

}
