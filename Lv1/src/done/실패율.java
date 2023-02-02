package done;

public class 실패율 {

	public static void main(String[] args) {
		int N = 4;
		int[] stages = {4, 4, 4, 4, 4};
		FailRate fr = new FailRate();
		int[] result = fr.solution(N, stages);
		for (int i : result) {
			System.out.println(i);
		}
	}

}
class FailRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = i+1;
		}
        
        // 각 스테이지 도전자 수, 도달했으나 클리어하지 못한 사용자 
        int[][] cha = new int[N][2];
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < stages.length; j++) {
				
				if (stages[j] >= i+1) {
					cha[i][0]++;
					
					if(stages[j] == i+1)
						cha[i][1]++;
				}
			}
			System.out.println(cha[i][0] + " " + cha[i][1]);
		}
        
        // 실패율
        double[] rate = new double[N];
        for (int i = 0; i < cha.length; i++) {
			rate[i] = (double)cha[i][1] / cha[i][0];
			System.out.println(rate[i]);
		}
        
        // 정렬
        for (int i = rate.length-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (rate[i] > rate[j]) {
					double tmp = rate[i];
					rate[i] = rate[j];
					rate[j] = tmp;
					
					int atmp = answer[i];
					answer[i] = answer[j];
					answer[j] = atmp;
				} else if (rate[i] == rate[j] && answer[i] < answer[j]) {
					int atmp = answer[i];
					answer[i] = answer[j];
					answer[j] = atmp;
				}
			}
		}
        
        return answer;
    }
}