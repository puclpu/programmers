package done;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 주차요금계산 {

	public static void main(String[] args) {
//		int[] fees = {180, 5000, 10, 600};
//		String[] records = {"05:34 5961 IN",
//				"06:00 0000 IN",
//				"06:34 0000 OUT",
//				"07:59 5961 OUT",
//				"07:59 0148 IN",
//				"18:59 0000 IN",
//				"19:09 0148 OUT",
//				"22:59 5961 IN",
//				"23:00 5961 OUT"};
//		int[] fees = {120, 0, 60, 591};
//		String[] records = {"16:00 3961 IN",
//				"16:00 0202 IN",
//				"18:00 3961 OUT",
//				"18:00 0202 OUT",
//				"23:58 3961 IN"};
		int[] fees = {1, 461, 1, 10};
		String[] records = {"00:00 1234 IN"};
		ParkingFeeCalculation pfc = new ParkingFeeCalculation();
		int[] result = pfc.solution(fees, records);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
class ParkingFeeCalculation {
	
    public int[] solution(int[] fees, String[] records) {
        int[] answer;

        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
			String[] str = records[i].split(" ");
//			System.out.println(str[0] + " " + str[1] + " " + str[2]);
			if (map.containsKey(str[1])) {
				ArrayList<String> list = map.get(str[1]);
				list.add(str[0]);
				map.put(str[1], list);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(str[0]);
				map.put(str[1], list);
			}
		}
        
        // 키 값으로 정렬
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        
        answer = new int[keySet.size()];
        int n = 0;
        
        for (String string : keySet) {
			ArrayList<String> list = map.get(string);
			System.out.println(string);
			if (list.size() % 2 != 0) { 
				// 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주
				list.add("23:59");
			}
			
			// 누적 주차 시간 계산
			Map<String, Integer> usage = new HashMap<>();
			usage.put(string, 0);
			for (int i = 0; i < list.size()-1; i = i + 2) {
				String[] in = list.get(i).split(":");
				String[] out = list.get(i + 1).split(":");
				System.out.println(in[0] + " " + in[1] + " " + out[0] + " " + out[1]);
				int usage_time = calc_usage(in, out);
				System.out.println(usage_time);
				usage.put(string, usage.get(string) + usage_time);
			}
//			System.out.println(usage.get(string));
			
			// 주차 요금
			if (usage.get(string) >= fees[0]) {
//				System.out.println(5000 + " + tpp * 600");
				int up = (int) Math.ceil((usage.get(string) - fees[0]) / (double)fees[2]); // 올림
//				System.out.println("(" + usage.get(string) + " - 180) * 600 = " + tpp);
//				System.out.println(ttp + " " + dttp);
				answer[n] = fees[1] + up * fees[3];
//				System.out.println(tpp);
			} else {
				answer[n] = fees[1];
			}
			n++;
		}
        
        return answer;
    }
    private int calc_usage(String[] in, String[] out) {
    	int usage = 0;
    	
    	int ih = Integer.parseInt(in[0]);
    	int im = Integer.parseInt(in[1]);
    	int oh = Integer.parseInt(out[0]);
    	int om = Integer.parseInt(out[1]);
    	
//    	System.out.println(ih + " " + im + " " + oh + " " + om);
    	
    	if (im > om) {
    		oh--;
    		om += 60;
    	} 
    	usage = (om - im) + (oh - ih) * 60;
    	
    	return usage;
    }
}