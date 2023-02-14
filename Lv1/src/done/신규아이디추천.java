package done;

public class 신규아이디추천 {

	public static void main(String[] args) {
		NewIdRecommend nir = new NewIdRecommend();
//		String result1 = nir.solution("...!@BaT#*..y.abcdefghijklm");
//		String result2 = nir.solution("z-+.^.");
//		String result3 = nir.solution("=.=");
//		String result4 = nir.solution("123_.def");
		String result5 = nir.solution("abcdefghijklmn.p");
//		System.out.println(result1);
//		System.out.println(result2);
//		System.out.println(result3);
//		System.out.println(result4);
		System.out.println(result5);
	}

}
class NewIdRecommend {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환
        new_id = new_id.toLowerCase();
        
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        new_id = new_id.replaceAll("[^0-9a-z-_.]", "");
        
        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        new_id = new_id.replaceAll("\\.{2,}", ".");
        
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거
        new_id = new_id.replaceAll("^\\.", "");
        new_id = new_id.replaceAll("\\.$", "");
        
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입
        if ("".equals(new_id))
        	new_id = "a";
        
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.)를 제거
        if (new_id.length() > 15) {
        	new_id = new_id.substring(0, 15);
        	new_id = new_id.replaceAll("\\.$", "");
        }
        
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙이
        if (new_id.length() < 3) {
        	String last = String.valueOf(new_id.charAt(new_id.length()-1));
        	while (new_id.length() < 3) {
        		new_id = new_id + last;
        	}
        }
        
        answer = new_id;
        
        return answer;
    }
}