package sappy_pr;

import java.util.Scanner;

public class No6900 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			String[] target = new String[N];
			int[] money = new int[N];
			for (int i = 0; i < N; i++) {
				target[i] = sc.next();
				money[i] = sc.nextInt();
			}
			
			String[] number = new String[M];
			for (int i = 0; i < M; i++) {
				number[i] = sc.next();
			}
			
			int sum = 0;
			for (int i = 0; i < target.length; i++) {
				for (int j = 0; j < number.length; j++) {
					System.out.println(target[i] +" " + number[j]);
					boolean flag = true;
					for (int k = 0; k < 8; k++) {
						if (target[i].charAt(k) == '*') {
							continue;
						} else if (target[i].charAt(k) != number[j].charAt(k)) {
							flag = false;
						}
					}
					if (flag) {
						sum += money[i];
						break;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + sum);
			
		}
		
		sc.close();
	}

}
