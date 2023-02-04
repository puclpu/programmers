package done;

import java.util.Arrays;

public class 과일장수 {

	public static void main(String[] args) {
		int k = 4;
		int m = 3;
		int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
		FruitSeller fs = new FruitSeller();
		int result = fs.solution(k, m, score);
		System.out.println(result);
	}

}
class FruitSeller {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(score);
        
        // 각 상자의 최소 점수와 이익계산
        int n = score.length- m;
        while(n >= 0) {
        	answer += score[n] * m;
        	n = n - m;
        }
        
        return answer;
    }
}