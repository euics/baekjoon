import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long answer = 0;
		long[] S = new long[n];
		long[] C = new long[m];
		st = new StringTokenizer(br.readLine());
		S[0] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < n; i++)
			S[i] = S[i - 1] + Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			int remain = (int)(S[i] % m);

			if (remain == 0)
				answer++;

			C[remain]++;
		}

		for (int i = 0; i < m; i++) {
			if (C[i] > 1)
				answer += (C[i] * (C[i] - 1)) / 2;
		}

		System.out.println(answer);
	}
}