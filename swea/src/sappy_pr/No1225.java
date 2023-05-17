package sappy_pr;

import java.util.LinkedList;
import java.util.Scanner;

public class No1225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();
			LinkedList<Integer> queue = new LinkedList<>();
			
			for (int i = 0; i < 8; i++) {
				int n = sc.nextInt();
				queue.add(n);
			}
			
			int minus = 1;
			while(true) {
				int n = queue.poll();
				n -= minus++;
				
				if (n <= 0) {
					queue.add(0);
					break;
				} else {
					queue.add(n);
				}				
				
				if (minus > 5)
					minus = 1;
			}
			System.out.print("#"+tc);
			for (Integer i : queue) {
				System.out.print(" " + i);
			}
			System.out.println();
		}
		
		sc.close();
	}

}
