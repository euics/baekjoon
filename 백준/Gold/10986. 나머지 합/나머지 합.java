import java.io.*;
import java.util.*;

class Main {
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long[] S = new long[N];
		S[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++)
			S[i] = S[i - 1] + Integer.parseInt(st.nextToken());

		long answer = 0;
		long[] C = new long[M];
		for (int i = 0; i < N; i++) {
			long remain = S[i] % M;

			if (remain == 0)
				answer++;

			C[(int)remain]++;
		}

		for (int i = 0; i < M; i++) {
			if (C[i] >= 2)
				answer += (C[i] * (C[i] - 1)) / 2;
		}

		System.out.println(answer);
	}
}

/*

 (Sa - Sb) % M == 0
 Sa % M == Sb % M

 1 2 3 1 2
 1 3 6 7 9

*/