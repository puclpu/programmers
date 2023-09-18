package done;

public class 방금그곡 {

	public static void main(String[] args) {
//		String m = "ABCDEFG";
//		String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
//		String m = "CC#BCC#BCC#BCC#B";
//		String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
//		String m = "ABC";
//		String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		String m = "A#";
		String[] musicinfos = {"13:00,13:02,HAPPY,BA#"};
		
		ThatMusic tm = new ThatMusic();
		String result = tm.solution(m, musicinfos);
		System.out.println(result);
	}

}
class ThatMusic {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        int max = 0;
        
        for (int i = 0; i < musicinfos.length; i++) {
			String[] mf = musicinfos[i].split(",");
			
			// 재생 시간 계산
			int pt = playtime(mf[0], mf[1]);
			
			// 재생된 코드
			String pc = playedcode(pt, mf[3]);
			
			// 재생된 코드에 m이 포함되는지 확인
			boolean exist = pc_contain_m(pc, m);
			
			// 가장 긴 재생길이인지 확인
			if (exist && pt > max) {
				max = pt;
				answer = mf[2];
			}
		}
        
        return answer;
    }
    
    private boolean pc_contain_m(String pc, String m) {
    	boolean exist = false;
    	
    	for (int i = 0; i <= pc.length() - m.length(); i++) {
			if (pc.charAt(i) == m.charAt(0)) {
				if (i + m.length() < pc.length() && pc.charAt(i+m.length()) == '#') {
					continue;
				}
				String target = pc.substring(i, i+m.length());
				if (target.compareTo(m) == 0) {
					exist = true;
				}
			}
		}
    	
    	return exist;
    }
    
    private String playedcode(int pt, String code) {
    	String pc = "";
    	
    	String notshap = code.replaceAll("#", "");
    	int ins = notshap.length();
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < pt / ins; i++) {
			sb.append(code);
		}
    	
    	int count = 0, i = 0;
    	while (count < pt % ins) {
    		sb.append(code.charAt(i));
    		count++;
    		if(code.charAt(i+1) == '#') {
    			sb.append('#');
    			i++;
    		}
    		i++;
    	}
    	
    	pc = sb.toString();
    	
    	return pc;
    }
    
    private int playtime(String st, String et) {
    	int pt = 0;
    	
    	String[] st_arr = st.split(":");
    	String[] et_arr = et.split(":");
    	
    	int h = Integer.parseInt(et_arr[0]) - Integer.parseInt(st_arr[0]);
    	if (h > 0) {
    		pt = h * 60;
    	}
    	pt += Integer.parseInt(et_arr[1]) - Integer.parseInt(st_arr[1]);
    	
    	return pt;
    }
}