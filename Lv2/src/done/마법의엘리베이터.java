package done;

public class 마법의엘리베이터 {

	public static void main(String[] args) {
//		int storey = 16;
//		int storey = 2554;
//		int storey = 95;
//		int storey = 45;
		int storey = 646;
		MagicalElevator me = new MagicalElevator();
		int result = me.solution(storey);
		System.out.println(result);
	}

}
class MagicalElevator {
    public int solution(int storey) {
        int answer = 0;
        
        // 큼 큼 =     (10 - 큼)   + (10 - 큼)
        // 큼 작 = (1 + 10 - 큼)   + 작
        // 작 큼 = 작   + 1        + (10 - 큼)
        // 작 작 = 작              + 작
        
        // 96(큼큼), 93(큼작), 39(작큼), 31(작작)
        // 95(큼큼), 55(큼큼,작작), 45(작작)
        // 56(큼큼), 54(작작)
        
        // 1+-, 10+-, 100+-
        int count = 0;
        String ss = storey + "";
        int[] arr = new int[ss.length()];
        for (int i = 0; i < arr.length; i++) {
			arr[i] = ss.charAt(i) - '0';
		}
        
        for (int i = arr.length-1; i >= 0; i--) {
			if (arr[i] > 5) {
				count += 10 - arr[i];
				
				if (i == 0){
					count++;
				} else {
					arr[i-1]++;
				}
			} else if (arr[i] == 5 && i > 0 && arr[i-1] >= 5) {
				arr[i-1]++;
				count += 5;
			} else {
				count += arr[i];
			}
		}
        
        
        answer = count;
        
        return answer;
    }
}