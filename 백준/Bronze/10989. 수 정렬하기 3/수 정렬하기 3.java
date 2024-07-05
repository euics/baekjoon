import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(br.readLine());

		int maxNum = getMax(A);
		for (int exp = 1; maxNum / exp > 0; exp *= 10)
			countingSort(A, exp);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length; i++)
			sb.append(A[i]).append(" ");

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
		int[] count = new int[10];

		// 현재 자리수에 대한 count 배열 채우기
		for (int i = 0; i < A.length; i++) {
			int digit = (A[i] / exp) % 10;
			count[digit]++;
		}

		// count 배열을 업데이트하여 실제 위치 계산
		for (int i = 1; i < 10; i++)
			count[i] += count[i - 1];

		// output 배열 채우기
		for (int i = n - 1; i >= 0; i--) {
			int digit = (A[i] / exp) % 10;
			output[count[digit] - 1] = A[i];
			count[digit]--;
		}

		System.arraycopy(output, 0, A, 0, n);
	}
}