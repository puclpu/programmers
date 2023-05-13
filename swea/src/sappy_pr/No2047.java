package sappy_pr;

import java.util.Scanner;

public class No2047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
//		T=sc.nextInt();
		T = 1;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			String str = sc.next();
            int[] arr = new int[str.length()];
            for(int i = 0; i < arr.length; i++) {
            	if (str.charAt(i) > 64 && str.charAt(i) <91) {
            		arr[i] = str.charAt(i) - 65;
            	} else if (str.charAt(i) > 96 && str.charAt(i) < 123) {
            		arr[i] = str.charAt(i) - 71;
            	} else if (str.charAt(i) > 47 && str.charAt(i) < 58) {
            		arr[i] = str.charAt(i) + 4;
            	} else if (str.charAt(i) == '+') {
            		arr[i] = 62;
            	} else if (str.charAt(i) == '/') {
            		arr[i] = 63;
            	}
            }
            // 10진수 -> 6자리 2진수
            String six = "";
            for (int i = 0; i < arr.length; i++) {
				six = six + int_to_six(arr[i]);
			}
            // 2진수를 8비트씩 잘라 10진수로 변환
            for (int i = 0; i < arr.length-8; i = i + 8) {
            	int n = eight_to_int(six.substring(i, i+8));
            	System.out.print((char)n);
			}
		}
		sc.close();
	}

	private static String int_to_six(int n) {
		String s = "";
		
		while (n > 0) {
			s = s + n % 2;
			n = n / 2;
		}
		
		return s;
	}
	
	private static int eight_to_int(String s) {
		int n = 0;
		
		int d = 1;
		for (int i = s.length()-1; i >= 0; i--) {
			n += d * (s.charAt(i) - '0');
			d *= 2;
		}
		
		return n;
	}

}
