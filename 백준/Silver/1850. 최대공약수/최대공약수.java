import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long GCD = GCD(A, B);

		StringBuilder sb = new StringBuilder();
		while (GCD > 0) {
			sb.append("1");
			GCD--;
		}

		System.out.println(sb.toString());
	}

	public static long GCD(long a, long b) {
		if (b == 0)
			return a;

		return GCD(b, a % b);
	}
}