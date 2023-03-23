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
			if (num % 2 == 0) { // 짝수일 경우
				answer[i] = num + 1;
			} else { // 홀수일 경우
				String num_bit = num_to_bit(num);
				boolean onlyone = true;
				int j;
				for (j = num_bit.length()-1; j >= 0; j--) {
					if (num_bit.charAt(j) != '1') {
						onlyone = false;
						break;
					}
				}
				
				if (onlyone) { // num_bit가 1로만 이루어진 홀수
					String bits = "10" + num_bit.substring(1, num_bit.length());
					answer[i] = bit_to_num(bits);
				} else { // 0과 1이 섞인 홀수
					StringBuilder sb = new StringBuilder(num_bit);
					sb.setCharAt(j, '1');
					sb.setCharAt(num_bit.length()-1, '0');
					answer[i] = bit_to_num(sb.toString());
				}
			}
		}
        
        return answer;
    }
    private long bit_to_num(String bits) {
    	long num = 0;
    	long mul = 1;
    	
    	for (int i = bits.length()-1; i >= 0; i--) {
    		if (bits.charAt(i) == '1') {
    			num += mul;
    		}
    		mul = mul * 2;
		}
    	
    	return num;
    }
    
    private String num_to_bit(long num) {
    	String bit = "";
    	
    	while(num != 0) {
    		bit = num % 2 + bit;
    		num = num / 2;
    	}
    	
    	return bit;
    }
//    private boolean find_different_bits(String num, String tar) { // 다른 비트 수가 2개 이하인지 판별
//    	
//    	if (tar.length() > num.length()) {
//    		for (int i = 0; i < tar.length() - num.length(); i++) {
//				num = "0" + num;
//			}
//    	}
//    	
//    	int dif_bits = 0;
//    	
//    	for (int i = 0; i < tar.length(); i++) {
//			if (tar.charAt(i) != num.charAt(i))
//				dif_bits++;
//			
//			if (dif_bits > 2)
//				return false;
//		}
//    	
//    	return true;
//    }
    
}