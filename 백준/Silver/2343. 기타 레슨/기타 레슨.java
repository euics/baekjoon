import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		int max = 0, min = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max += arr[i];
			min = Math.max(min, arr[i]);
		}

		int answer = Integer.MAX_VALUE;
		while (min <= max) {
			int mid = (min + max) / 2;

			if (blueRay(mid, M)) {
				answer = Math.min(answer, mid);
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}

		System.out.println(answer);
	}

	public static boolean blueRay(int mid, int M) {
		int cnt = 1, sum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (sum + arr[i] > mid) {
				cnt++;
				sum = 0;
			}

			sum += arr[i];
		}

		return cnt <= M;
	}
}