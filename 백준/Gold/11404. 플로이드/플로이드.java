import java.io.*;
import java.util.*;

class Main {
	static int[][] dis;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		dis = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dis[i], Integer.MAX_VALUE / 2);
			dis[i][i] = 0;
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			dis[A][B] = Math.min(dis[A][B], C);
		}

		// 플로이드-워셜 알고리즘
		for (int K = 1; K <= n; K++) {
			for (int S = 1; S <= n; S++) {
				for (int E = 1; E <= n; E++) {
					if (dis[S][E] > dis[S][K] + dis[K][E])
						dis[S][E] = dis[S][K] + dis[K][E];
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dis[i][j] == Integer.MAX_VALUE / 2)
					System.out.printf("0 ");
				else
					System.out.printf("%d ", dis[i][j]);
			}
			System.out.println();
		}
	}
}