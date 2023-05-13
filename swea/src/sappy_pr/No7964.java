package sappy_pr;

import java.util.Scanner;

public class No7964 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int count = 0;
			int N = sc.nextInt();
			int D = sc.nextInt();

			int[] gate = new int[N];
			for (int i = 0; i < N; i++) {
				gate[i] = sc.nextInt();
			}

			int exist = -1;
			for (int i = 0; i < N; i++) {
				if (gate[i] == 1) {
					exist = i;
				} else if (exist + D == i) {
					exist = i;
					count++;
					gate[i] = 1;

				}
			}
			System.out.println("#" + test_case + " " + count);
			for (int i = 0; i < gate.length; i++) {
				System.out.print(gate[i]);
			}
		}

		sc.close();
	}

}
