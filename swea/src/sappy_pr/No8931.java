package sappy_pr;

import java.util.Scanner;
import java.util.Stack;

public class No8931 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int K = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < K; i++) {
				int num = sc.nextInt();
				if (num == 0 && !stack.isEmpty()) {
					stack.pop();
				} else {
					stack.push(num);
				}
			}
			int sum = 0;
			while (!stack.isEmpty()) {
				sum += stack.pop();
			}
			System.out.println("#"+test_case+" "+sum);
		}

	}

}
