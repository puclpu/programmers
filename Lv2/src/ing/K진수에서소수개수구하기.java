package ing;

public class K진수에서소수개수구하기 {

	public static void main(String[] args) {
		FindPrimeInKNumber fpk = new FindPrimeInKNumber();
		int result = fpk.solution(437674, 3);
		System.out.println(result);
//		int result2 = fpk.solution(110011, 10);
//		System.out.println(result2);
	}

}

class FindPrimeInKNumber {
	public int solution(int n, int k) {
int answer = 0;
        
        // k진수로 바꾸기
        String nk = NtoK(n, k);
//        System.out.println(nk);
        
        // 조건에 맞는 P 찾기
        int i = 0;
        while (i < nk.length()) {
        	if (nk.charAt(i) == '0') { // charAt(i)가 0이라면 다음으로 넘어가기
				i++;
        		continue;
        	}
        	int j;
        	for (j = i; j < nk.length(); j++) {
				if (nk.charAt(j) == '0') {
					break;
				}
			}
        	String sub_nk = nk.substring(i, j);
        	i = j;
        	if (sub_nk.equals("1")) {
        		continue;
        	}
			
			// 소수 개수 찾기
			long lnk = Long.parseLong(sub_nk);
			if (isPrime(lnk)) {
				answer++;
			}
        }
        
        return answer;
	}

	private boolean isPrime(long n) {

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	private String NtoK(int n, int k) { // n을 k진수로 바꾸기
		String nk = "";
		StringBuilder sb = new StringBuilder();

		while (n != 0) {
			sb.insert(0, n % k);
			n = n / k;
		}

		nk = sb.toString();

		return nk;
	}
}