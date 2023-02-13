package ing;

import java.util.ArrayList;

public class 크레인인형뽑기게임 {

	public static void main(String[] args) {
		int[][] board = {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}
		};
		int[] moves = {1,5,3,5,1,2,1,4};
		CraneMachineGame cmg = new CraneMachineGame();
		int result = cmg.solution(board, moves);
		System.out.println(result);
	}

}
class CraneMachineGame {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        ArrayList<Integer> basket = new ArrayList<>();
        for (int i = 0; i < moves.length; i++) {
        	// 바구니에 인형 넣기
        	int m = moves[i] - 1;
        	for (int j = 0; j < board.length; j++) {
				if (board[j][m] != 0) {
					basket.add(board[j][m]);
					board[j][m] = 0;
					break;
				}
			}
        	// 바구니에 인형을 넣었을 때 터지는지 확인
        	int l1 = basket.size() - 1;
        	int l2 = basket.size() - 2;
        	if(basket.size() > 1 && basket.get(l1) == basket.get(l2)) {
        		answer += 2;
        		basket.remove(l1);
        		basket.remove(l2);
        	}
        } 
        
        return answer;
    }
}