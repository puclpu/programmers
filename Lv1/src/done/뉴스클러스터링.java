package done;

import java.util.ArrayList;

public class 뉴스클러스터링 {

	public static void main(String[] args) {
		NewsClustering nc = new NewsClustering();
		int result = nc.solution("FRANCE", "french");
		System.out.println("FRANCE " + "french " + result);
		int result2 = nc.solution("handshake", "shake hands");
		System.out.println("handshake " + "shake hands " + result2);
		int result3 = nc.solution("aa1+aa2", "AAAA12");
		System.out.println("aa1+aa2 " + "AAAA12 " + result3);
		int result4 = nc.solution("E=M*C^2", "e=m*c^2");
		System.out.println("E=M*C^2 " + "e=m*c^2 " + result4);
	}

}
class NewsClustering {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        if (str1.equalsIgnoreCase(str2))
        	return 65536;
        
        ArrayList<String> s1 = str_to_two(str1);
        ArrayList<String> s2 = str_to_two(str2);
        
        ArrayList<String> intersection = new ArrayList<>();
        for (int i = 0; i < s1.size(); i++) {
			for (int j = 0; j < s2.size(); j++) {
				if (s1.get(i).equalsIgnoreCase(s2.get(j))) {
					intersection.add(s1.get(i));
					s2.remove(j);
					break;
				}
			}
		}
        for (int i = 0; i < intersection.size(); i++) {
			s1.remove(intersection.get(i));
		}
        
        // 유사도 계산
        int sum = s1.size() + s2.size() + intersection.size();
        double similarity = intersection.size() / (double)sum;
        
        answer = (int)(similarity * 65536);
        
        return answer;
    }
    
    private ArrayList<String> str_to_two(String str) {
    	ArrayList<String> list = new ArrayList<>();
    	for (int i = 0; i < str.length()-1; i++) {
			String tw = str.substring(i, i + 2);
			char first = tw.charAt(0);
			char second = tw.charAt(1);
			if (first > 64 && first < 91 || first > 96 && first < 123) {
				if (second > 64 && second < 91 || second > 96 && second < 123) {
					list.add(tw); // A(65) - Z(90), a(97) - z(122) 사이의 알파벳으로 이루어진 문자만 list에 add
				}
			}
		}
    	return list;
    }
}