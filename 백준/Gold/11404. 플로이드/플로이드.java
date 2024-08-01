import java.io.*;
import java.util.*;

public class Main {
	public static int[][] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		dis = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dis[i], Integer.MAX_VALUE / 2);
			dis[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			dis[A][B] = Math.min(dis[A][B], C);
		}

		for (int K = 1; K <= N; K++) {
			for (int S = 1; S <= N; S++) {
				for (int E = 1; E <= N; E++) {
					if (dis[S][E] > dis[S][K] + dis[K][E])
						dis[S][E] = dis[S][K] + dis[K][E];
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dis[i][j] == Integer.MAX_VALUE / 2)
					System.out.printf("%d ", 0);
				else
					System.out.printf("%d ", dis[i][j]);
			}
			System.out.println();
		}
	}
}