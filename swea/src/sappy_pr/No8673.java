package sappy_pr;

import java.util.LinkedList;
import java.util.Scanner;

public class No8673 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			int K = sc.nextInt();
			LinkedList<Integer> queue = new LinkedList<>();
			int pn = 1;
			for (int i = 0; i < K; i++) {
				pn *= 2;
			}
			for (int i = 0; i < pn; i++) {
				int n = sc.nextInt();
				queue.add(n);
			}
			
			// process
			int sum = 0;
			while (!queue.isEmpty()) {
				for (int i = 0; i < pn / 2; i++) {
					int a = queue.poll();
					int b= queue.poll();
					System.out.println(a + " " + b + " | sum " + sum);
					if (a < b) {
						sum += b - a;
						queue.add(b);
					} else {
						sum += a - b;
						queue.add(a);
					}
				}
				if (pn == 1)
					break;
				pn /= 2;
			}
			
			// output
			System.out.println("#"+test_case+" "+sum);
			
		}

	}

}
