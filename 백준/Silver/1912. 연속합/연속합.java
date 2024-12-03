import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(kadane(arr));
	}

	public static int kadane(int[] arr) {
		int maxSum = arr[0];
		int curSum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			curSum = Math.max(arr[i], curSum + arr[i]);
			maxSum = Math.max(maxSum, curSum);
		}

		return maxSum;
	}
}