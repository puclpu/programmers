package ing;

public class 파일명정렬 {

	public static void main(String[] args) {
		SortFileName sfn = new SortFileName();
//		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		String[] result = sfn.solution(files);
		for (String string : result) {
			System.out.println(string);
		}
	}

}
class SortFileName {
	private class Record{
		String HEAD;
		int NUMBER;
		
		public int compare_record (Record r2) {
			int result = 0;
			
			String rH = this.HEAD;
			int rN = this.NUMBER;
			
			int len = rH.length();
			if (rH.length() > r2.HEAD.length())
				len = r2.HEAD.length();
			
			for (int i = 0; i < len; i++) {
				char c1 = rH.charAt(i);
				char c2 = r2.HEAD.charAt(i);
				
				if (c1 > c2) {
					result = 1;
					break;
				} else if (c1 < c2) {
					result = -1;
					break;
				}
			}
			
			if (result == 0) {
				if (rH.length() < r2.HEAD.length()) {
					result = -1;
				} else if (rH.length() > r2.HEAD.length()) {
					result = 1;
				} else {
					if (rN > r2.NUMBER) {
						result = 1;
					} else if (rN < r2.NUMBER) {
						result = -1;
					}
				}
			}
			
			return result;
		}
	}
	
	public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        Record[] record = new Record[files.length];
        for (int i = 0; i < record.length; i++) {
			Record r = new Record();
			r = find_hnt(files[i]);
			record[i] = r;
		}
        
        for (int i = 0; i < record.length; i++) {
			for (int j = i + 1; j < record.length; j++) {
				if (record[i].compare_record(record[j]) > 0) {
					String tmp = files[i];
					files[i] = files[j];
					files[j] = tmp;
					
					Record rtmp = record[i];
					record[i] = record[j];
					record[j] = rtmp;

				}
			}
		}
        
        answer = files;
        
        return answer;
    }
	
	private Record find_hnt(String str) {
		Record record = new Record();
		int[] hnt = new int[2];
		
		int i = 0;
		while(i < str.length()) {
			char sc = str.charAt(i);
			if (sc >= '0' && sc <= '9') {
				hnt[0] = i;
				break;
			}
			i++;
		}
		
		int j = i;
		
		while(j < str.length() && j < i + 5) {
			char sc = str.charAt(j);
			if (sc < '0' || sc > '9') {
				hnt[1] = j;
				break;
			}
			j++;
		}
		
		String head = str.substring(0, hnt[0]);
		record.HEAD = head.toUpperCase();
        String number = str.substring(hnt[0], hnt[1]);
        record.NUMBER = Integer.parseInt(number);
        
        return record;
	}
}