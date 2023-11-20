package sappy_pr;

import java.util.HashSet;
import java.util.Scanner;

public class No8821 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			String str = sc.next();
			HashSet<Integer> note = new HashSet<>();
			for (int i = 0; i < str.length(); i++) {
				int num = str.charAt(i) - '0';
				if (!note.isEmpty() && note.contains(num)) {
					note.remove(num);
				} else {
					note.add(num);
				}
			}
			System.out.println("#"+test_case+" "+note.size());
		}

	}

}
