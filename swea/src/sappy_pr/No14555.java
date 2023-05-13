package sappy_pr;

import java.util.Scanner;

public class No14555 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			String grass = sc.next();
			int count = 0;
			for (int i = 0; i < grass.length()-1; i++) {
				if (grass.charAt(i) == '(') {
					count++;
				} else if (grass.charAt(i) == '|' && grass.charAt(i+1) == ')') {
					count++;
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
		
		sc.close();
	}

}
