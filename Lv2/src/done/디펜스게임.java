package done;

import java.util.Collections;
import java.util.PriorityQueue;

public class 디펜스게임 {

	public static void main(String[] args) {
//		int n = 7;
//		int k = 3;
//		int[] enemy = {4,2,4,5,3,3,1};
		int n = 2;
		int k = 4;
		int[] enemy = {3,3,3,3};
		Defence defence = new Defence();
		int result = defence.solution(n, k, enemy);
		System.out.println(result);
	}

}
class Defence {
	
	public int solution(int n, int k, int[] enemy) {
		int answer = enemy.length;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		int soldier = n;
		int card = k;
		
		for (int i = 0; i < enemy.length; i++) {
			soldier -= enemy[i];
			queue.add(enemy[i]);
			
			if (soldier < 0) {
				if (card > 0 && !queue.isEmpty()) {
					soldier += queue.poll();
					card--;
				} else {
					answer = i;
					break;
				}
			}
		}
		
		
		return answer;
	}
	
// 런타임 에러
//    int[] arr;
//    int max = 0;
//    
//	public int solution(int n, int k, int[] enemy) {
//        
//        arr = enemy;
//        
//        dfs(0, n, k);
//        
//        return max;
//    }
//    
//    public void dfs(int depth, int n, int K) {
//    	if (depth == arr.length || n < 0) {
//    		// 남은 병사 수가 -일 경우
//    		if (n < 0)
//    			depth--;
//    		
//    		if (max < depth)
//    			max = depth;
//    	} else {
//    		// 무적권 사용
//    		if (K > 0)
//    			dfs(depth+1, n, K-1);
//    		
//    		// 병사 사용
//    		dfs(depth+1, n-arr[depth], K);
//    	}
//    }
}