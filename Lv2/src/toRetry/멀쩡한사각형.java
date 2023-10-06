package toRetry;

public class 멀쩡한사각형 {

	public static void main(String[] args) {
		int w = 8, h = 12;
		FineSquare fs = new FineSquare();
		long result = fs.solution(w, h);
		System.out.println(result);
	}
}
class FineSquare {
    public long solution(int w, int h) {
        // gcd
        long gcd = find_gcd(w, h);
        
        long answer = ((long)w * h) - (((w / gcd) + (h / gcd) - 1) * gcd);
        
        return answer;
    }
    private int find_gcd(int w, int h) {
    	
    	while(h != 0) {
    		int r = w % h;
    		w = h;
    		h = r;
    	}
    	
    	return w;
    }
}