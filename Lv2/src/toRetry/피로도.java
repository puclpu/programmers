package toRetry;

public class 피로도 {

	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {
				{80, 20},
				{50, 40},
				{30, 10}
		};
		DegreeOfFatigue dof = new DegreeOfFatigue();
		int result = dof.solution(k, dungeons);
		System.out.println(result);
	}

}
class DegreeOfFatigue {
	
	public int solution(int k, int[][] dungeons) {
		return dfs(k, dungeons);
	}
	
	private int dfs(int k, int[][] dungeons) {
		int count = 0;
		for (int[] d : dungeons) {
			int a = d[0];
			int b = d[1];
			if (a <= k) {
				d[0] = 9999;
				count = Math.max(1 + dfs(k-b, dungeons), count);
				d[0] = a;
			}
		}
		return count;
	}
	
//	int answer = 0;
//	public boolean[] visit;
//	
//    public int solution(int k, int[][] dungeons) {
//        
//        visit = new boolean[dungeons.length];
//        dfs(0, k, dungeons);
//        
//        return answer;
//    }
//    
//    public void dfs(int depth, int k, int[][] dungeons) {
//    	for (int i = 0; i < dungeons.length; i++) {
//			if (!visit[i] && dungeons[i][0] <= k) {
//				visit[i] = true;
//				dfs(depth + 1, k - dungeons[i][1], dungeons);
//				visit[i] = false;
//			}
//		}
//    	answer = Math.max(answer, depth);
//    }
}