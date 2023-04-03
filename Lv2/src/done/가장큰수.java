package done;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {

	public static void main(String[] args) {
//		int[] numbers = {6, 10, 2};
		int[] numbers = {3, 30, 34, 5, 9};
		BiggestNumber bn = new BiggestNumber();
		String result = bn.solution(numbers);
		System.out.println(result);
	}

}
class BiggestNumber {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] sn = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
			sn[i] = numbers[i] + "";
		}
        
        Arrays.sort(sn, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
        
        if (sn[0].equals("0"))
        	return "0";
        
        for (String s : sn) {
			answer += s;
		}
        
        return answer;
    }
}
