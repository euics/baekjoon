import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());

		while (true) {
			if (isPalindrome(String.valueOf(N), 0, String.valueOf(N).length() - 1)) {
				if (isPrime(N)) {
					System.out.println(N);
					break;
				}
			}

			N++;
		}
	}

	public static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		if (num == 2)
			return true;
		if (num % 2 == 0)
			return false;

		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0)
				return false;
		}

		return true;
	}

	public static boolean isPalindrome(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}

		return true;
	}
}