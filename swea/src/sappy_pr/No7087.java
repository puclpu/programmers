package sappy_pr;

import java.util.HashMap;
import java.util.Scanner;

public class No7087 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			HashMap<String, Character> map = new HashMap<>();
			for (int i = 0; i < N; i++) {
				String title = sc.next();
				map.put(title, title.charAt(0));
			}
			
			char F = 'A';
			int count = 0;
			for (int i = 0; i < map.size(); i++) {
				if (map.containsValue(F)) {
					count++;
					F++;
				} else {
					break;
				}
			}
			
			System.out.println("#" + test_case + " " + count);
		}
		
		sc.close();
	}

}
