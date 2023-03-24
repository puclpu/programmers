package toRetry;

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
				StringBuilder sb = new StringBuilder();
				String binaryString = Long.toBinaryString(num);
				if (!binaryString.contains("0")) {
					// 맨 앞을 10으로
					sb.append("10");
					// 나머지 자리수를 모두 1로
					sb.append(binaryString.substring(1).replace("0", "1"));
				} else {
					int lastIndex = binaryString.lastIndexOf("0");
					int firstIndex = binaryString.indexOf("1", lastIndex);
					
					// 마지막 0을 1로 수정
					sb.append(binaryString, 0, lastIndex).append("1");
					
					// 마지막 0 다음 1을 0으로 수정
					sb.append("0");
					
					// 그 다음 비트열
					sb.append(binaryString.substring(firstIndex+1));
				}
				answer[i] = Long.parseLong(sb.toString(), 2);
			}
		}
        
        return answer;
    }
}