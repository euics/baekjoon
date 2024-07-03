import java.io.*;
import java.util.*;

class Main {

	static int[] sorted;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		sorted = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(br.readLine());

		mergeSort(A, 0, N - 1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) sb.append(A[i]).append("\n");
		System.out.println(sb.toString());
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
			if (A[l] <= A[r]) {
				sorted[idx] = A[l];
				idx++;
				l++;
			} else {
				sorted[idx] = A[r];
				idx++;
				r++;
			}
		}

		if (l > mid) {
			while (r <= right) {
				sorted[idx] = A[r];
				idx++;
				r++;
			}
		} else {
			while (l <= mid) {
				sorted[idx] = A[l];
				idx++;
				l++;
			}
		}

		for (int i = left; i <= right; i++)
			A[i] = sorted[i];
	}
}