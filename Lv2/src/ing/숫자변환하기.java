package ing;

import java.util.HashSet;
import java.util.Iterator;

public class 숫자변환하기 {

	public static void main(String[] args) {
		ConvertNumber cn = new ConvertNumber();
		int result1 = cn.solution(10, 50, 5);
		System.out.println("result1 " + result1);
		int result2 = cn.solution(10, 40, 30);
		System.out.println("result2 " + result2);
		int result3 = cn.solution(2, 5, 4);
		System.out.println("result3 " + result3);
	}

}
class ConvertNumber {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        set.add(x);
        
        while (x != y) {
        	if (set.contains(y)) break;
        	Iterator<Integer> iter =  set.iterator();
        	while(iter.hasNext()) {
        		
        	}
        }
        
        return answer;
    }
    
}