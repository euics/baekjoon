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

		int start = 1, end = 1, sum = 0, answer = 0;
		while (start <= N) {
			if (sum + arr[end] < N)
				sum += arr[end++];
			else if (sum + arr[end] == N) {
				answer++;
				sum += arr[end++];
				sum -= arr[start++];
			} else
				sum -= arr[start++];
		}

		System.out.println(answer);
	}
}