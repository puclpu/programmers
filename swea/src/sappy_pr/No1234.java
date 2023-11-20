package sappy_pr;

import java.util.Scanner;
import java.util.Stack;

public class No1234 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=2;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			int n = sc.nextInt();
			String str = sc.next();
			Stack<Integer> stack = new Stack<>();
			
			// process
			for (int i = 0; i < str.length(); i++) {
				int num = str.charAt(i) - '0';
				if (!stack.isEmpty() && stack.peek() == num) {
					stack.pop();
				} else {
					stack.push(num);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
			// output
			System.out.println("#"+test_case+" "+sb.reverse().toString());
		}

	}

}
