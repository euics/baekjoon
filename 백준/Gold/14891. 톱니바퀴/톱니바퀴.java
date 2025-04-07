import java.util.*;
import java.io.*;

public class Main {
	static int answer = 0;
	static int[][] arr = new int[4][8];
	static int K;
	static int[][] info;

	public static void main(String[] args) throws IOException {
		init();

		for (int i = 0; i < K; i++) {
			int[] dir = new int[4];
			dir[info[i][0]] = info[i][1];

			for (int sequence = info[i][0] - 1; sequence >= 0; sequence--) {
				if (arr[sequence][2] != arr[sequence + 1][6]) {
					dir[sequence] = -dir[sequence + 1];
				} else {
					break;
				}
			}

			for (int sequence = info[i][0] + 1; sequence < 4; sequence++) {
				if (arr[sequence][6] != arr[sequence - 1][2]) {
					dir[sequence] = -dir[sequence - 1];
				} else {
					break;
				}
			}

			for (int sequence = 0; sequence < 4; sequence++) {
				if (dir[sequence] == 1) {
					rotateRight(sequence);
				} else if (dir[sequence] == -1) {
					rotateLeft(sequence);
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			if (arr[i][0] == 1) {
				answer += (int)Math.pow(2, i);
			}
		}

		System.out.println(answer);
	}

	public static void rotateRight(int sequence) {
		int tmp = arr[sequence][7];
		for (int i = 7; i >= 1; i--) {
			arr[sequence][i] = arr[sequence][i - 1];
		}
		arr[sequence][0] = tmp;
	}

	public static void rotateLeft(int sequence) {
		int tmp = arr[sequence][0];
		for (int i = 0; i <= 6; i++) {
			arr[sequence][i] = arr[sequence][i + 1];
		}
		arr[sequence][7] = tmp;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			String input = br.readLine();
			for (int j = 0; j < 8; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
			}
		}

		K = Integer.parseInt(br.readLine());
		info = new int[K][2];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sequence = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());

			info[i][0] = sequence;
			info[i][1] = dir;
		}
	}
}