import java.io.*;
import java.util.*;

public class Main {
	public static int[][] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		dis = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dis[i], Integer.MAX_VALUE / 2);
			dis[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			dis[A][B] = 1;
			dis[B][A] = 1;
		}

		for (int K = 1; K <= N; K++) {
			for (int S = 1; S <= N; S++) {
				for (int E = 1; E <= N; E++) {
					if (dis[S][E] > dis[S][K] + dis[K][E])
						dis[S][E] = dis[S][K] + dis[K][E];
				}
			}
		}

		int min = Integer.MAX_VALUE, index = -1;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++)
				sum += dis[i][j];

			if (min > sum) {
				min = sum;
				index = i;
			}
		}

		System.out.println(index);
	}
}