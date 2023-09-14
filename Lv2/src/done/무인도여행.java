package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class 무인도여행 {

	public static void main(String[] args) {
		String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
//		String[] maps = {"XXX","XXX","XXX"};
//		String[] maps = {"XXX1X", "X1234", "X3XXX"};
		MuindoTrip mt = new MuindoTrip();
		int[] result = mt.solution(maps);
		for (int i : result) {
			System.out.println(i);
		}
	}

}
class MuindoTrip {
	
	String[] map;
	boolean[][] visited;
	
    public int[] solution(String[] maps) {
        int[] answer;
        
        visited = new boolean[maps.length][maps[0].length()];
        map = maps;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				if (!visited[i][j]) {
					char target = maps[i].charAt(j);
					if (target == 'X') {
						visited[i][j] = true;
					} else {
						int sum = bfs(i, j);
						list.add(sum);
					}
				}
			}
		}
        
        if (list.size() == 0) {
        	answer = new int[1];
        	answer[0] = -1;
        } else {
        	answer = new int[list.size()];
        	for (int i = 0; i < answer.length; i++) {
        		answer[i] = list.get(i);
        	}
        	Arrays.sort(answer);        	
        }
        
        return answer;
    }
    
    private int bfs(int i, int j) {
    	System.out.println("bfs " + i + " " + j);
    	int sum = 0;
    	
    	LinkedList<String> queue = new LinkedList<>();
    	int tn = map[i].charAt(j)-'0';
    	sum = tn;
    	queue.add(i + "," + j);
    	System.out.println("q put : " + i + ", " + j + " = " + tn);
    	visited[i][j] = true;
    	
    	int[][] arnd = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 주변 노드	
    	
    	while(!queue.isEmpty()) { // queue가 empty가 될 때까지
    		String qp = queue.pop();
    		String[] qn = qp.split(",");
    		int x = Integer.parseInt(qn[0]);
    		int y = Integer.parseInt(qn[1]);
    		System.out.println("q pop : " + x + ", " + y + " = " + (map[i].charAt(j)-'0'));
    		
    		for (int k = 0; k < arnd.length; k++) {
    			int tx = x + arnd[k][0];
    			int ty = y + arnd[k][1];
    			System.out.println("tx : " + tx + " ty : " + ty);
				if (tx >= 0 && tx < map.length &&
						ty >= 0 && ty < map[0].length() 
						&& !visited[tx][ty]) { // 방문하지 않은 곳이라면
					tn = (map[tx].charAt(ty));

					if (tn != 'X') {
						sum += (tn - '0');
						queue.add(tx + "," + ty);
						System.out.println("q put : " + tx + ", " + ty + " = " + (tn-'0'));
					}
					
					visited[tx][ty] = true;
				}
			}
    	}
    	
    	return sum;
    }
}