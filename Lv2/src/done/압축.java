package done;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 압축 {

	public static void main(String[] args) {
		Compress com = new Compress();
//		int[] result = com.solution("KAKAO");
//		int[] result = com.solution("TOBEORNOTTOBEORTOBEORNOT");
		int[] result = com.solution("ABABABABABABABAB");
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
class Compress {
    public int[] solution(String msg) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        
        // 길이가 1인 모든 단어를 포함하도록 사전을 초기화
        Map<Integer, String> dictionary = new HashMap<>();
        for (int i = 1; i < 27; i++) {
			char alphabet = (char)(i+64);
			dictionary.put(i, String.valueOf(alphabet));
		}
        
        while(!msg.equals("")) {
        	// 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다
        	for (int i = msg.length(); i > 0; i--) {
				String w = msg.substring(0, i); // 끝에서부터 자르기
//				System.out.println(w);
				if (dictionary.containsValue(w)) { // w가 dictionary에 존자한다면
					for (int j = 1; j <= dictionary.size(); j++) { // sub_msg를 value로 갖는 key를 찾아
						if (dictionary.get(j).equals(w)) {
//							System.out.println(w + "#" + j);
							list.add(j); // 색인 번호를 list에 저장
							break;
						}
					}
					msg = msg.substring(i, msg.length()); // 입력에서 w를 제거
					if (msg.length() > 0) { // 입력에서 처리되지 않은 다음 글자가 남아있다면, 사전에 등록
						dictionary.put(dictionary.size()+1, w+msg.charAt(0));
					}
					break;
				}
			}
        }
        
        answer = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
			answer[i] = integer;
			i++;
		}
        
        return answer;
    }
}