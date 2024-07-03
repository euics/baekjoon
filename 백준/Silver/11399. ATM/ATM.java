import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			P[i] = Integer.parseInt(st.nextToken());

		for (int target = 1; target < N; target++) {
			for (int compare = target; compare > 0; compare--) {
				if (P[compare] < P[compare - 1]) {
					int tmp = P[compare];
					P[compare] = P[compare - 1];
					P[compare - 1] = tmp;
				} else
					break;
			}
		}

		int[] accumulate = new int[N + 1];
		int answer = 0;
		for (int i = 0; i < N; i++) {
			accumulate[i + 1] = accumulate[i] + P[i];
			answer += accumulate[i];
		}

		answer += accumulate[N];
		System.out.println(answer);
	}
}