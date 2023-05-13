package sappy_pr;

import java.util.Scanner;

public class No10570 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int count = 0;

			for (int i = A; i <= B; i++) {
				String si = i + "";
				boolean flag = true;
				for (int j = 0; j < si.length() / 2; j++) {
					if (si.charAt(j) != si.charAt(si.length() - 1 - j))
						flag = false;
				}
				if (flag) {
                	double dsqrti = Math.sqrt(i);
                    int isqrti = (int)dsqrti;
                    if (dsqrti == isqrti ) {
						String sisqrti = isqrti + "";
                        for(int j = 0; j < sisqrti.length()/2; j++) {
                        	if (sisqrti.charAt(j) != sisqrti.charAt(sisqrti.length()-1-j)) {
                        		flag = false;
                        	}
                        }
                        if (flag) {
                        	count++;
                        }
                    }
                }
			}
			System.out.println("#" + test_case + " " + count);
		}

		sc.close();
	}

}
