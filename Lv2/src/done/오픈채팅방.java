package done;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 오픈채팅방 {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi",
				"Enter uid4567 Prodo",
				"Leave uid1234",
				"Enter uid1234 Prodo",
				"Change uid4567 Ryan"};
		OpenChatting oc = new OpenChatting();
		String[] result = oc.solution(record);
		for (String string : result) {
			System.out.println(string);
		}
	}

}
class OpenChatting {
    public String[] solution(String[] record) {
        String[] answer;
        
        Map<String, String> nickname = new HashMap<>();
        
        for (int i = 0; i < record.length; i++) {
			String[] command = record[i].split(" ");
//			System.out.println(command[0]);
			if (command[0].equals("Enter") || command[0].equals("Change")) {
				nickname.put(command[1], command[2]);
			}
		}

        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
			String[] command = record[i].split(" ");
			String nick = nickname.get(command[1]);
			if (command[0].equals("Enter")) {
				list.add(nick + "님이 들어왔습니다.");
			} else if (command[0].equals("Leave")) {
				list.add(nick + "님이 나갔습니다.");
			}
		}
        
        answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
}