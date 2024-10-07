import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] operator = new int[4];
	static int maxDepth = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		DFS(0, arr[0]);

		System.out.println(max);
		System.out.println(min);
	}

	public static void DFS(int L, int result) {
		if (L == arr.length - 1) {
			max = Math.max(max, result);
			min = Math.min(min, result);

			return;
		}

		for (int d = 0; d < 4; d++) {
			if (operator[d] > 0) {
				switch (d) {
					case 0:
						operator[d]--;
						DFS(L + 1, result + arr[L + 1]);
						operator[d]++;
						break;
					case 1:
						operator[d]--;
						DFS(L + 1, result - arr[L + 1]);
						operator[d]++;
						break;
					case 2:
						operator[d]--;
						DFS(L + 1, result * arr[L + 1]);
						operator[d]++;
						break;
					case 3:
						operator[d]--;
						DFS(L + 1, result / arr[L + 1]);
						operator[d]++;
						break;
				}
			}
		}
	}
}