package ing;

import java.util.HashSet;
import java.util.Iterator;

public class 소수찾기 {

	public static void main(String[] args) {
		FindPrimeNumber fpn = new FindPrimeNumber();
		int result = fpn.solution("17");
		int result2 = fpn.solution("011");
		System.out.println(result);
		System.out.println(result2);
	}

}
class FindPrimeNumber {
	HashSet<Integer> set;

	public int solution(String numbers) {
        int answer = 0;
        
        set = new HashSet<>();
        combination("", numbers);
        
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
        	int n = iter.next();
			if (isPrime(n))
				answer++;
		}
        
        return answer;
    }
	
	private boolean isPrime(int n) {
		if (n == 0 || n == 1)
			return false;
		
		for (int i = 2; i * i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
    
    private void combination(String now, String left) {
    	if (!now.equals("")) {
    		set.add(Integer.parseInt(now)); // 현재 조합을 set에 추가
    	}
    	
    	for (int i = 0; i < left.length(); i++) {
			if(!now.equals("")) {
				set.add(Integer.valueOf(now));
			}
			combination(now + left.charAt(i), left.substring(0,i) + left.substring(i+1));
		}
    }
}