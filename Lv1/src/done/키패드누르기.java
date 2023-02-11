package done;

public class 키패드누르기 {

	public static void main(String[] args) {
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		KeypadPressing kp = new KeypadPressing();
		String result = kp.solution(numbers, hand);
		System.out.println(result);
	}

}

class KeypadPressing {
	public String solution(int[] numbers, String hand) {
		String answer = "";
		StringBuilder sb = new StringBuilder();

		int l = 10;
		int r = 12;

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0 || numbers[i] % 3 == 2) { // 2 5 8 0
				int target = numbers[i];
				if (target == 0)
					target = 11;
				
				int ld = distance(target, l);
				int rd = distance(target, r);

				if (ld < rd) {
					l = target;
					sb.append('L');
				} else if (rd < ld) {
					r = target;
					sb.append('R');
				} else {
					if (hand.equals("left")) {
						l = target;
						sb.append('L');
					} else {
						r = target;
						sb.append('R');
					}
				}
				System.out.println();
			} else if (numbers[i] % 3 == 1) { // 1 4 7
				l = numbers[i];
				sb.append('L');
			} else { // 3 6 9
				r = numbers[i];
				sb.append('R');
			}
		}
		answer = sb.toString();

		return answer;
	}
	
	public int distance(int target, int n) {
		int d = 0;
		
//		keypad
//		1 (0.0)		2 (0.1) 	3 (0.2)
//		4 (1.0)		2 (1.1) 	3 (1.2)
//		7 (2.0)		2 (2.1) 	3 (2.2)
//		* (3.0)		0 (3.1) 	# (3.2)
		
		int tx = (target-1) / 3;
		int ty = target % 3;
		if (ty > 0) {
			ty--;
		} else {
			ty = ty + 2;
		}
		
		int nx = (n-1) / 3;
		int ny = n % 3;
		if (ny > 0) {
			ny--;
		} else {
			ny = ny + 2;
		}
		
		int xd = tx - nx;
		if (xd < 0)
			xd = xd * (-1);
		int yd = ty - ny;
		if (yd < 0)
			yd = yd * (-1);
		
		d = xd + yd;
		
		return d;
	}
//	public int distance(int target, int n) {
//		int d = 0;
//		
//		switch (target) {
//		case 2:
//			if (n == 1 || n == 3 || n == 5) {
//				d = 1;
//			} else if (n == 4 || n == 6 || n == 8) {
//				d = 2;
//			} else if (n == 7 || n == 9 || n == 11) {
//				d = 3;
//			} else if (n == 10 || n == 12) {
//				d = 4;
//			}
//			break;
//		case 5:
//			if (n == 2 || n == 4 || n == 6 || n == 8) {
//				d = 1;
//			} else if (n == 1 || n == 3 || n == 7 || n == 9 || n == 11) {
//				d = 2;
//			} else if (n == 10 || n == 12) {
//				d = 3;
//			}
//			break;
//		case 8:
//			if (n == 7 || n == 5 || n == 9 || n == 11) {
//				d = 1;
//			} else if (n == 2 || n == 4 || n == 6 || n == 10 || n == 12) {
//				d = 2;
//			} else if (n == 1 || n == 3) {
//				d = 3;
//			}
//			break;
//		case 11:
//			if(n == 8 || n == 10 || n == 12) {
//				d = 1;
//			} else if (n == 7 || n == 9 || n == 5) {
//				d = 2;
//			} else if (n == 2 || n == 4 || n == 6) {
//				d = 3;
//			} else if (n == 1 || n == 3) {
//				d = 4;
//			}
//			break;
//		}
//		
//		return d;
//	}
}