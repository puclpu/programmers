package sappy_pr;

import java.util.Scanner;

public class No15230 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			char a = 'a';
			int count = 0;
			
			String str = sc.next();
			for(int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == a + i)
					count++;
				else
					break;
			}
			System.out.println("#" + test_case + " " + count);
		}
		
		sc.close();
	}

}
