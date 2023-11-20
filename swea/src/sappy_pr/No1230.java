package sappy_pr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No1230 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		LinkedList<String> queue = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk; // 원본 암호문

		for(int test_case = 1; test_case <= T; test_case++)
		{
			queue.clear();
			// input
			br.readLine(); // 원본 암호문 길이
			stk = new StringTokenizer(br.readLine(), " ");
			while(stk.hasMoreTokens()) {
				queue.add(stk.nextToken());
			}
			
			br.readLine();
			stk = new StringTokenizer(br.readLine(), " ");
			// process
			while(stk.hasMoreTokens()) {
				int x, y;
				switch(stk.nextToken()) {
				case "I" : 
					x = Integer.parseInt(stk.nextToken());
					y = Integer.parseInt(stk.nextToken());
					for (int i = 0; i < y; i++) {
						queue.add(x++, stk.nextToken());
					}
					break;
				case "D" : 
					x = Integer.parseInt(stk.nextToken());
					y = Integer.parseInt(stk.nextToken());
					for (int i = 0; i < y; i++) {
						queue.remove(x);
					}
					break;
				case "A" : 
					y = Integer.parseInt(stk.nextToken());
					for (int i = 0; i < y; i++) {
						queue.add(stk.nextToken());
					}
					break;
				}
			}
			
			// output
			System.out.print("#"+test_case);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + queue.pop());
			}
			System.out.println();
		}

	}

}
