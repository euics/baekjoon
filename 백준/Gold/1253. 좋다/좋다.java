import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());

		long[] A = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Long.parseLong(st.nextToken());
		Arrays.sort(A);

		int answer = 0;
		for (int i = 0; i < N; i++) {
			long find = A[i];
			int start = 0, end = N - 1;

			while (start < end) {
				if (A[start] + A[end] == find) {
					if (start != i && end != i) {
						answer++;
						break;
					} else if (start == i)
						start++;
					else if (end == i)
						end--;
				} else if (A[start] + A[end] < find)
					start++;
				else
					end--;
			}
		}

		System.out.println(answer);
	}
}