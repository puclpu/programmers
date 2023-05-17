package sappy_pr;

import java.util.HashMap;
import java.util.Scanner;

public class No1493 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			int max = p;
			if (max < q)
				max = q;
			
			int i = 1;
			int n = 1;
			HashMap<Integer, String> map = new HashMap<>();
			while(n <= max) {
				for (int x = i, y = 1; x > 0; x--, y++) {
					map.put(n++, x+","+y);
				}
				i++;
			}
			
			String pp = map.get(p);
			String qp = map.get(q);
			System.out.println(pp + " " + qp);
			
			int tx = (pp.charAt(0) - '0') + (qp.charAt(0) - '0');
			int ty = (pp.charAt(2) - '0') + (qp.charAt(2) - '0');
			System.out.println(tx + " " + ty);
			
			if (map.containsValue(tx+","+ty)) {
				for (int k = 1; k <= n; k++) {
					if (map.get(k).equals(tx+","+ty)) {
						System.out.println("#"+test_case+" "+k);
						break;
					}
				}
			} else {
				boolean flag = true;
				while(flag) {
					for (int x = i, y = 1; x > 0; x--, y++) {
						if(tx == x && ty == y) {
							System.out.println("#"+test_case+" "+ n);
							flag = false;
							break;
						} else {
							n++;
						}
					}
					i++;
				}
			}
			
		}
		
		sc.close();
	}

}
