package done;

import java.util.Arrays;

public class 숫자카드나누기 {

	public static void main(String[] args) {
//		int[] arrayA = {10, 17};
//		int[] arrayB = {5, 20};
//		int[] arrayA = {10, 20};
//		int[] arrayB = {5, 17};
		int[] arrayA = {14, 35, 119};
		int[] arrayB = {18, 30, 102};
		NumberCardDivision ncd = new NumberCardDivision();
		int result = ncd.solution(arrayA, arrayB);
		System.out.println(result);
	}

}
class NumberCardDivision {
	public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        // 1. arrayA의 모든 숫자를 나눌 수 있고, arrayB의 모든 숫자는 하나도 나눌 수 없는 수
        int A = mtc(arrayA, arrayB);
        // 2. arrayB의 모든 숫자를 나눌 수 있고, arrayB의 모든 숫자는 하나도 나눌 수 없는 수
        int B = mtc(arrayB, arrayA);
        
        if (A > B) {
        	answer = A;
        } else {
        	answer = B;
        }
        
        if (answer == 1)
        	answer = 0;

        return answer;
    }
	private int mtc(int[] A, int[] B) {
		int AB = 0;
		Arrays.sort(A);
		int AM = A[0];
		for (AB = AM; AB > 1; AB--) {
			if (all_division(A, AB) && all_not_division(B, AB)) {
				break;
			}
		}
		
		return AB;
	}
	private boolean all_division(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % target != 0)
				return false;
		}
		
		return true;
	}
	private boolean all_not_division(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % target == 0)
				return false;
		}
		
		return true;
	}
}