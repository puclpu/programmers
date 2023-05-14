package sappy_pr;

import java.util.Scanner;

public class No8556 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String ewsn = sc.next();
			
			int c = 0;
			int m = 1;
			if (ewsn.charAt(ewsn.length() - 4) == 'w') {
				c = 90;
				ewsn = ewsn.substring(0, ewsn.length() - 4);
			} else if (ewsn.charAt(ewsn.length()-5) == 'n') {
				ewsn = ewsn.substring(0, ewsn.length() - 5);
			}
			
			int two = 1;
			while(!ewsn.equals("")) {
				two *= 2;
				if (ewsn.charAt(ewsn.length() - 4) == 'w') {
					c = c * two + 90 * m;
					ewsn = ewsn.substring(0, ewsn.length() - 4);
				} else if (ewsn.charAt(ewsn.length()-5) == 'n') {
					c = c * two - 90 * m;
					ewsn = ewsn.substring(0, ewsn.length() - 5);
				}
				m = m * two;
			}
			for (int i = m; i >= 2; i--) {
				if (c % i == 0 && m % i == 0) {
					c = c / i;
					m = m / i;
				}
			}
			System.out.print("#" + test_case + " ");
			if (m == 1) {
				System.out.println(c);
			} else {
				System.out.println(c + "/" + m);
			}
		}
		
		sc.close();
	}

}
