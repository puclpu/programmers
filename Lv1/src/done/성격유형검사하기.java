package done;

public class 성격유형검사하기 {

	public static void main(String[] args) {
		MBTI mbti = new MBTI();
		String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
		int[] choices = { 5, 3, 2, 7, 5 };
		String result = mbti.solution(survey, choices);
		System.out.println(result);
	}

}

class MBTI {

	public String solution(String[] survey, int[] choices) {
		String answer = "";

		char[] person = { 'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N' }; // 성격 유형
		int[] score = new int[8]; // 성격 유형 점수

		for (int i = 0; i < survey.length; i++) {
			char da = '\0';
			int s = choices[i]; // 선택지
			if (s < 4) { // 비동의 관련 선택지
				da = survey[i].charAt(0); // 첫 번째 캐릭터
				if (s == 1) {
					s = 3;
				} else if (s == 3) {
					s = 1;
				}
			} else if (s > 4) { // 동의 관련 선택지
				da = survey[i].charAt(1); // 두 번째 캐릭터
				s -= 4;
			} else {
				continue; // 모르겠음 선택 시 점수를 얻지 않음.
			}
			for (int j = 0; j < person.length; j++) {
				if (da == person[j]) {
					score[j] += s; // 동일한 인덱스 값에 점수를 더하기
				}
			}
		}
		
		for (int i = 0; i < person.length; i = i + 2) {
			if (score[i] < score[i+1]) {
				answer += person[i+1];
			} else if (score[i] > score[i+1]) {
				answer += person[i];
			} else { // 성격 유형 점수가 같으면 사전 순으로 빠른 성격 유형
				if (person[i] > person[i+1]) {
					answer += person[i+1];
				} else {
					answer += person[i];
				}
			}
		}

		return answer;
	}

//    public String solution(String[] survey, int[] choices) {
//        String answer = "";
//        
//        int R = 0; int T = 0;
//        int C = 0; int F = 0;
//        int J = 0; int M = 0;
//        int A = 0; int N = 0;
//        
//        for (int i = 0; i < survey.length; i++) {
//        	char da = '\0';
//        	int s = choices[i];
//        	if (choices[i] < 4) {
//        		da = survey[i].charAt(0);
//        		if (s == 1) {
//        			s = 3;
//        		} else if (s == 3) {
//        			s = 1;
//        		}
//        	} else if (choices[i] > 4) {
//        		da = survey[i].charAt(1);
//        		s -= 4;
//        	} else {
//        		continue;
//        	}
//        	
//        	switch (da) {
//			case 'R':
//				R += s;
//				break;
//			case 'T':
//				T += s;
//				break;
//			case 'C':
//				C += s;
//				break;
//			case 'F':
//				F += s;
//				break;
//			case 'J':
//				J += s;
//				break;
//			case 'M':
//				M += s;
//				break;
//			case 'A':
//				A += s;
//				break;
//			case 'N':
//				N += s;
//				break;
//			}
//        	System.out.println(i + 1);
//        	System.out.println("R:" + R + " T:" + T);
//        	System.out.println("C:" + C + " F:" + F);
//        	System.out.println("J:" + J + " M:" + M);
//        	System.out.println("A:" + A + " N:" + N);
//        	System.out.println();
//		}
//        
//        answer += score(R, T, "RT");
//        answer += score(C, F, "CF");
//        answer += score(J, M, "JM");
//        answer += score(A, N, "AN");
//        
//        return answer;
//    }
//    
//    private char score(int left, int right, String person) {
//    	char l = person.charAt(0);
//    	char r = person.charAt(1);
//    	
//    	if (left < right) {
//    		return r;
//    	} else if (left > right) {
//    		return l;
//    	} else {
//    		if (l > r) {
//    			return r;
//    		} else {
//    			return l;
//    		}
//    	}
//    }
}