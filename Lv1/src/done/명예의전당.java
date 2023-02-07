package done;

import java.util.ArrayList;
import java.util.Collections;

public class 명예의전당 {

	public static void main(String[] args) {
		int k = 4;
		int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
		HallOfFame hf = new HallOfFame();
		int[] result = hf.solution(k, score);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
class HallOfFame {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        ArrayList<Integer> fame = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
			if (fame.size() < k) {
				fame.add(score[i]);
				Collections.sort(fame);
				answer[i] = fame.get(0);
			} else if (fame.size() == k) {
				fame.add(score[i]);
				Collections.sort(fame);
				fame.remove(0);
				answer[i] = fame.get(0);
			}
			
		}
        
        return answer;
    }
}