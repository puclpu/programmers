package sappy_pr;

public class No3131 {

	public static void main(String[] args) {
		for(int i = 1; i <= 1000000; i++) {
			if (is_Prime(i)) {
				System.out.print(i + " ");
			}
		}
	}

	private static boolean is_Prime(int n) {
		if (n == 1)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
