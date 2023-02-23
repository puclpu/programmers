package done;

import java.util.ArrayList;

public class 개인정보수집유효기간 {

	public static void main(String[] args) {
		String today = "2021.12.08";
		String[] terms = {"A 18"};
		String[] privacies = {"2020.06.08 A"};
		PrivacyCollectionValidityPeriod pcvp = new PrivacyCollectionValidityPeriod();
		int[] result = pcvp.solution(today, terms, privacies);
		for (int i : result) {
			System.out.println(i);
		}
	}

}
class PrivacyCollectionValidityPeriod {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        
        String[] today_ymd = today.split("\\.");
        
        String[] t_term = new String[terms.length];
        int[] t_month = new int[terms.length];
        for (int i = 0; i < terms.length; i++) {
        	String[] str = terms[i].split(" ");
        	t_term[i] = str[0]; // 약관 종류
        	t_month[i] = Integer.parseInt(str[1]); // 유효기간
        }
        
        for (int i = 0; i < privacies.length; i++) {
        	// pdate_ptrem[0] = 수집된 날짜, pdate_pterm[1] = 약관 종류
			String[] pdate_pterm = privacies[i].split(" ");
			
			for (int j = 0; j < terms.length; j++) {
				if (pdate_pterm[1].equals(t_term[j])) { // 수집된 개인정보의 약관 종류를 terms에서 찾기
					int[] ddate = destroy_date(pdate_pterm[0], t_month[j]); // 파기해야 할 날짜
					
					if (check_destory(ddate, today_ymd)) { // 파기해야 할 개인정보라면
						list.add(i + 1);
					}
				}
			}
		}
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
    private boolean check_destory(int[] date, String[] today) { // 파기해야할 날짜, 오늘 날짜
    	int ty = Integer.parseInt(today[0]);
    	int tm = Integer.parseInt(today[1]);
    	int td = Integer.parseInt(today[2]);
    	
    	if (date[0] < ty) {
    		return true;
    	} else if (date[0] == ty) {
    		if (date[1] < tm) {
    			return true;
    		} else if (date[1] == tm && date[2] < td) {
    			return true;
    		}
    	}
    	
    	
    	return false;
    }
    
    private int[] destroy_date(String date, int month) { // 수집된 날짜, 유효기간
    	int[] d_date = new int[3];
    	
    	String[] str = date.split("\\.");
    	int yy = Integer.parseInt(str[0]);
    	int mm = Integer.parseInt(str[1]);
    	int dd = Integer.parseInt(str[2]);
    	
    	dd += (month * 28) - 1;
    	if (dd > 28) {
    		mm += (dd / 28);
    		dd = dd % 28;
    	}
    	if (dd == 0) {
    		dd = 28;
    		mm--;
    	}
    	
    	if (mm > 12) {
    		yy += (mm / 12);
    		mm = mm % 12;
    	}
    	if (mm == 0) {
    		mm = 12;
    		yy--;
    	}
    	
    	d_date[0] = yy;
    	d_date[1] = mm;
    	d_date[2] = dd;
    	
    	return d_date;
    }
}