package done;

import java.util.LinkedList;

public class 두큐의합같게만들기 {

	public static void main(String[] args) {
//		int[] queue1 = {3, 2, 7, 2};
//		int[] queue2 = {4, 6, 5, 1};
		int[] queue1 = {1, 2, 1, 2};
		int[] queue2 = {1, 10, 1, 2};
//		int[] queue1 = {1, 1};
//		int[] queue2 = {1, 5};
//		int[] queue1 = {1, 4};
//		int[] queue2 = {4, 8};
		TwoQueueSum tqs = new TwoQueueSum();
		int result = tqs.solution(queue1, queue2);
		System.out.println(result);
	}

}
class TwoQueueSum {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        long all = 0, sum1 = 0, sum2 = 0;
        
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        for (int i = 0; i < queue1.length; i++) {
			all += queue1[i];
			sum1 += queue1[i];
			list1.add(queue1[i]);
			
			all += queue2[i];
			sum2 += queue2[i];
			list2.add(queue2[i]);
		}
        
        if (all % 2 != 0)
        	return -1;
        
        long target = all / 2;
        int count = 0;
//        
//        for(Integer i : list1) {
//    		System.out.print(i + " ");
//    	}
//    	System.out.println("s1 : " + sum1);
//    	for(Integer i : list2) {
//    		System.out.print(i + " ");
//    	}
//    	System.out.println("s2 : " + sum2);
//        
        while (sum1 != target || sum2 != target) {
        	if (sum1 < sum2 && !list2.isEmpty()) {
        		int num = list2.pop();
//        		System.out.println("p" + num);
        		list1.add(num);
        		sum1 += num;
        		sum2 -= num;
        	} else if (sum1 > sum2 && !list1.isEmpty()) {
        		int num = list1.pop();
//        		System.out.println("p" + num);
        		list2.add(num);
        		sum2 += num;
        		sum1 -= num;
        	}
        	count++;
//        	
//        	for(Integer i : list1) {
//        		System.out.print(i + " ");
//        	}
//        	System.out.println("s1 : " + sum1);
//        	for(Integer i : list2) {
//        		System.out.print(i + " ");
//        	}
//        	System.out.println("s2 : " + sum2);
//        	
        	if (sum1 == target || sum2 == target)
        		break;
        	if (sum1 == 0 || sum2 == 0 || count >= 600000)
        		return -1;
        }
        answer = count;
        
        return answer;
    }
}