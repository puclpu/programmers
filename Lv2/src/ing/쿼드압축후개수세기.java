package ing;

public class 쿼드압축후개수세기 {

	public static void main(String[] args) {
		int[][] arr = {};
		QuadCompression qc = new QuadCompression();
		int[] result = qc.solution(arr);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
class QuadCompression {
    public int[] solution(int[][] arr) {
        int[] answer = {};
        
        int len = arr.length;

        while(len > 1) {
        	for (int i = 0; i < arr.length; i = i + len) {
				for (int j = 0; j < arr.length; j = j + len) {
					
				}
			}
        	len = len / 2;
        }
        
        return answer;
    }
}