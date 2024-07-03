import java.io.*;
import java.util.*;

class Main {

	static int[] sorted;
	static long answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		sorted = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		mergeSort(A, 0, N - 1);
		System.out.println(answer);
	}

	public static void mergeSort(int[] A, int left, int right) {
		if (left == right)
			return;

		int mid = (left + right) / 2;
		mergeSort(A, left, mid);
		mergeSort(A, mid + 1, right);

		merge(A, left, mid, right);
	}

	public static void merge(int[] A, int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int idx = left;

		while (l <= mid && r <= right) {
			if (A[l] <= A[r])
				sorted[idx++] = A[l++];
			else {
				sorted[idx++] = A[r++];
				answer += (mid + 1 - l);
			}
		}

		while (l <= mid)
			sorted[idx++] = A[l++];
		while (r <= right)
			sorted[idx++] = A[r++];

		for (int i = left; i <= right; i++)
			A[i] = sorted[i];
	}
}