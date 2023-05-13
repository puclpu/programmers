package sappy_pr;

import java.util.Scanner;

public class No1946 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				String Ci = sc.next();
				int Ki = sc.nextInt();
				for (int j = 0; j < Ki; j++) {
					sb.append(Ci);
				}
			}
			String str = sb.toString();
			System.out.println("#" + test_case);
			for(int i = 0; i <= str.length(); i += 10) {
				if (i + 10 < str.length()) {
					System.out.println(str.substring(i, i+10));					
				} else {
					System.out.println(str.substring(i));
				}
			}
		}
		
		sc.close();
	}

}
