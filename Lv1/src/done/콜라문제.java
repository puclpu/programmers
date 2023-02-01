package done;

public class 콜라문제 {

	public static void main(String[] args) {
		int a = 3;
		int b = 1;
		int n = 20;
		
		Cola cola = new Cola();
		int result = cola.solution(a, b, n);
		System.out.print(result);
	}

}

class Cola {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
        	System.out.print("빈 병 " + n + "개 중에 " + n/a*a + "개를 가져가서 ");
        	System.out.println(n/a + "병의 콜라를 받습니다.");
        	answer += n / a*b;
        	n = n/a*b + n%a;
        }
        
        return answer;
    }
    
}