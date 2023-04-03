package ing;

import java.util.Stack;

public class 주식가격 {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
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
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0);
        
        for (int i = 1; i < len; i++) {
        	if (!stack.isEmpty()) {
				while (prices[stack.peek()] > prices[i]) {					
					answer[stack.peek()] = i - stack.peek();
					stack.pop();
				}
			}
        	stack.push(i);
		}
        
        while(!stack.isEmpty()) {
        	answer[stack.peek()] = len - 1 - stack.peek();
        	stack.pop();
        }
        
        return answer;
    }
}