package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class 메뉴리뉴얼 {

	public static void main(String[] args) {
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] corse = {2, 3, 4};
//		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//		int[] corse = {2, 3, 5};
//		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//		int[] corse = {2, 3, 4};
		
		MenuRenewal mr = new MenuRenewal();
		String[] result = mr.solution(orders, corse);
		
		for (String string : result) {
			System.out.println(string + " result");
		}
	}

}
class MenuRenewal {
	
	HashSet<String> set;
	int[] n;
	
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        
        HashMap<String, Integer> count = new HashMap<>();
        n = course;
        
        int[] c_max = new int[course.length];

        // 조합 찾기
        for (String order : orders) {
//        	System.out.println("--");
			set = new HashSet<>();
			
			char[] c_order = order.toCharArray();
			Arrays.sort(c_order);
        	find_combi(c_order, 0, "");

        	// 찾은 조합 count에 저장
        	Iterator<String> iter = set.iterator();
        	while(iter.hasNext()) {
        		String tar = iter.next();
//        		System.out.println(tar + " tar");
        		if (count.containsKey(tar)) {
        			count.put(tar, count.get(tar) + 1);
        		} else {
        			count.put(tar, 1);
        		}
        		
        		for (int i = 0; i < c_max.length; i++) {
					if (tar.length() == course[i]) {
						if (count.get(tar) > c_max[i]) {
							c_max[i] = count.get(tar);
						} else {
							break;
						}
					}
				}
        	}
		}
        
//        for (int i = 0; i < c_max.length; i++) {
//			 System.out.println(course[i] + " : " + c_max[i]);
//		}
        
        ArrayList<String> list = new ArrayList<>();

        for (Entry<String, Integer> entryset : count.entrySet()) {
//			System.out.println(entryset.getKey() + " " + entryset.getValue());
			for (int i = 0; i < c_max.length; i++) {
				if (entryset.getKey().length() == course[i] && entryset.getValue() == c_max[i] && c_max[i] != 1) {
					list.add(entryset.getKey());
				}
			}
		}
              
        answer = list.toArray(new String[0]);
        // 오름차순 정렬
        Arrays.sort(answer);
        
        return answer;
    }
    
    private void find_combi(char[] c_order, int depth, String combi) {
//    	System.out.println(combi + " combi");
    	// combi의 length가 course의 수와 일치하면 set에 저장
    	for (int i : n) {
			if (combi.length() == i) {
				set.add(combi);
				break;
			}
		}
    	
    	if (depth == c_order.length) { // depth가 order의 length과 같다면 종료
    		return;
    	} else {
    		
    		find_combi(c_order, depth + 1, combi); //depth번째의 char를 더하지 않은 조합
    		
    		combi = combi.concat(c_order[depth] + ""); // depth번째의 char를 더한 조합
    		find_combi(c_order, depth + 1, combi);
    	}
    }
}