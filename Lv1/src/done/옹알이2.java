package done;

public class 옹알이2 {

	public static void main(String[] args) {
		String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa", "wooyemawooye"};
		Babbling2 bb = new Babbling2();
		int result = bb.solution(babbling);
		System.out.println(result);
	}

}
class Babbling2 {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (int i = 0; i < babbling.length; i++) {
			// 발음할 수 있는 단어인지 판별
        	boolean pron = pronunciation(babbling[i]);
        	// 발음할 수 있는 단어는 answer++
        	if (pron) {
        		answer++;
        	}
		}
        
        return answer;
    }
    
    private boolean pronunciation(String str) {
    	str = str.replaceAll("aya", "A");
    	str = str.replaceAll("ye", "Y");
    	str = str.replaceAll("woo", "W");
    	str = str.replaceAll("ma", "M");
    	System.out.println(str);
    	
    	int count = 0;
    	char[] b = {'A', 'Y', 'W', 'M'};
    	for (int i = 0; i < str.length(); i++) {
    		for (int j = 0; j < b.length; j++) {
				if (str.charAt(i) == b[j]) {
					count++;
				}
			}
    	}
    	if (count != str.length()) {
    		return false;
    	}
    	
    	for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) { // 같은 발음 반복
				return false;
			}
		}
    	
    	return true;
    	
    }
//    	String[] arr = str.split("aya|ye|woo|ma");
//    	System.out.println(Arrays.toString(arr));
//    	if (arr.length == 0) {
//    		return true;
//    	}
//    	return false;
}