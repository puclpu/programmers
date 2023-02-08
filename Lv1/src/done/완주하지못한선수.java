package done;

import java.util.HashMap;

public class 완주하지못한선수 {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden", "leo"};
		String[] completion = {"eden", "kiki"};
		NotFinishPlayer nfp = new NotFinishPlayer();
		String result = nfp.solution(participant, completion);
		System.out.println(result);
	}

}
class NotFinishPlayer {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> race = new HashMap<>();
        
        // 참가자 명단
        for (int i = 0; i < participant.length; i++) {
			if (race.get(participant[i]) != null) {
				int n = race.get(participant[i]);
				race.put(participant[i], n + 1);
			} else {
				race.put(participant[i], 0);
			}
		}
        
        // 완주자 명단
        for (int i = 0; i < completion.length; i++) {
			race.put(completion[i], race.get(completion[i])-1);
		}
        
        // 완주하지 못한 선수
        for (int i = 0; i < participant.length; i++) {
			if(race.get(participant[i]) != -1 ) {
				answer = participant[i];
				break;
			}
		}
        
        return answer;
    }
}