package done;

public class 삼각달팽이 {

	public static void main(String[] args) {
		TriangularSnail ts = new TriangularSnail();
		int[] result = ts.solution(1000);
//		int[] result2 = ts.solution(4);
//		int[] result3 = ts.solution(4);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
class TriangularSnail {
    
	public int[] solution(int n) {
        int[] answer = {};

        int[] snail = new int[(1+n) * n / 2];
        
        int idx = 0;
        int dis = 1;
        int num = 1;
        for (int i = 0; i < n; i++) {
			if (i == 0) {
//				System.out.println("idx : " + idx + " num : " + num);
				snail[0] = num++;
				for (int j = 0; j < n-1; j++) {
					idx = idx + dis++;
//					System.out.println("0 > idx : " + idx + " num : " + num);
					snail[idx] = num++;
				}
			} else if (i % 3 == 1) {
				for (int j = 0; j < n-i; j++) {
//					System.out.println(j + " " + (n-i));
					idx++;
//					System.out.println(i + " > idx : " + idx + " num : " + num);
					snail[idx] = num++;
				}
			} else if (i % 3 == 2) {
				for (int j = 0; j < n-i; j++) {
					idx = idx - dis--;
//					System.out.println(i + " > idx : " + idx + " num : " + num);
					snail[idx] = num++;
				}
			} else {
				for (int j = 0; j < n - i; j++) {
					idx = idx + dis++;
//					System.out.println(i + " > idx : " + idx + " num : " + num);
					snail[idx] = num++;					
				}
			}
		}
        
        answer = snail;
        
        return answer;
    }
}