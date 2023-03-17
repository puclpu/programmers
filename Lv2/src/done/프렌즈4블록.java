package done;

import java.util.ArrayList;

//import java.util.ArrayList;
//import java.util.HashSet;

public class 프렌즈4블록 {

	public static void main(String[] args) {
		Friends4Block fb = new Friends4Block();
//		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
//		int result = fb.solution(6, 6, board);
//		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
//		int result = fb.solution(4, 5, board);
		String[] board = {"AA", "AA"};
		int result = fb.solution(2, 2, board);
//		String[] board = { "AA", "AB" };
//		int result = fb.solution(2, 2, board);
//		String[] board = {"DD", "CC", "AA", "AA", "CC", "DD"};
//		int result = fb.solution(6,2, board);
		System.out.println(result);
	}

}

class Friends4Block {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] cboard = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				cboard[i][j] = board[i].charAt(j);
			}
		}
		
		boolean[][] bboard = new boolean[m][n];
		boolean deleted = true;
		
        while(deleted) { // 지워질 블록이 없을 때까지 반복
        	// 블록 찾기 전 bboard를 false로 초기화
        	for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					bboard[i][j] = false;
				}
			}
        	
        	// 지워질 블록 찾기
        	for (int i = 0; i < m-1; i++) {
				for (int j = 0; j < n-1; j++) {
					char target = cboard[i][j];
					if (target != '0'
							&& target == cboard[i][j+1] && target == cboard[i+1][j+1] && target == cboard[i+1][j]) {
						bboard[i][j] = true;
						bboard[i][j+1] = true;
						bboard[i+1][j+1] = true;
						bboard[i+1][j] = true;
					}
				}
			}
//        	for (int i = 0; i < m; i++) {
//    			for (int j = 0; j < n; j++) {
//    				System.out.print(cboard[i][j]);
//    			}
//    			System.out.println();
//    		}
//        	System.out.println();
        	
        	// 지워진 블록이 없으면(=모든 블록이 false면) while문을 끝냄
        	deleted = false;
        	for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (bboard[i][j]) {
						answer++;
						deleted = true;
					}
				}
			}
//        	for (int i = 0; i < m; i++) {
//    			for (int j = 0; j < n; j++) {
//    				if (bboard[i][j]) {
//    					System.out.print("T");
//    				} else {
//    					System.out.print("F");
//    				}
//    			}
//    			System.out.println();
//    		}
//        	System.out.println();
        	
        	// 블록 지우기
        	for (int i = 0; i < n; i++) {
				ArrayList<Character> list = new ArrayList<Character>();
        		for (int j = m - 1; j >= 0; j--) {
        			if(!bboard[j][i]) { // bboard[j][i]가 false이면 list에 add
        				list.add(cboard[j][i]);
        			}
        			cboard[j][i] = '0';
				}

        		int len = list.size();
        		for (int j = m - 1, k = 0; j >= m - len && k < len; j--, k++) {
        			cboard[j][i] = list.get(k); // list에 저장된 값 꺼내서 cboard에 저장
        		}
			}
        	
        }
        
        return answer;
    }
    
}

//class Friends4Block {
//	public int solution(int m, int n, String[] board) {
//		int answer = 0;
//
//		char[][] fb_board = new char[m][n];
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				fb_board[i][j] = board[i].charAt(j);
//			}
//		}
//
//		while (true) {
//			HashSet<String> set = find_removeBlock(m, n, fb_board);
//			if (set.size() == 0)
//				break;
//			answer += set.size();
//			for (String rmb : set) {
//				fb_board[rmb.charAt(0) - 48][rmb.charAt(1) - 48] = '0';
//			}
//			fb_board = remove_block(m, n, fb_board);
//		}
//
//		return answer;
//	}
//
//	private char[][] remove_block(int m, int n, char[][] fb_board) {
//
//		for (int i = 0; i < n; i++) {
//			ArrayList<Character> list = new ArrayList<>();
//			for (int j = m - 1; j >= 0; j--) {
//				if (fb_board[j][i] != '0') {
//					list.add(fb_board[j][i]);
//				}
//			}
//			for (int j = m - 1, k = 0; j >= m - list.size(); j--, k++) {
//				fb_board[j][i] = list.get(k);
//			}
//			for (int j = 0; j < m - list.size(); j++) {
//				fb_board[j][i] = '0';
//			}
//		}
//
//		return fb_board;
//	}
//
//	private HashSet<String> find_removeBlock(int m, int n, char[][] fb_board) {
//
//		HashSet<String> set = new HashSet<>(); // 지워질 블록의 좌표를 담을 set
//		for (int i = 0; i < m - 1; i++) {
//			for (int j = 0; j < n - 1; j++) {
//				String[] check_first = check_fb(i, j, fb_board);
//				if (check_first[0] != null) { // 반환받은 문자열 배열에 저장된 값이 null이 아니라면 -> 지워질 블록
//					for (String point : check_fb(i, j, fb_board)) {
//						set.add(point); // 2x2 형태를 이루는 블록의 좌표를 set에 추가
//					}
////					for (String string : set) {
////						System.out.println(string);
////					}
////					System.out.println(set.size());
//				}
//			}
//		}
//
//		return set;
//	}
//
//	private String[] check_fb(int i, int j, char[][] board) {
//		String[] set = new String[4];
//
//		char[] four = { board[i][j], board[i][j + 1], board[i + 1][j + 1], board[i + 1][j] };
//
////    	for (char c : four) {
////			System.out.println(c);
////		}
//
//		boolean eq = true;
//
//		if (four[0] == '0') {
//			eq = false;
//		} else {
//			for (int k = 1; k < four.length; k++) {
//				if (four[0] != four[k]) {
//					eq = false;
//					break;
//				}
//			}
//		}
//
//		if (eq) {
//			set[0] = i + "" + j;
//			set[1] = i + "" + (j + 1);
//			set[2] = (i + 1) + "" + (j + 1);
//			set[3] = (i + 1) + "" + j;
//		}
////    	for (String string : set) {
////    		System.out.println(string);
////    	}
////    	System.out.println();
//
//		return set;
//	}
//}