package ing;

public class 땅따먹기 {

	public static void main(String[] args) {
		int[][] land = {
				{1, 2, 3, 5},
				{5, 6, 7, 8},
				{4, 3, 2, 1}
		};
		Ttangttameokgi tt = new Ttangttameokgi();
		int result = tt.solution(land);
		System.out.println(result);
	}

}
class Ttangttameokgi {
    int solution(int[][] land) {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}