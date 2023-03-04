package ing;

import java.util.PriorityQueue;

public class 더맵게 {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		MoreSpicy ms = new MoreSpicy();
		int result = ms.solution(scoville, K);
		System.out.println(result);
	}

}
class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}
        
        
        return answer;
    }
}