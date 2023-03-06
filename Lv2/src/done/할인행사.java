package done;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {

	public static void main(String[] args) {
		String[] want = { "banana", "apple", "rice", "pork", "pot" };
		int[] number = { 3, 2, 2, 2, 1 };
		String[] discount = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
				"pot", "banana", "apple", "banana" };
//		String[] want = {"apple"};
//		int[] number = {10};
//		String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
		DiscountEvent de = new DiscountEvent();
		int result = de.solution(want, number, discount);
		System.out.println(result);
	}

}

class DiscountEvent {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < want.length; i++) {
			map.put(want[i], number[i]);
		}

		for (int i = 0; i <= discount.length - 10; i++) {
			for (int j = i; j < i + 10; j++) {
				if (map.containsKey(discount[j])) {
					map.put(discount[j], map.get(discount[j]) - 1);
				}
			}
			boolean find = true;
			for (int j = 0; j < want.length; j++) {
				if (map.get(want[j]) != 0) {
					find = false;
					break;
				}
			}
			if (find) {
				answer++;
			}
			for (int j = 0; j < want.length; j++) {
				map.put(want[j], number[j]);
			}
		}

		return answer;
	}
}