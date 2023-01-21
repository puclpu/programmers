package done;

public class 크기가작은부분문자열 {

	public static void main(String[] args) {
		Lengthdiffstr s = new Lengthdiffstr();
		String t = "10203";
		String p = "15";
		int answer = s.solution(t, p);
		System.out.println(answer);
	}

}

class Lengthdiffstr {
	public int solution(String t, String p) {
        int answer = 0;
        Long plong = Long.parseLong(p);
        
        //p의 길이 len 저장
        int len = p.length();
        for (int i = 0; i < t.length() - len + 1; i++) {
			String sub = t.substring(i, i + len);
			Long sublong = Long.parseLong(sub);
			if (sublong <= plong) {
				answer++;
			}
		}
        
        return answer;
    }
}