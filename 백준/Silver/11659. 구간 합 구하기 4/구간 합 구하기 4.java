import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] sum = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			sum[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++)
			sum[i] += sum[i - 1];

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			if (a == 0)
				sb.append(sum[b]).append("\n");
			else
				sb.append(sum[b] - sum[a - 1]).append("\n");
		}

		System.out.println(sb.toString());
	}
}