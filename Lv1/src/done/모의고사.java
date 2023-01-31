package done;

public class 모의고사 {

	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5 };
		MockTest mock = new MockTest();
		int[] result = mock.solution(answers);
		for (int i : result) {
			System.out.println(i);
		}
	}

}

class MockTest {
	public int[] solution(int[] answers) {

		int[][] supoja = {
				{ 1, 2, 3, 4, 5 }, 
				{ 2, 1, 2, 3, 2, 4, 2, 5 }, 
				{ 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
			};

		int[] corr = new int[3];
		for (int i = 0; i < supoja.length; i++) {
			for (int j = 0; j < answers.length; j++) {
				if (answers[j] == supoja[i][j % supoja[i].length]) {
					corr[i]++;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < corr.length; i++) {
			if(corr[i] > max)
				max = corr[i];
		}

		int corrP = 0;
		for (int i = 0; i < corr.length; i++) {
			if (corr[i] == max)
				corrP++;
		}
		
		int[] answer = new int[corrP];
		int n = 0;
		for (int i = 0; i < corr.length; i++) {
			if (corr[i] == max)
				answer[n++] = i + 1;
		}
		
		return answer;
	}
}