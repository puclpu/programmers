package toRetry;

import java.util.ArrayList;

public class 하노이의탑 {

	public static void main(String[] args) {
		int n = 2;
		TowerOfHanoi toh = new TowerOfHanoi();
		int[][] result = toh.solution(n);
	}

}
class TowerOfHanoi {
	ArrayList<int[]> list;
	public int[][] solution(int n) {
        
		list = new ArrayList<>();
		
		hanoi(n, 1, 3, 2);
		
    	int[][] answer = new int[list.size()][2];
    	for (int i = 0; i < list.size(); i++) {
			answer[i][0] = list.get(i)[0];
			answer[i][1] = list.get(i)[1];
		}
        
        return answer;
    }
	
	private void hanoi(int n, int from, int to, int via) {
		int[] move = {from, to};
		
		if (n == 1) {
			list.add(move);
		} else {
			hanoi(n-1, from, via, to);
			list.add(move);
			hanoi(n-1, via, to, from);
		}
	}
}