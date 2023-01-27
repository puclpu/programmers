package done;

public class 소수찾기 {

	public static void main(String[] args) {
		int n = 5;
		findPrime fp = new findPrime();
		int result = fp.solution(n);
		System.out.print(result);
	}

}

class findPrime {
	public int solution(int n) {
        int answer = 0;
        
        // 소수 갯수
        for (int i=2; i<=n; i++) {
        	if (isPrime(i)) {
        		answer++;
        		System.out.print(i + " ");
        	}
        }
        
        return answer;
    }
	
	// 소수 판별 메서드
	public boolean isPrime(int num) {
		for (int i=2; i*i<=num; i++ ) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}