import java.util.*;
import java.io.*;

public class Main {
	static int answer = 0;
	static int[][] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		dis = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dis[i], Integer.MAX_VALUE / 2);
			dis[i][i] = 0;
		}

		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			dis[a][b] = Math.min(dis[a][b], 1);
		}

		for (int K = 1; K <= N; K++) {
			for (int S = 1; S <= N; S++) {
				for (int E = 1; E <= N; E++) {
					if (dis[S][E] > dis[S][K] + dis[K][E]) {
						dis[S][E] = dis[S][K] + dis[K][E];
					}
				}
			}
		}

		for (int src = 1; src <= N; src++) {
			int sum = 0;

			for (int des = 1; des <= N; des++) {
				if (dis[src][des] != Integer.MAX_VALUE / 2 || dis[des][src] != Integer.MAX_VALUE / 2) {
					sum++;
				}
			}

			if (sum == N) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}