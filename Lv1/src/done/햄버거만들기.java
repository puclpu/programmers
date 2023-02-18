package done;

import java.util.Stack;

public class 햄버거만들기 {

	public static void main(String[] args) {
		int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
		MakeHamburgur mh = new MakeHamburgur();
		int result = mh.solution(ingredient);
		System.out.println(result);
	}

}
class MakeHamburgur {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ingredient.length; i++) {
			stack.push(ingredient[i]);
			if (stack.size() >= 4) {
				int bread2 = stack.pop();
				int meat = stack.pop();
				int veg = stack.pop();
				int bread1 = stack.pop();
				if (bread1 == 1 && bread2 == 1 && veg == 2 && meat == 3) {
					answer++;
				} else {
					stack.push(bread1);
					stack.push(veg);
					stack.push(meat);
					stack.push(bread2);
				}
			}
		}
        
        return answer;
    }
}