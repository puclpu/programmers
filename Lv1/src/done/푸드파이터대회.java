package done;

public class 푸드파이터대회 {

	public static void main(String[] args) {
		int[] food = {1, 3, 4, 6};
		FoodFighterContest ffc = new FoodFighterContest();
		String result = ffc.solution(food);
		System.out.println(result);
	}

}

class FoodFighterContest {
	public String solution(int[] food) {
		String answer="";
		String left = "";
		String right = "";
		
		for (int i = 1; i < food.length; i++) {
			for (int j = 0; j < food[i]/2; j++) {
				left += i;
				right = i + right;
			}
		}
		
		answer = left + "0" + right;
		
		return answer;
	}
}