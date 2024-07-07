import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		// int max = getMax(A);
		// for (int exp = 1; max / exp > 0; exp *= 10)
		// 	countingSort(A, exp);

		Arrays.sort(A);

		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int result = binarySearch(A, num);
			sb.append(result).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static int getMax(int[] A) {
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			if (max < A[i])
				max = A[i];
		}

		return max;
	}

	public static void countingSort(int[] A, int exp) {
		int n = A.length;
		int[] output = new int[n];
		int[] counting = new int[10];

		for (int i = 0; i < n; i++) {
			int digit = (A[i] / exp) % 10;
			counting[digit]++;
		}

		for (int i = 1; i < 10; i++)
			counting[i] += counting[i - 1];

		for (int i = n - 1; i >= 0; i--) {
			int digit = (A[i] / exp) % 10;
			output[counting[digit] - 1] = A[i];
			counting[digit]--;
		}

		System.arraycopy(output, 0, A, 0, n);
	}

	public static int binarySearch(int[] A, int num) {
		int start = 0, end = A.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] == num)
				return 1;
			else if (A[mid] > num)
				end = mid - 1;
			else
				start = mid + 1;
		}

		return 0;
	}
}