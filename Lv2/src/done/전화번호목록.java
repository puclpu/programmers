package done;

import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {

	public static void main(String[] args) {
		ListOfPhoneNumbers nopn = new ListOfPhoneNumbers();
		String[] phone_book = {"119", "97674223", "1195524421"};
		String[] phone_book2 = {"123","456","789"};
		String[] phone_book3 = {"12","123","1235","567","88"};
		boolean result = nopn.solution(phone_book);
		boolean result2 = nopn.solution(phone_book2);
		boolean result3 = nopn.solution(phone_book3);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
	}

}
class ListOfPhoneNumbers {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, String> map = new HashMap<>();
        
        for (int i = 0; i < phone_book.length; i++) {
			map.put(phone_book[i], phone_book[i]);
		}
        
        for (int i = 0; i < phone_book.length; i++) {
			for (int j = 1; j < phone_book[i].length(); j++) {
				if (map.containsKey(phone_book[i].substring(0, j)))
					return false;
			}
		}
        
        return answer;
    }
}