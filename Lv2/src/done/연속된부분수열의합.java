package done;


public class 연속된부분수열의합 {
	public static void main(String[] args) {
		SumOfSS soss = new SumOfSS();
		int[] sequence = {1, 2, 3, 4, 5};
//		int[] sequence = {1, 1, 1, 2, 3, 4, 5};
//		int[] sequence = {2, 2, 2, 2, 2};
		int[] result = soss.solution(sequence, 7);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}

class SumOfSS {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
//        System.out.println("s e sum");
        
        int sum = 0;
        int start = 0, end = 0;
        int len = -1;
        for (;  start < sequence.length; start++) {
			while(end < sequence.length && sum < k) {
				sum += sequence[end++];
			}
			
			if (sum == k) {
				if (len == -1 || len > end - start) {
					answer[0] = start;
					answer[1] = end-1;
					len = end - start;
				}
			}
			
			sum -= sequence[start];
		}
//        while(start < sequence.length) {
//        	if (sum > k || end == sequence.length-1) {
//        		sum -= sequence[start++];
////        		System.out.println(start + " " + end + " " + sum);
//        	} else if (sum < k) {
//        		sum += sequence[++end];
////        		System.out.println(start + " " + end + " " + sum);
//        	}
//        	
//        	if (sum == k) {
//        		if (len == -1 || len > end - start) {
////        			System.out.println(">>" + start + " " + end);
//        			answer[0] = start;
//        			answer[1] = end;
//        			if (start == end && start == sequence.length-1) {
//        				break;
//        			}
//        			len = end - start;
//        			start = end;
//        			end--;
//        			sum = 0;
//        		}
//        	}
//        }
        
        return answer;
    }
}