package sappy_pr;

import java.util.Arrays;
import java.util.Scanner;

public class No3307 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 2; test_case++) {
			int N = sc.nextInt();
			int[] boxs = new int[100];
 			for (int i = 0; i < boxs.length; i++) {
				boxs[i] = sc.nextInt();
			}
 			
 			for (int i = 0; i < N; i++) {
				Arrays.sort(boxs);
//				System.out.println(boxs[0] + " " + boxs[99]);
				boxs[0] = boxs[0] + 1;
				boxs[99] = boxs[99] - 1;
			}
 			
 			Arrays.sort(boxs);
 			int mm = boxs[99] - boxs[0];
 			System.out.println("#"+test_case+" "+mm);
		}
		
		sc.close();
	}
}
