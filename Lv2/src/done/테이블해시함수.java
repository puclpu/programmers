package done;

import java.util.Arrays;
import java.util.Comparator;

public class 테이블해시함수 {

	public static void main(String[] args) {
		int[][] data = {{2,2,6}, {1,5,10}, {4,2,9}, {3,8,3}};
		int col = 2;
		int row_begin = 2;
		int row_end = 3;
		TableHashFunction thf = new TableHashFunction();
		int result = thf.solution(data, col, row_begin, row_end);
		System.out.println(result);
	}

}
class TableHashFunction {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // col번째 컬럼의 값을 기준으로 오름차순 정렬을 하되,
        Arrays.sort(data, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[col-1] > o2[col-1]) {
					return 1;					
				} else if (o1[col-1] == o2[col-1]) {
					// 만약 그 값이 동일하면 기본키인 첫번째 컬럼의 값을 기준으로 내림차순 정렬
					if (o1[0] < o2[0]) {
						return 1;
					} else {
						return -1;
					}
				}
				return -1;
			}
        	
		});
        
        // 정렬된 데이터에서 S_i를 i번째 행의 튜플에 대해 각 컬럼의 값을 i로 나눈 나머지들이 합으로 정의
        int[] S = new int[row_end - row_begin+1];
        for (int i = row_begin; i <= row_end; i++) {
        	int index = i - row_begin;
        	for (int j = 0; j < data[i-1].length; j++) {
				S[index] += data[i-1][j] % i;
			}
		}
        
        // 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로 반환
        for (int i = row_begin-1; i < row_end; i++) {
			int S_i = 0;
			for (int j = 0; j < data[i].length; j++) {
				S_i += data[i][j] % (i+1);
			}
			answer = (answer ^ S_i);
		}
        
        return answer;
    }
}