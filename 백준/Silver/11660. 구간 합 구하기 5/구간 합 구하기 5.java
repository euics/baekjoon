import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		int[][] D = new int[n + 1][n + 1];
		for (int row = 1; row < n + 1; row++) {
			for (int col = 1; col < n + 1; col++)
				D[row][col] = D[row - 1][col] + D[row][col - 1] - D[row - 1][col - 1] + arr[row - 1][col - 1];
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			System.out.println(D[y2][x2] - D[y1 - 1][x2] - D[y2][x1 - 1] + D[y1 - 1][x1 - 1]);
		}
	}
}