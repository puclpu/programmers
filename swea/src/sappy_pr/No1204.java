package sappy_pr;

import java.util.HashMap;
import java.util.Scanner;

public class No1204 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int mf = sc.nextInt();
			map.put(mf, 1);
			for (int i = 1; i < 1000; i++) {
				int n = sc.nextInt();
				if (map.containsKey(n)) {
					map.put(n, map.get(n)+1);
					if (map.get(n) > map.get(mf)) {
						mf = n;
					} else if (map.get(n) == map.get(mf)) {
						if (n > mf)
							mf = n;
					}
				} else {
					map.put(n, 1);
				}
			}
			
			System.out.println("#" + N + " " + mf);
		}
		
		sc.close();
	}

}
