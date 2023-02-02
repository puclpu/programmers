package done;

public class 가장가까운같은글자 {
	
	public static void main(String[] args) {
		String s = "banana";
		Nearestchar nc = new Nearestchar();
		int[] result = nc.solution(s);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}

class Nearestchar {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
			for (int j = i; j >= 0; j--) {
				if (s.charAt(i) == s.charAt(j) && answer[i] == 0) {
					answer[i] = i - j;
					
				}
			}
			if (answer[i] == 0) {
				answer[i] = -1;
			}
		}
        
        return answer;
    }
}