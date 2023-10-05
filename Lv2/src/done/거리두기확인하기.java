package done;

public class 거리두기확인하기 {

	public static void main(String[] args) {
		String[][] places = {
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
//				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
				{"OOPOO", "OPOOO", "OOOOO", "OOOOO","OOOOO"},
//				{"OPOPO", "PXPXP", "XXXXX", "PXXXX", "PPPPP"},
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		
		
		KeepYourDistance kyd = new KeepYourDistance();
		int[] result = kyd.solution(places);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
class KeepYourDistance {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < places.length; i++) {
			answer[i] = rule(places[i]);
		}
        
        return answer;
    }
    private int rule(String[] room) {
    	// 맨해튼 거리가 2 이하로 앉지 마시오.
    	// (|x1-x2| + |y1-y2|)
    	// (0,2), (1,1), (2,0)
    	// (0,1), (1,0)
    	
    	int[][] manh = {{0,2}, {2,0}, {1,1}, {0,1}, {1,0}};
    	
    	for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// find P
				if (room[i].charAt(j) == 'P') {
					// 맨해튼 거리 2 이하에 다른 P가 있는지 확인
					for (int k = 0; k < manh.length; k++) {
						if(i + manh[k][0] < 5 && j + manh[k][1] < 5 
								&& room[i+manh[k][0]].charAt(j+manh[k][1]) == 'P') {
							// 파티션을 두고 앉은 경우인지 확인
							if (k == 0 && room[i].charAt(j+1) == 'X' 
									|| k == 1 && room[i+1].charAt(j) == 'X' 
									|| k == 2 && room[i+1].charAt(j) == 'X' && room[i].charAt(j+1) == 'X') {
								continue;
							} else {
								return 0;
							}
						}
						// O P
						// P O
						if (k == 2 && i + 1 < 5 && j - 1 > -1 && room[i+1].charAt(j-1) == 'P') {
							if (room[i].charAt(j-1) == 'X' && room[i+1].charAt(j) == 'X') {
								continue;
							} else {
								return 0;
							}
						}
					}
				}
			}
		}
    	return 1;
    	
//    	for (int i = 0; i < room.length; i++) {
//			for (int j = 0; j < room[i].length(); j++) {
//				System.out.print(room[i].charAt(j) + " ");
//			}
//			System.out.println();
//		}
//    	System.out.println("====================");
    }
}