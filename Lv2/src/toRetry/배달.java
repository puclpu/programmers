package toRetry;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 배달 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int N = 5, K = 3;
//		int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
//		int N = 6, K = 4;
		Delivery del = new Delivery();
		int result = del.solution(N, road, K);
		System.out.println(result);
	}

}
class Delivery {
	
	class Node implements Comparable<Node>{

		int town;
		int cost;
		
		public Node (int town, int cost) {
			this.town = town;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost > o.cost ? 1 : -1;
		}

		@Override
		public String toString() {
			return "Node [town=" + town + ", cost=" + cost + "]";
		}
		
	}
	
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        ArrayList<ArrayList<Node>> map = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < N+1; i++) {
			map.add(new ArrayList<Node>());
		}
        
        for (int i = 0; i < road.length; i++) {
			map.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
			map.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
		}
        
//        for (int i = 0; i < map.size(); i++) {
//			System.out.println("town" + (i));
//			ArrayList<Node> tmp = map.get(i);
//			for (int j = 0; j < tmp.size(); j++) {
//				System.out.println(tmp.get(j));
//			}
//		}
        
        // 방문 여부
        boolean[] visited = new boolean[N+1];
        // 최소 비용
        int[] min_cost = new int[N+1];
        for (int i = 0; i < min_cost.length; i++) {
			min_cost[i] = Integer.MAX_VALUE;
		}
        min_cost[1] = 0;
        
        // 다익스트라 알고리즘
        for (int i = 0; i < N; i++) {
			// 방문하지 않은 노드 중 가장 비용이 작은 노드
        	Node target = find_min_cost(visited, min_cost);
			visited[target.town] = true;
			
			// 인접 노드로의 최소 비용
			ArrayList<Node> around = map.get(target.town);
			for (int j = 0; j < around.size(); j++) {
				if (min_cost[around.get(j).town] > around.get(j).cost + target.cost) {
					min_cost[around.get(j).town] = around.get(j).cost + target.cost;
				}
			}
		}
        
        for (int i = 1; i < min_cost.length; i++) {
			if (min_cost[i] <= K)
				answer++;
		}
        
        return answer;
    }
    private Node find_min_cost(boolean[] visited, int[] min_cost) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	for (int i = 1; i < min_cost.length; i++) {
			if (!visited[i]) {
				pq.add(new Node(i, min_cost[i]));
			}
		}
    	return pq.peek();
    }
}