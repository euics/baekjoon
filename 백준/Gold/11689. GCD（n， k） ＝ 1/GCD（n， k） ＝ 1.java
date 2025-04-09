import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());

		System.out.println(phi(n));
	}

	public static long phi(long n) {
		long result = n;

		for (long p = 2; p <= Math.sqrt(n); p++) {
			if (n % p == 0) {
				result = result - result / p;

				while (n % p == 0) {
					n /= p;
				}
			}
		}

		if (n > 1) {
			result = result - result / n;
		}

		return result;
	}
}