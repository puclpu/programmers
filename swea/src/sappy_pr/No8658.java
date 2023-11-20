package sappy_pr;

import java.util.Scanner;

public class No8658 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			int[] num = new int[10];
			for (int i = 0; i < num.length; i++) {
				num[i] = sc.nextInt();
			}
			
			// process
			int max = 0, min = 0;
			for (int i = 0; i < num.length; i++) {
				String sn = num[i] + "";
				int sum = 0;
				for (int j = 0; j < sn.length(); j++) {
					sum += (sn.charAt(j) - '0');
				}
				if (max == 0) {
					max = sum;
					min = sum;
				}
				if (sum > max)
					max = sum;
				if (sum < min)
					min = sum;
			}
			
			// output
			System.out.println("#"+test_case+" "+max+" "+min);
		}
	}

}
