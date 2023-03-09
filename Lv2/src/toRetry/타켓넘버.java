package toRetry;

public class 타켓넘버 {

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		TargetNumber tn = new TargetNumber();
		int result = tn.solution(numbers, target);
		System.out.println(result);
	}

}
class TargetNumber {
	int answer = 0;
	
	public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, target, 0);
        
        return answer;
    }
	
	public void dfs(int[] numbers, int depth, int target, int sum) {
		if (depth == numbers.length) {
			if (target == sum)
				answer++;
		} else {
			dfs(numbers, depth+1, target, sum+numbers[depth]);
			dfs(numbers, depth+1, target, sum-numbers[depth]);
		}
	}
}