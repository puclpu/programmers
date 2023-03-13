package done;

import java.util.HashSet;

public class 방문길이 {

	public static void main(String[] args) {
		VisitLength vl = new VisitLength();
//		int result = vl.solution("ULURRDLLU");
//		System.out.println(result);
		int result2 = vl.solution("LULLLLLLU");
		System.out.println(result2);
	}

}
class VisitLength {
    public int solution(String dirs) {
        int answer = 0;
        
        HashSet<String> set = new HashSet<String>();
        
        int[][] pos = new int[2][2]; // 현재 위치와 이전 위치 저장 
        
        for (int i = 0; i < dirs.length(); i++) {
			char direction = dirs.charAt(i);
			// 이전 위치 저장
			pos[1][0] = pos[0][0];
			pos[1][1] = pos[0][1];
			
			boolean flag = false;
			switch (direction) {
			case 'U':
				pos[0][1]++;
				if (pos[0][1] > 5) {
					flag = true;
					pos[0][1] = 5;
				}
				break;
			case 'D':
				pos[0][1]--;
				if (pos[0][1] < -5) {
					flag = true;
					pos[0][1] = -5;
				}
				break;
			case 'R':
				pos[0][0]++;
				if (pos[0][0] > 5) {
					flag = true;
					pos[0][0] = 5;
				}
				break;
			case 'L':
				pos[0][0]--;
				if (pos[0][0] < -5) {
					flag = true;
					pos[0][0] = -5;
				}
				break;
			default:
				break;
			}
//			System.out.println(i+1 + ")" + pos[0][0] + " " + pos[0][1]);
			if (flag)
				continue;
//			System.out.println(pos[0][1]);
			set.add("" + pos[0][0] + pos[0][1] + pos[1][0] + pos[1][1]);
			set.add("" + pos[1][0] + pos[1][1] + pos[0][0] + pos[0][1]);
		}
        
        answer = set.size() / 2;
        
        return answer;
    }
}