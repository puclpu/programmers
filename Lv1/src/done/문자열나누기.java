package done;

public class 문자열나누기 {

	public static void main(String[] args) {
		StringDivision sd = new StringDivision();
		int result = sd.solution("banana");
		int result2 = sd.solution("abracadabra");
		int result3 = sd.solution("aaabbaccccabba");
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
	}

}
class StringDivision {
    public int solution(String s) {
        int answer = 0;
        
        while (true) {
        	s = sub(s);
        	answer++;
        	if (s.isEmpty()) { // 남은 부분이 없다면 종료
        		break;
        	}
        }
        
        return answer;
    }
    private String sub(String s) {
    	String str = "";
    	
    	char x = s.charAt(0);
    	
    	int y = 1; // x가 나온 횟수
        int n = 0; // x가 아닌 다른 글자들이 나온 횟수
        for (int i = 1; i < s.length()-1; i++) {
			if (s.charAt(i) == x) {
				y++;
			} else {
				n++;
			}
			if (y == n) { // 두 횟수가 같아지면, 멈추고 문자열을 분리
				str = s.substring(i + 1);
				break;
			}
		}
        
        // 더 이상 읽을 글자가 없다면, 지금까지 읽은 문자열을 분리
        return str;
    }
}