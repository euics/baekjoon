import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);

		int start = 0, end = N - 1, answer = 0;
		while (start < end) {
			int sum = arr[start] + arr[end];

			if (sum > M)
				end--;
			else if (sum < M)
				start++;
			else {
				answer++;
				start++;
			}
		}

		System.out.println(answer);
	}
}