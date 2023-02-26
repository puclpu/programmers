package ing;

import java.util.PriorityQueue;

public class 프린터 {

	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		Printer pri = new Printer();
		int result = pri.solution(priorities, location);
		System.out.println(result);
	}

}
class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < priorities.length; i++) {
			queue.add(priorities[i]);
		}
        for (Integer integer : queue) {
			System.out.println(integer);
		}
        
        return answer;
    }
}