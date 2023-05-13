package sappy_pr;

import java.util.Scanner;

public class No1289 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String origin = sc.next();
		
		int count = 0;
		char c = '0';
		
		for (int i = 0; i < origin.length(); i++) {
			if (origin.charAt(i) != c) {
				count++;
				c = origin.charAt(i);
			}
		}
		
		System.out.println(count);
		
		sc.close();
	}

}
