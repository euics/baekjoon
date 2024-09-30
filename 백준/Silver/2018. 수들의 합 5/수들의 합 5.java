import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = i;

		int p1 = 1, p2 = 1, sum = 0, answer = 0;
		while (p2 <= N && p1 <= p2) {
			if (sum < N)
				sum += arr[p2++];

			while (p1 <= p2 && sum > N)
				sum -= arr[p1++];

			if(sum == N) {
				answer++;
				sum -= arr[p1++];
			}
		}

		System.out.println(answer);
	}
}