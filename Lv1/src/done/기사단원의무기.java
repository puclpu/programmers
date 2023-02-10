package done;

public class 기사단원의무기 {

	public static void main(String[] args) {
		int number = 5;
		int limit = 3;
		int power = 2;
		KnightWeapon kw = new KnightWeapon();
		int result = kw.solution(number, limit, power);
		System.out.println(result);
	}

}
class KnightWeapon {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
			// i의 약수의 개수
        	int num = divisor_num(i);
        	
        	// 제한 수치 확인
        	if (num > limit) {
        		num = power;
        	}
        	
        	// 공격력 더하기
        	answer += num;
		}
        
        return answer;
    }
    
    public int divisor_num(int n) {
    	if (n == 1)
    		return 1;
    	
    	int m = 0;
    	for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				if (i * i != n) {
					m = m + 2;
				} else {
					m++;
				}
			}
		}
    	
    	return m;
    }
}