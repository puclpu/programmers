package done;

import java.util.HashSet;
import java.util.LinkedList;

public class 전력망을둘로나누기 {

	public static void main(String[] args) {
//		int n = 9;
//		int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
//		int n = 7;
//		int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
		int n = 4;
		int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
//		int n = 6;
//		int[][] wires = {{1, 4}, {6, 3}, {2, 5}, {5, 1}, {5, 3}};
		TwoPowerGrids tpg = new TwoPowerGrids();
		int result  = tpg.solution(n, wires);
		System.out.println(result);
	}

}
class TwoPowerGrids {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        int min = n;
        for (int i = 0; i < wires.length; i++) {
			int vmv = v1_minus_v2(i, wires);
			if (vmv < min)
				min = vmv;
		}
        
        answer = min;
        
        return answer;
    }
    
    private int v1_minus_v2(int except, int[][] wires) {
    	int vmv = 0;
    	
    	HashSet<Integer> set1 = new HashSet<>();
    	HashSet<Integer> set2 = new HashSet<>();
    	set1.add(wires[except][0]);
    	set2.add(wires[except][1]);
    	
    	LinkedList<String> queue = new LinkedList<>();
    	for (int i = 0; i < wires.length; i++) {
			if (i == except)
				continue;
			queue.add(wires[i][0] + " " + wires[i][1]);
		}
    	
    	while(!queue.isEmpty()) {
    		String tar = queue.poll();
    		String[] arr_tar = tar.split(" ");
    		int[] itar = new int[2];
    		for (int i = 0; i < itar.length; i++) {
				itar[i] = Integer.parseInt(arr_tar[i]);
			}
    		
    		if (set1.contains(itar[0]) || set1.contains(itar[1])) {
    			set1.add(itar[0]);
    			set1.add(itar[1]);
    		} else if (set2.contains(itar[0]) || set2.contains(itar[1])) {
    			set2.add(itar[0]);
    			set2.add(itar[1]);
    		} else {
    			queue.add(tar);
    		}
    	}
    	
    	vmv = set1.size() - set2.size();
    	if (vmv < 0)
    		vmv *= -1;
    	
    	return vmv;
    }
}