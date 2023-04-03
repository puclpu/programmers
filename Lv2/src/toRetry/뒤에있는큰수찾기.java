package toRetry;

import java.util.Stack;

public class 뒤에있는큰수찾기 {

	public static void main(String[] args) {
//		int[] numbers = {2, 3, 3, 5};
		int[] numbers = {9, 1, 5, 3, 6, 2};
		FindLargestNumberAfter flna = new FindLargestNumberAfter();
		int[] result = flna.solution(numbers);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
class FindLargestNumberAfter {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int i = 1; i < numbers.length; i++) {
			while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
				answer[stack.pop()] = numbers[i];
			}
			
			stack.push(i);
		}
        
        while (!stack.isEmpty()) {
        	answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}