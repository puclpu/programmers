package done;

public class 소수만들기 {

	public static void main(String[] args) {
		int[] nums = {1, 2, 7, 6, 4};
		MakePrime mp = new MakePrime();
		int result = mp.solution(nums);
		System.out.println(result);
	}

}

class MakePrime {
    public int solution(int[] nums) {
        int answer = 0;
        
        for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				for (int k = j+1; k < nums.length; k++) {
					if ( isPrime(nums[i] + nums[j] + nums[k]) ) {
						answer++;
					}
				}
			}
		}

        return answer;
    }
    
    public boolean isPrime(int n) {
    	for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
    	return true;
    }
}