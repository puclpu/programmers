package done;

import java.util.ArrayList;
import java.util.LinkedList;

public class 프린터 {

	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		Printer pri = new Printer();
		int result = pri.solution(priorities, location);
		System.out.println(result);
	}

}
class Printer {
	class Document {
		int location;
		int priority;
		
		public Document(int location, int priority) {
			super();
			this.location = location;
			this.priority = priority;
		}
	}
	
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        LinkedList<Document> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
        	Document doc = new Document(i, priorities[i]);
        	queue.add(doc);
        }
        
        ArrayList<Document> list = new ArrayList<>();
        int target = -1;
        
        while(target != location) {
        	Document first = queue.getFirst();
        	boolean hp = true;
        	for (int i = 1; i < queue.size(); i++) {
				if (first.priority < queue.get(i).priority) {
					hp = false;
					queue.remove();
					queue.add(first);
					break;
				}
			}
        	if (hp) {
        		list.add(first);
        		queue.remove();
        		target = first.location;
        	}
        }
        
        answer = list.size();
        
        return answer;
    }
}