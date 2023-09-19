package done;

public class 괄호변환 {

	public static void main(String[] args) {
//		String p = "(()())()";
		String p = ")(";
		ParenthesesConversion pc = new ParenthesesConversion();
		String result = pc.solution(p);
		System.out.println(result);
	}

}
class ParenthesesConversion {
	ParenthesesConversion pc;
	
    public String solution(String p) {
    	pc = new ParenthesesConversion();

    	String answer = "";
        
        // 1.입력이 빈 문자열인 경우, 빈 문자열을 반환
        if (p.compareTo("") == 0)
        	return answer;
        
        // 2.문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리
        String[] uv = uv_divide(p);
        System.out.println(uv[0]);
        System.out.println(uv[1]);
        System.out.println(uv[2]);
        
        
        // 3.문자열 u가 "올바른 괄호 문자열"이라면 문자열 v에 대해 1단계부터 다시 수행
        if (uv[2].compareTo("true") == 0) {
        	answer = uv[0] + pc.solution(uv[1]); // 수행한 결과를 u에 이어 붙인 후 반환
        } else { // 4.문자열 u가 "올바른 문자열"이 아니라면 아래 과정을 수행
        	StringBuilder sb = new StringBuilder();
        	sb.append("("); // 4-1.빈 문자열에 첫 번째 문자로 '('를 붙인다
        	sb.append(pc.solution(uv[1])); // 4-2.문자열 v에 대해 1단계부터 재귀적으로 수행한 문자열을 이어 붙인다
        	sb.append(")"); // 4-3.')'를 다시 붙인다.
        	sb.append(uv_reverse(uv[0])); // 4-4.u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙인다
        	answer = sb.toString();
        }
        
        return answer;
    }
    
    private String uv_reverse(String u) {
    	String re_u = "";
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 1; i < u.length()-1; i++) {
			if (u.charAt(i) == '(') {
				sb.append(')');
			} else {				
				sb.append('(');
			}
		}
    	re_u = sb.toString();
    	
    	return re_u;
    }
    
    private String[] uv_divide(String p) {
    	String[] uv = new String[3];
    	
    	boolean flag = true;
    	
    	int l = 0, r = 0;
    	int t = 0;
    	for (t = 0; t < p.length(); t++) {
    		if ((l != 0 || r != 0) && l == r)
    			break;

    		if (p.charAt(t) == '(') {
				l++;
			} else if (p.charAt(t) == ')') {
				r++;
			}
    		if (l < r) {
    			flag = false;
    		}
		}
    	
    	uv[0] = p.substring(0, t);
    	if (t < p.length()) {
    		uv[1] = p.substring(t);
    	} else {
    		uv[1] = "";
    	}
    	uv[2] = flag + "";
    	
    	return uv;
    }
}