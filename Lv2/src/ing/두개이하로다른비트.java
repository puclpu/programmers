package ing;

public class 두개이하로다른비트 {

	public static void main(String[] args) {
		NoMoreThanTwoDifferentBits nmttdb = new NoMoreThanTwoDifferentBits();
		long[] numbers = {2, 7};
		long[] result = nmttdb.solution(numbers);
		for (long l : result) {
			System.out.println(l);
		}
	}

}
class NoMoreThanTwoDifferentBits {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        // x보다 크고, x와 비트가 1~2개 다른 수 들 중에서 제일 작은 수
        // numbers에 담긴 수에 대한 f값을 배열에 담아 return
        
        for (int i = 0; i < numbers.length; i++) {
			long num = numbers[i];
			String num_bin = num_to_bin(num); // 2진수로 변환
			boolean find = false; // f을 값을 찾을 때까지
			long target = num ;
			while(!find) { // 반복문 돌림
				target++;
				String tar_bin = num_to_bin(target);
				find = find_different_bits(num_bin, tar_bin);
			}
			answer[i] = target;
		}
        
        return answer;
    }
    private boolean find_different_bits(String num, String tar) { // 다른 비트 수가 2개 이하인지 판별
    	
    	if (tar.length() > num.length()) {
    		for (int i = 0; i < tar.length() - num.length(); i++) {
				num = "0" + num;
			}
    	}
    	
    	int dif_bits = 0;
    	
    	for (int i = 0; i < tar.length(); i++) {
			if (tar.charAt(i) != num.charAt(i))
				dif_bits++;
			
			if (dif_bits > 2)
				return false;
		}
    	
    	return true;
    }
    
    private String num_to_bin(long num) {
    	String bin = "";
    	
    	while(num != 0) {
    		bin = num % 2 + bin;
    		num = num / 2;
    	}
    	
    	return bin;
    }
}