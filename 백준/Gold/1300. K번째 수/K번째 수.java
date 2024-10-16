import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(br.readLine());
		long K = Long.parseLong(br.readLine());

		long start = 1, end = N * N, answer = Long.MAX_VALUE;
		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;

			for (long i = 1; i <= N; i++) {
				sum += Math.min(mid / i, N);
			}

			if (sum >= K) {
				answer = Math.min(answer, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(answer);
	}
}