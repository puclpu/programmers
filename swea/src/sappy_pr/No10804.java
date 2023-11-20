package sappy_pr;

import java.util.Scanner;
import java.util.Stack;

public class No10804 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			String bdpq = sc.next();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < bdpq.length(); i++) {
				stack.push(bdpq.charAt(i));
			}
			// process
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				char c = stack.pop();
				switch (c) {
				case 'b' :
					sb.append('d');
					break;
				case 'd' :
					sb.append('b');
					break;
				case 'p' :
					sb.append('q');
					break;
				case 'q' :
					sb.append('p');
					break;
				}
			}
			// output
			System.out.println("#"+test_case+" "+sb.toString());
		}

	}

}
