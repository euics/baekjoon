import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		System.out.println(kadaneAlgorithm(arr));
	}

	public static int kadaneAlgorithm(int[] arr) {
		int maxSum = arr[0];
		int curSum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			curSum = Math.max(arr[i], curSum + arr[i]);
			maxSum = Math.max(maxSum, curSum);
		}

		return maxSum;
	}
}