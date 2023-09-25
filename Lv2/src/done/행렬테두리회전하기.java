package done;

public class 행렬테두리회전하기 {

	public static void main(String[] args) {
//		int rows = 6, columns = 6;
//		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
//		int rows = 3, columns = 3;
//		int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		int rows = 100, columns = 97;
		int[][] queries = {{1,1,100,97}};
		MatrixBorderRotation mbr = new MatrixBorderRotation();
		int[] result = mbr.solution(rows, columns, queries);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
class MatrixBorderRotation {
	
	int[][] matrix;
	
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        // matrix 초기화
        matrix = new int[rows][columns];
        int n = 1;
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = n++;
			}
		}
        
//        for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[i].length; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
        
        for (int i = 0; i < queries.length; i++) {
			int min = rotation(queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
			answer[i] = min;
			
		}
        
        return answer;
    }
    
    private int rotation(int x1, int y1, int x2, int y2) {
    	int min = matrix[x1][y1];
    	
    	// 상좌우
    	int stored = min;
    	for (int i = y1+1; i <= y2; i++) {
    		if(stored < min) {
    			min = stored;
    		}
    		int tmp = matrix[x1][i];
			matrix[x1][i] = stored;
			stored = tmp;
		}
    	
    	// 우상하
    	for (int i = x1+1; i <= x2; i++) {
    		if(stored < min) {
    			min = stored;
    		}
			int tmp = matrix[i][y2];
			matrix[i][y2] = stored;
			stored = tmp;
		}
    	
    	// 하우좌
    	for (int i = y2-1; i >= y1; i--) {
    		if(stored < min) {
    			min = stored;
    		}
			int tmp = matrix[x2][i];
			matrix[x2][i] = stored;
			stored = tmp;
		}
    	
    	// 좌하상
    	for (int i = x2-1; i >= x1; i--) {
    		if(stored < min) {
    			min = stored;
    		}
			int tmp = matrix[i][y1];
			matrix[i][y1] = stored;
			stored = tmp;
		}
    	
//    	for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[i].length; j++) {
//				System.out.print(matrix[i][j] +"\t");
//			}
//			System.out.println();
//		}
    	
    	return min;
    }
}