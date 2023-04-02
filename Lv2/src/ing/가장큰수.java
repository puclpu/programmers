package ing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 가장큰수 {

	public static void main(String[] args) {
		int[] numbers = {6, 10, 2};
		BiggestNumber bn = new BiggestNumber();
		String result = bn.solution(numbers);
		System.out.println(result);
	}

}
class BiggestNumber {
    public String solution(int[] numbers) {
        String answer = "";
        
        Map<Integer, String> map = new HashMap<>();
        int[] first = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
			String sn = numbers[i] + "";
			int fc = sn.charAt(0) - '0';
			map.put(fc, sn);
			first[i] = fc;
		}
        
        Arrays.sort(first);
        for (int i : first) {
			answer += map.get(i);
			System.out.println();
		}
        
        return answer;
    }
}
