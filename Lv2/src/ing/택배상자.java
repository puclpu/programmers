package ing;

import java.util.Stack;

public class 택배상자 {

	public static void main(String[] args) {
//		int[] order = {4, 3, 1, 2, 5};
		int[] order = {5, 4 ,3, 2, 1};
		DeliveryBox db = new DeliveryBox();
		int result = db.solution(order);
		System.out.println(result);
	}

}
class DeliveryBox {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> container = new Stack<>();
        Stack<Integer> belt = new Stack<>();
        for (int i = order.length; i > 0; i--) {
			container.add(i);
		}
        
        for (int i = 0; i < order.length; i++) {
			if(container.contains(order[i])) { // 컨테이너 벨트에 target 상자가 있을 경우
				while(container.peek() != order[i]) { // target 상자 이전 순서의 박스를
					belt.add(container.pop()); // 보조 컨테이너 벨트에 보관
				}
				// target 상자 싣기
				int a = container.pop();
				System.out.println("no "+a + " in container");
				answer++;
			} else { // 컨테이너 벨트에 target 박스가 없을 경우
				// 보조 컨테이너 벨트의 첫 번재 확인
				if (belt.peek() == order[i]) {
					// target 상자 싣기
					int a = belt.pop();
					System.out.println("no "+a + " in belt");
					answer++;
				} else {
					// 더 이상 상자를 싣기 않는다.
					break;
				}
			}
		}
        
        return answer;
    }
}