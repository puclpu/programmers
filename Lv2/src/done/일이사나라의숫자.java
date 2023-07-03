package done;

public class 일이사나라의숫자 {

	public static void main(String[] args) {
		OneTwoFourNumber otfn = new OneTwoFourNumber();
		for (int i = 19; i < 23; i++) {
			System.out.println("n : " + i);
			String result = otfn.solution(i);
			System.out.println("124 world : " + result);
			System.out.println();
		}
//		String result1 = otfn.solution(4);
//		String result = otfn.solution(39);
//		System.out.println(result1);
//		System.out.println(result);
	}

}
class OneTwoFourNumber {
	
	int arr[];
	int thr[];
	
	public OneTwoFourNumber() {
		arr = new int[16];
		thr = new int[16];
		arr[0] = 1;
		thr[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			thr[i] = thr[i-1] * 3;
			arr[i] = arr[i-1] + thr[i];
		}		
	}
	
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int idx = arr.length-1;
        for (; idx > 0 && arr[idx] > n; idx--) {
		}
        System.out.println("idx : " + idx);
        for (int i = idx; i > -1; i--) {
        	
        	int nm = n % 3;
        	if (nm == 1) {
        		sb.insert(0, '1');
        		n = n / 3;
        	} else if (nm == 2) {
        		sb.insert(0, '2');
        		n = n / 3;
        	} else if (nm == 0) {
        		sb.insert(0, '4');
        		n = n / 3;
        		n--;
        	}
		}
        
        answer = sb.toString();
        
        return answer;
    }
}