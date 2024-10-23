import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long repeat = GCD(A, B);

		System.out.println("1".repeat((int)repeat));
	}

	public static long GCD(long a, long b) {
		if (b == 0) {
			return a;
		}

		return GCD(b, a % b);
	}
}