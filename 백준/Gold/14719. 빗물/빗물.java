import java.util.*;
import java.io.*;

public class Main {
	static int[][] world;
	static int H, W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		world = new int[H][W];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int rain = Integer.parseInt(st.nextToken());

			int row = H - 1;
			while (rain > 0) {
				world[row][i] = 1;
				row--;
				rain--;
			}
		}

		int cnt = 0;
		for (int row = H - 1; row >= 0; row--) {
			for (int col = 0; col < W; col++) {
				if(world[row][col] == 0) {
					if (left(row, col) && right(row, col)) {
						world[row][col] = 1;
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);
	}

	public static boolean left(int row, int col) {
		while (col >= 0) {
			if (world[row][col] == 1) {
				return true;
			}

			col--;
		}

		return false;
	}

	public static boolean right(int row, int col) {
		while (col < W) {
			if (world[row][col] == 1) {
				return true;
			}

			col++;
		}

		return false;
	}
}