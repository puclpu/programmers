package done;

public class 다트게임 {

	public static void main(String[] args) {
		String dartResult = "1T2D3D#";
		DartGame dg = new DartGame();
		int result = dg.solution(dartResult);
		System.out.println(result);
	}

}
class DartGame {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        int n = 0;
        int num = 0;
        for (int i = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);

			// 숫자 판별
			if (c >= '0' && c <= '9') {
				int ic = Integer.parseInt(String.valueOf(c));
				if (ic == 0 && num > 0) {
					score[n] = num * 10 + ic;
				} else {
					num = ic;
					score[n] = ic;
				}
			}
			
			// S, D, T 판별
			if (c == 'S' || c == 'D' || c == 'T') {
				num = 0;
				if (c == 'D') {
					score[n] = score[n] * score[n];
				} else if (c == 'T' ) {
					score[n] = score[n] * score[n] * score[n];
				}
				n++;
			}
			
			// *, # 판별
			if (c == '*') {
				if (n == 1) {
					score[0] = score[0] * 2;
				} else {
					score[n-2] = score[n-2] * 2;
					score[n-1] = score[n-1] * 2;
				}
			} else if (c == '#') {
				score[n-1] = (-1) * score[n-1];
			}
		}
        // 점수 총합
        for (int i = 0; i < score.length; i++) {
        	answer += score[i];
        }
        
        return answer;
    }
}