package done;

public class 문자열압축 {

	public static void main(String[] args) {
//		String s = "aabbaccc";
//		String s = "abcabcabcabcdededededede";
		String s = "xababcdcdababcdcd";
		StringCompression sc = new StringCompression();
		int result = sc.solution(s);
		System.out.println(result);
	}

}
class StringCompression {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i = s.length() / 2; i > 0; i--) { // 자를 문자열 단위
        	StringBuilder sb = new StringBuilder();
        	String before = "";
        	int count = 1;
        	int j = 0;
        	for (; j + i <= s.length(); j = j + i) {
				String str = s.substring(j, j + i);
//				System.out.println(j + " " + str);
				if (str.compareTo(before) != 0) { // 이전과 새로운 단어를 만났을 경우
					if (count > 1) // 한번만 나타난 경우 1은 생략
						sb.append(count); // 반복되는 값 추가
					sb.append(before); // 이전 단어 추가
					before = str; // 새로운 단어를 이전 단어로 저장
					count = 1; // count를 1로 초기화
				} else {
					count++; // 새로운 단어가 아니라면 count++
				}
			}
        	if (count > 1)
        		sb.append(count);
        	sb.append(s.substring(j - i));
//        	System.out.println(sb.toString());
        	int len = sb.toString().length();
        	if (answer > len)
        		answer = len;
		}
        
        return answer;
    }
}