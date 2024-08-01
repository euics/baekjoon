import java.io.*;
import java.util.*;

public class Main {
	public static int[][] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());

		dis = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int edge = Integer.parseInt(st.nextToken());
				dis[i][j] = edge;
			}
		}

		for (int K = 0; K < N; K++) {
			for (int S = 0; S < N; S++) {
				for (int E = 0; E < N; E++) {
					if (dis[S][K] == 1 && dis[K][E] == 1)
						dis[S][E] = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.printf("%d ", dis[i][j]);
			System.out.println();
		}
	}
}