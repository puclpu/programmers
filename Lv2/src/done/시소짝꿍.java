package done;

import java.util.Arrays;
import java.util.HashMap;

public class 시소짝꿍 {

	public static void main(String[] args) {
		int[] weights = {100,180,360,100,270};
		SeesawPair sp = new SeesawPair();
		long result = sp.solution(weights);
		System.out.println(result);
	}

}
class SeesawPair {
    public long solution(int[] weights) {
        long answer = 0;
        
        // 탑승한 사람의 무게와 시소 축과 좌석 간의 거리의 곱이 같다면 짝꿍
        // 2, 3, 4
        // a * 2 = b * 4
        // a : b = 4 : 2
        // a / b = 4 / 2 = 2
        // 2 : 3, 2 : 4, 3 : 4
        // a / b = 2/3, 1/2, 3/4, 1
        
        
        
        Arrays.sort(weights);
        
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < weights.length; i++) {
			double a = weights[i] * 2.0 / 3.0;
			double b = weights[i] / 2.0;
			double c = weights[i] * 3.0 / 4.0;
			double d = weights[i] / 1.0;
			
			if (map.containsKey(a))
				answer += map.get(a);
			if (map.containsKey(b))
				answer += map.get(b);
			if (map.containsKey(c))
				answer += map.get(c);
			if (map.containsKey(d))
				answer += map.get(d);
			
			if (map.containsKey(weights[i]*1.0)) {
				map.put(weights[i]*1.0, map.get(weights[i]*1.0)+1);
			} else {
				map.put(weights[i]*1.0, 1);
			}
		}
        
        return answer;
    }
}