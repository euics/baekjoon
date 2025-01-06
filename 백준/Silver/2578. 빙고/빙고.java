import java.util.*;
import java.io.*;

public class Main {
	static Map<Integer, int[]> map = new HashMap<>();
	static int[][] bingo = new int[5][5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
				map.put(bingo[i][j], new int[] {j, i});
			}
		}

		int[] numbers = new int[25];
		for (int i = 0, idx = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 5; j++) {
				numbers[idx++] = Integer.parseInt(st.nextToken());
			}
		}

		int[] rowBingo = new int[5];
		int[] colBingo = new int[5];
		int diag1 = 0, diag2 = 0;
		for (int i = 0; i < 25; i++) {
			int bingoCnt = 0;

			int[] pos = map.get(numbers[i]);
			int x = pos[0], y = pos[1];

			if (x == y)
				diag1++;
			if (x + y == 4)
				diag2++;
			rowBingo[y]++;
			colBingo[x]++;

			if (diag1 == 5)
				bingoCnt++;
			if (diag2 == 5)
				bingoCnt++;
			for (int j = 0; j < 5; j++) {
				if (rowBingo[j] == 5)
					bingoCnt++;
				if (colBingo[j] == 5)
					bingoCnt++;
			}

			if (bingoCnt >= 3) {
				System.out.println(i + 1);
				break;
			}
		}
	}
}