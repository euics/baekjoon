import java.io.*;
import java.util.*;

class Main {
	static int[][] dis;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		dis = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(dis[i], Integer.MAX_VALUE / 2);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());

				if (input == 1)
					dis[i][j] = Math.min(dis[i][j], 1);
			}
		}

		for (int K = 0; K < N; K++) {
			for (int S = 0; S < N; S++) {
				for (int E = 0; E < N; E++) {
					if (dis[S][E] > dis[S][K] + dis[K][E]) {
						dis[S][E] = dis[S][K] + dis[K][E];
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dis[i][j] != Integer.MAX_VALUE / 2)
					System.out.printf("1 ");
				else
					System.out.printf("0 ");
			}
			System.out.println();
		}
	}
}