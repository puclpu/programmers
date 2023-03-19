package toRetry;


public class 모음사전 {

	public static void main(String[] args) {
		AeiouDictionary ad = new AeiouDictionary();
		int result = ad.solution("AAAAE");
		System.out.println(result);
	}

}
class AeiouDictionary {
    public int solution(String word) {
        int answer = 0;
        int total = 3905;
        
        String aeiou = "AEIOU";
        
        for (String str : word.split("")) {
			total/=5;
			answer += total*aeiou.indexOf(str) + 1;
		}
        
        
        return answer;
    }
    
}