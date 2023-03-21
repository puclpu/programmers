package toRetry;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

	public static void main(String[] args) {
		ShortestPathOfGameMap spgm = new ShortestPathOfGameMap();
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		int result = spgm.solution(maps);
		System.out.println(result);
	}

}
class ShortestPathOfGameMap {
	class Node{
		int x;
		int y;
		int count;
		
		public Node(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public int solution(int[][] maps) {
        
        int m = maps.length;
        int n = maps[0].length;
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        
        Queue<Node> nodes = new LinkedList<>();
        Node start = new Node(0, 0, 1);
        nodes.offer(start);
        
        while(!nodes.isEmpty()) {
        	Node node = nodes.poll();
        	
        	if (node.x == n-1 && node.y == m-1)
        		return node.count;
        	
        	for (int c = -1; c <= 1; c += 1) {
                for (int r = -1; r <= 1; r += 1) {
                    if (c * r != 0) continue;

                    int col = node.x + c;
                    int row = node.y + r;

                    if (   0 <= col && col < n
                        && 0 <= row && row < m
                        && maps    [row][col] == 1
                        && !visited[row][col]
                       ) 
                    {
                        visited[row][col] = true;
                        nodes.offer(new Node(col, row, node.count + 1));
                    }
                }
            }
        	
        }
        
        return -1;
    }
	
}