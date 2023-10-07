package toRetry;

import java.util.LinkedList;

public class 미로탈출 {

	public static void main(String[] args) {
//		String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
//		String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
//		String[] maps = {"SOOOO", "OOOOO", "OOOOO", "OOOOO", "OOOLE"};
//		String[] maps = {"SELXX", "XXXXX", "XXXXX", "XXXXX", "XXXXX"};
		String[] maps = {"OOOOOL", "OXOXOO", "OOSXOX", "OXXXOX", "EOOOOX"};
		EscapeMaze em = new EscapeMaze();
		int result = em.solution(maps);
		System.out.println(result);
	}

}
class EscapeMaze {
	int[] lever = new int[2];
	public int solution(String[] maps) {
        int answer = 0;
        
        // Find S
        int[] s = new int[2];
        char[][] map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = maps[i].charAt(j);
//				System.out.print(map[i][j]);
				if (map[i][j] == 'S') {
					s[0] = i; s[1] = j;
				}
			}
//			System.out.println();
		}
        
        // Find L
        int L = bfs(map, s, 'L');
        if (L == -1)
        	return -1;
//        System.out.println("Find L");

        
        // Find E
        int E = bfs(map, lever, 'E');
        if (E == -1)
        	return -1;
//        System.out.println("Find E");
        
        answer = L + E;
        
        return answer;
    }
    private int bfs(char[][] map, int[] start, char target) {
    	boolean[][] visited = new boolean[map.length][map[0].length];
    	LinkedList<int[]> queue = new LinkedList<>();
    	int[] s = new int[3];
    	s[0] = start[0]; s[1] = start[1]; s[2] = 0;
    	queue.add(s);
    	
    	int[][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    	
    	while(!queue.isEmpty()) {
    		int[] arr = queue.poll();
//    		System.out.println(arr[0] + " " + arr[1]);
    		for (int i = 0; i < move.length; i++) {
				int x = arr[0] + move[i][0];
				int y = arr[1] + move[i][1];
				
				if (x >= 0 && x < map.length && y >= 0 && y < map[x].length) {
					if (map[x][y] == target) {
						lever[0] = x;
						lever[1] = y;
						return arr[2] + 1;
					} else if(map[x][y] != 'X' && !visited[x][y]) {
						visited[x][y] = true;
						int[] tmp = new int[3];
						tmp[0] = x; tmp[1] = y; tmp[2] = arr[2]+1;
						queue.add(tmp);
					}
				}
			}
    	}
    	
    	return -1;
    }
}