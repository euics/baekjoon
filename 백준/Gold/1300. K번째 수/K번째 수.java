import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(br.readLine());
		long k = Long.parseLong(br.readLine());

		long start = 1, end = N * N, answer = -1;
		while (start <= end) {
			long mid = (start + end) / 2;

			long sum = 0;
			for (int i = 1; i <= N; i++)
				sum += Math.min(mid / i, N);

			if (sum >= k) {
				answer = mid;
				end = mid - 1;
			} else
				start = mid + 1;
		}

		System.out.println(answer);
	}
}