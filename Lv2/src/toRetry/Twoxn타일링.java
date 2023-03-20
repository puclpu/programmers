package toRetry;

public class Twoxn타일링 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TwoByNTailing { // 피보나치 수열 !!
    public int solution(int n) {
        int answer = 0;
        
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        
        for (int i = 2; i < n; i++) {
			int num = arr[i-1] + arr[i-2];
			arr[i] = num % 1000000007;
		}
        
        answer = arr[n-1];
        
        return answer;
    }
}