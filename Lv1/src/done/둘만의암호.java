package done;

public class 둘만의암호 {

	public static void main(String[] args) {
		OurOwnCode ooc = new OurOwnCode();
		String result1 = ooc.solution("aukks", "wbqd", 5);
		System.out.println(result1);
	}

}
class OurOwnCode {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        // 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꾸기
        for (int i = 0; i < s.length(); i++) {
			char target = s.charAt(i);
			
			int count = 0;
			while(count < index) {
				target = (char)(target + 1);
				if (target > 'z') {
					target -= 26;
				}
				
				boolean sk = true;
				for (int j = 0; j < skip.length(); j++) {
					if (target == skip.charAt(j)) {
						sk = false;
						break;
					}
				}
				if (sk) {
					count++;
				}
			}
			sb.append(target);
		}
        
        answer = sb.toString();
        
        return answer;
    }
}