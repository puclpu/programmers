package done;

import java.util.HashSet;
//import java.util.Iterator;

public class 롤케이크자르기 {

	public static void main(String[] args) {
		RollcakeCutting rc = new RollcakeCutting();
		int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
//		int[] topping = {1, 2, 3, 1, 4};
		int result = rc.solution(topping);
		System.out.println(result);
	}

}
class RollcakeCutting {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashSet<Integer> older = new HashSet<>();
        HashSet<Integer> younger = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
			younger.add(topping[i]);
		}
        
        for (int i = 0; i < topping.length; i++) {
			older.add(topping[i]);
			boolean flag = false;
			for (int j = i + 1; j < topping.length; j++) {
//				System.out.println(topping[i] + " " + topping[j]);
				if(topping[i] == topping[j]) {
					flag = true;
					break;
				}
			}
			if (!flag) { // 동생이 가질 토핑에 topping[i]가 없다면 set에서 삭제
				younger.remove(topping[i]);
			}
			
//			Iterator<Integer> old = older.iterator();
//			Iterator<Integer> young = younger.iterator();
//			for (Integer o : older) {
//				System.out.println(o);
//			}
//			System.out.println();
//			for (Integer y : younger) {
//				System.out.println(y);
//			}
//			System.out.println("----");
			
			if (older.size() == younger.size()) { // 토핑의 수가 같으면
				answer++;
			}
		}
        
        return answer;
    }
}