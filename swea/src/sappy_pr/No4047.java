package sappy_pr;

import java.util.Scanner;

public class No4047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int[] S = new int[13];
			int[] D = new int[13];
			int[] H = new int[13];
			int[] C = new int[13];
			boolean flag = false;
			
			String str = sc.next();
			for(int i = 0; i <= str.length()-3; i += 3) {
				String pn = str.substring(i, i+3);
				
				int n = Integer.parseInt(pn.substring(1));
				char p = pn.charAt(0);
				switch (p) {
				case 'S' :
					S[n-1]++;
					break;
				case 'D' :
					D[n-1]++;
					break;
				case 'H' :
					H[n-1]++;
					break;
				case 'C' :
					C[n-1]++;
					break;
				}
				if (S[n-1] > 1 || D[n-1] > 1 || H[n-1] > 1 || C[n-1] > 1) {
					flag = true;
					break;
				}
			}
			if (flag) {
				System.out.println("#" + test_case + " ERROR");
			} else {
				int s = 0, d = 0, h = 0, c = 0;
				for(int i = 0; i < 13; i++) {
					if (S[i] == 0)
						s++;
					if (D[i] == 0)
						d++;
					if (H[i] == 0)
						h++;
					if (C[i] == 0)
						c++;
				}
				System.out.println("#" + test_case + " " + s + " " + d + " " + h + " " + c);
			}
		}
		
		sc.close();
	}

}
