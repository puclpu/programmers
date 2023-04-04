package toRetry;

public class 주식가격 {

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };
//		int[] prices = {1, 2, 3, 2, 3, 1};
		ThePriceOfStock pos = new ThePriceOfStock();
		int[] result = pos.solution(prices);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}

class ThePriceOfStock {
	public int[] solution(int[] prices) {
		int len = prices.length;

		int[] answer = new int[len];

		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len; j++) {
				answer[i]++;
				if (prices[i] > prices[j])
					break;
			}
		}

		return answer;
	}
}