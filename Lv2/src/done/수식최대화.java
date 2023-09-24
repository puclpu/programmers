package done;

import java.util.ArrayList;

public class 수식최대화 {

	public static void main(String[] args) {
//		String expression = "100-200*300-500+20";
		String expression = "50*6-3*2";		
		FormulaMaximum fm = new FormulaMaximum();
		long result = fm.solution(expression);
		System.out.println(result);
	}

}
class FormulaMaximum {
	
	long max = 0;

	public long solution(String expression) {
        long answer = 0;
        
        // expression 자르기
        ArrayList<String> formula = expression_split(expression);
        
        // dfs
        dfs(formula);
        
        answer = max;
        
        return answer;
    }
	
	private void dfs(ArrayList<String> formula) {
		if (formula.contains("*") || formula.contains("+") || formula.contains("-")) {
			String[] opers = {"*", "+", "-"};
			for (int i = 0; i < opers.length; i++) {
				if (formula.contains(opers[i])) { // 해당 연산자만 계산을 수행한 formula를 구한다.
					ArrayList<String> cf = calculate(formula, opers[i]);
					dfs(cf);
				}
			}
		} else { // 연산자가 없이 모두 계산된 경우 모든 계산이 끝났다고 가정. max와 비교한다
			long sum = Long.parseLong(formula.get(0));
			if (sum < 0)
				sum *= -1;
			
			if (sum > max)
				max = sum;
		}
	}
	
	private ArrayList<String> calculate(ArrayList<String> formula, String operator) {
		ArrayList<String> list = new ArrayList<>();
		
		for (int i = 0; i < formula.size(); i++) {
			if (formula.get(i).compareTo(operator) == 0) {
				long before = Long.parseLong(list.get(list.size()-1));
				long next = Long.parseLong(formula.get(i+1));
				list.set(list.size()-1, calc(before, next, operator)); // 계산하여 list 마지막 인덱스에 set
				i++;
			} else {
				list.add(formula.get(i)); // 해당하는 연산자가 아닌 것은 list에 add
			}
		}
		
		return list;
	}
    
	private ArrayList<String> expression_split(String expression) {
		ArrayList<String> formula = new ArrayList<>();
		int start = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+') {
				formula.add(expression.substring(start, i));
				formula.add("+");
				start = i+1;
			} else if (expression.charAt(i) == '-') {
				formula.add(expression.substring(start, i));
				formula.add("-");
				start = i+1;				
			} else if (expression.charAt(i) == '*') {
				formula.add(expression.substring(start, i));
				formula.add("*");
				start = i+1;								
			}
		}
		formula.add(expression.substring(start, expression.length()));
		return formula;
	}
 
    private String calc (long before, long next, String operator) {
    	long sum = 0;
    	
    	if(operator.compareTo("*") == 0) {
    		sum = before * next;
    	} else if(operator.compareTo("+") == 0) {
    		sum = before + next;
    	} else if(operator.compareTo("-") == 0) {
    		sum = before - next;
    	}
    	
    	return sum + "";
    }
}