package sappy_pr;

import java.util.Scanner;

public class No1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			long answer = 0;
			
			int N = sc.nextInt();
			int[] price = new int[N];
			for (int i = 0; i < price.length; i++) {
				price[i] = sc.nextInt();
			}
			
			int max = price[price.length-1];
			for (int i = price.length-2; i >= 0; i--) {
				if (price[i] < max) {
					answer += max - price[i];
				} else {
					max = price[i];
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		sc.close();
	}

}
