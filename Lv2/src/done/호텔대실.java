package done;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔대실 {

	public static void main(String[] args) {
		String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
//		String[][] book_time = {{"09:10", "10:10"}, {"10:20", "12:20"}};
//		String[][] book_time = {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};
		HotelReservation hr = new HotelReservation();
		int result = hr.solution(book_time);
		System.out.println(result);
	}

}
class HotelReservation {
	public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] ibt = time_string_to_int(book_time);
        
        // 입실 시각과 퇴실 시각이 빠른 것을 기준으로 정렬
        Arrays.sort(ibt, (o1, o2) -> {
        	if (o1[0] > o2[0]) {
        		return 1;
        	} else if (o1[0] < o2[0]) {
        		return -1;
        	} else {
        		if (o1[1] > o2[1]) {
        			return 1;
        		} else {
        			return -1;
        		}
        	}
        });
        
//        for (int i = 0; i < ibt.length; i++) {
//			for (int j = 0; j < ibt[i].length; j++) {
//				System.out.print(ibt[i][j] + " ");
//			}
//			System.out.println();
//		}
        
        // 방 배정
        PriorityQueue<Integer> room = new PriorityQueue<>();
        for (int[] time : ibt) {
			if (room.size() > 0) {
				if (time[0] >= room.peek()) {
					room.poll();
					room.add(time[1]);
				} else {
					room.add(time[1]);
				}
			} else {
				room.add(time[1]);
			}
		}
        
        answer = room.size();
        
        return answer;
    }
	
	private int[][] time_string_to_int(String[][] book_time) {
    	int[][] ibt = new int[book_time.length][2];
    	
    	for (int i = 0; i < book_time.length; i++) {
			ibt[i][0] = Integer.parseInt(book_time[i][0].replaceAll(":", "")); // 입실 시각
			ibt[i][1] = 10 + Integer.parseInt(book_time[i][1].replaceAll(":", "")); // 퇴실 시각
			
			if (ibt[i][1] % 100 >= 60) { // 퇴실 시각 m이 60분을 넘을 경우를 가정
				ibt[i][1] = ibt[i][1] + 100 - 60;
			}
		}
    	
    	return ibt;
    }
}