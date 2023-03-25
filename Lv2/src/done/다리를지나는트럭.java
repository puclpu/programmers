package done;

import java.util.LinkedList;

public class 다리를지나는트럭 {
	public static void main(String args[]) {
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		TrucksOnBridge tb = new TrucksOnBridge();
		int result = tb.solution(100, 100, truck_weights);
		System.out.println(result);
	}
}
class TrucksOnBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
			list.add(truck_weights[i]);
		}
        
        int[] bridge = new int[bridge_length];
        
        int sec = 0;
        int remove = 0;
        
        while(remove != truck_weights.length) {
        	sec++;

        	if (bridge[bridge.length - 1] != 0) {
        		remove++;
        	}
        	
        	int sum = 0;
        	for (int i = bridge.length-1; i > 0; i--) {
				bridge[i] = bridge[i-1];
				sum += bridge[i];
			}
        	if (list.size() > 0) {        		
        		if (sum + list.getFirst() > weight) {
        			bridge[0] = 0;
        		} else {
        			bridge[0] = list.getFirst();
        			list.removeFirst();
        		}
        	}
        	
        }
        
        answer = sec;
        
        return answer;
    }
}