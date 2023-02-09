package done;

import java.util.Arrays;

public class 숫자짝꿍 {

	public static void main(String[] args) {
		String x = "100";
		String y = "203045";
		NumberPair np = new NumberPair();
		String result = np.solution(x, y);
		System.out.println(result);
	}

}

class NumberPair {
	public String solution(String X, String Y) {
		String answer = "";
		
		int[] x = new int[10];
		for (int i = 0; i < X.length(); i++) {
			x[X.charAt(i) - '0']++;
		}
		int[] y = new int[10];
		for (int i = 0; i < Y.length(); i++) {
			y[Y.charAt(i) - '0']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 9; i >= 0; i--) {
			if(x[i] > 0 && y[i] > 0) {
				if (x[i] < y[i]) {
					for (int j = 0; j < x[i]; j++) {
						sb.append(i + "");
					}
				} else {
					for (int j = 0; j < y[i]; j++) {
						sb.append(i + "");
					}
				}
			}
		}
		
		answer = sb.toString();
		if ("".equals(answer)) {
			answer = "-1";
		} else if (answer.charAt(0) == '0') {
			answer = "0";
		}
		
		return answer;
	}
	public String solution2(String X, String Y) {
		String answer = "";
		StringBuilder pair = new StringBuilder();
		
		char[] x = X.toCharArray();
		char[] y = Y.toCharArray();
		
		// 숫자 짝꿍 찾기
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y.length; j++) {
				if (x[i] == y[j]) {
					y[j] = 'n';
					pair.append(x[i]);
					break;
				}
			}
		}
		
		// 찾은 짝꿍 숫자 int 배열로 변환
		if (pair.length() == 0) {
			answer = "-1";
		} else {
			int[] s = new int[pair.length()];
			for (int i = 0; i < pair.length(); i++) {
				String st = String.valueOf(pair.charAt(i));
				s[i] = Integer.parseInt(st);
			}
			
			// 만들 수 있는 가장 큰 정수
			Arrays.sort(s);
			StringBuilder ans = new StringBuilder();
			if (s[0] == 0 && s[s.length - 1] == 0) {
				answer = "0";
			} else {
				for (int i = s.length-1; i >= 0; i--) {
					ans.append(s[i]);
				}
				answer = ans.toString();
			}
			
		}
		
		return answer;
	}
}