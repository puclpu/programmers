package done;

public class 로또의최고순위와최저순위 {

	public static void main(String[] args) {
		int[] lottos = { 0, 0, 0, 0, 0, 0 };
		int[] win_nums = { 38, 19, 20, 40, 15, 25 };
		LottoMaxMin lmm = new LottoMaxMin();
		int[] result = lmm.solution(lottos, win_nums);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}

class LottoMaxMin {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];

		// 식별 가능한 숫자 중 당첨된 숫자
		int count = 0;
		int zero = 0;
		for (int i = 0; i < lottos.length; i++) {
			if (lottos[i] == 0) {
				zero++;
			} else {
				for (int j = 0; j < win_nums.length; j++) {
					if (lottos[i] == win_nums[j]) {
						count++;
					}
				}
			}
		}

		// 최저 순위
		answer[1] = count > 1 ? 7 - count : 6;

		// 최고 순위
		answer[0] = (count + zero) > 1 ? 7 - (count + zero) : 6;

		return answer;
	}
}
//class LottoMaxMin {
//    public int[] solution(int[] lottos, int[] win_nums) {
//        int[] answer = new int[2];
//        
//        // 식별 가능한 숫자 중 당첨된 숫자
//        int count = 0;
//        int zero = 0;
//        for (int i = 0; i < lottos.length; i++) {
//        	if (lottos[i] == 0) {
//        		zero++;
//        	} else {
//        		for (int j = 0; j < win_nums.length; j++) {
//        			if (lottos[i] == win_nums[j]) {
//        				count++;
//        			}
//        		}
//        	}
//		}
//        
//        // 최저 순위
//        answer[1] = rank(count);
//        
//        // 최고 순위
//        answer[0] = rank(count + zero);
//        
//        return answer;
//    }
//    
//    private int rank(int count) {
//    	int r = 0;
//    	switch (count) {
//		case 0: case 1:
//			r = 6; 
//			break;
//		case 2:
//			r = 5; 
//			break;
//		case 3:
//			r = 4; 
//			break;
//		case 4:
//			r = 3; 
//			break;
//		case 5:
//			r = 2; 
//			break;
//		case 6:
//			r = 1; 
//			break;
//		}
//    	return r;
//    }
//}