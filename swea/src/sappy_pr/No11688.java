package sappy_pr;

import java.util.Scanner;

public class No11688 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String lar = sc.next();
		int a = 1;
		int b = 1;
		
		for (int i = 0; i < lar.length(); i++) {
			char target = lar.charAt(i);
			if (target == 'L') {
				b = a + b;
			} else if (target == 'R') {
				a = a + b;
			}
			
			int bigger = a;
			if (a < b)
				bigger = b;
			
			for (int j = 2; j * j < bigger; j++) {
				if (a % j == 0 && b % j == 0) {
					a = a / j;
					b = b / j;
				}
			}
		}
		
		System.out.println(a + " " + b);
		
		sc.close();
	}

}
