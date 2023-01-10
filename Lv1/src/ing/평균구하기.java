package ing;

public class 평균구하기 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		Solution s = new Solution();
		double answer = s.solution(arr);
		System.out.println(answer);
	}

	
	
}

class Solution {
	public double solution(int[] arr) {
		double answer = 0;
		int n = arr.length;
		double sum = 0.0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		answer = sum/n;
		return answer;
	}
}