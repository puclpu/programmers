package done;

public class N진수게임 {

	public static void main(String[] args) {
		NNumberGame nng = new NNumberGame();
		String result = nng.solution(2, 4, 2, 1);
		System.out.println(result);
		String result2 = nng.solution(16, 16, 2, 1);
		System.out.println(result2);
		String result3 = nng.solution(16, 16, 2, 2);
		System.out.println(result3);
	}

}
class NNumberGame {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        int number = 0;
        while(sb.length() < t * m + p) {
        	sb.append(numberToN(n, number)); // number를 N진수로 변환한 것을 sb에 append
        	number++;
        }
        String fsn = sb.toString();
        
        for (int i = 0; i < t; i++) {
        	answer += fsn.charAt(i * m + p - 1); // 말해야 하는 순서의 숫자를 answer에 +
        }
        
        return answer;
    }
    
    private String numberToN(int n, int number) { // number를 n진수로 변환
    	String N = "";
    	StringBuilder sb = new StringBuilder();
    	char[] AF = {'A', 'B', 'C', 'D', 'E', 'F'};
    	
    	if (number == 0) // number가 0이라면 0 return
    		return "0";
    	
    	while(number != 0) {
    		int nn = number % n; // number를 n으로 나눈 나머지가
    		if (nn > 9) { // 10 이상 이라면
    			sb.insert(0, AF[nn%10]); // AF배열에 저장된 A~F를 찾아 sb에 insert
    		} else {
    			sb.insert(0, nn); // 10 미만이라면 나머지를 sb에 추가
    		}
    		number = number / n;
    	}
    	
    	N = sb.toString();
    	
    	return N;
    }
}