package done;

import java.util.HashMap;
import java.util.HashSet;
//import java.util.Iterator;
import java.util.Map;

public class 신고결과받기 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		ReceiveReportResult rrr = new ReceiveReportResult();
		int[] result = rrr.solution(id_list, report, k);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
class ReceiveReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, HashSet<String>> map = new HashMap<>(); // 신고당한 아이디, 신고한 아이디들
        for (int i = 0; i < id_list.length; i++) {
        	HashSet<String> set = new HashSet<String>();
        	map.put(id_list[i], set);
        }
        
        for (int i = 0; i < report.length; i++) {
			String[] RIDs = report[i].split(" ");
			map.get(RIDs[1]).add(RIDs[0]);
		}
        
//        for (int i = 0; i < id_list.length; i++) {
//        	System.out.println("<" + id_list[i] + ">");
//			Iterator<String> iter = map.get(id_list[i]).iterator();
//			while(iter.hasNext()) {
//				System.out.print(iter.next() + " ");
//			}
//			System.out.println();
//		}
        
        for (int i = 0; i < id_list.length; i++) {
			if (map.get(id_list[i]).size() >= k) { // 해당 아이디를 신고한 id가 k개 이상이면 정지
				for (int j = 0; j < id_list.length; j++) {
					if (map.get(id_list[i]).contains(id_list[j])) {
						answer[j]++;
					}
				}
			}
		}
        
        return answer;
    }
}