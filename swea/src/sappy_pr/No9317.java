package sappy_pr;

import java.util.Scanner;

public class No9317 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// input
			int N = sc.nextInt();
			String haveto = sc.next();
			String did = sc.next();
			
			// process
			int cor = 0; // 맞게 받아 적은 문자의 개수
			for (int i = 0; i < N; i++) {
				if (did.charAt(i) == haveto.charAt(i))
					cor++;
			}
			
			// output
			System.out.println("#"+test_case+" "+cor);
		}
	}

}
