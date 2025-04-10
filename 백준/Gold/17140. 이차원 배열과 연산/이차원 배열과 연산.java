import java.util.*;
import java.io.*;

public class Main {
	static int r, c, k;
	static int[][] arr = new int[100][100];

	public static void main(String[] args) throws IOException {
		init();

		int time = 0;
		while (time <= 100) {
			if (arr[r][c] == k) {
				System.out.println(time);
				System.exit(0);
			}

			int col = col();
			int row = row();

			if (col >= row) {
				R();
			} else {
				C();
			}

			time++;
		}

		System.out.println(-1);
		//
		// for (int i = 0; i < arr.length; i++) {
		// 	for (int j = 0; j < arr[i].length; j++) {
		// 		if (arr[i][j] == 0) {
		// 			break;
		// 		} else {
		// 			System.out.printf("%d ", arr[i][j]);
		// 		}
		// 	}
		// 	System.out.println();
		// }
		// System.out.println();
		// System.out.println();
		// System.out.println();
	}

	public static void R() {
		for (int i = 0; i < arr.length; i++) {
			Map<Integer, Integer> map = new HashMap<>();

			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0) {
					map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
				}
			}

			List<Integer> keySet = sort(map);

			int idx = 0;
			for (int key : keySet) {
				arr[i][idx++] = key;
				arr[i][idx++] = map.get(key);
			}
			while (idx < 100) {
				arr[i][idx++] = 0;
			}
		}
	}

	public static void C() {
		for (int j = 0; j < arr[0].length; j++) {
			Map<Integer, Integer> map = new HashMap<>();

			for (int i = 0; i < arr.length; i++) {
				if (arr[i][j] != 0) {
					map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
				}
			}

			List<Integer> keySet = sort(map);

			int idx = 0;
			for (int key : keySet) {
				arr[idx++][j] = key;
				arr[idx++][j] = map.get(key);
			}
			while (idx < 100) {
				arr[idx++][j] = 0;
			}
		}
	}

	public static List<Integer> sort(Map<Integer, Integer> map) {
		List<Integer> keySet = new ArrayList<>(map.keySet());
		keySet.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (map.get(o1) == map.get(o2)) {
					return o1 - o2;
				} else {
					return map.get(o1) - map.get(o2);
				}
			}
		});

		return keySet;
	}

	public static int row() {
		int max = 0;

		for (int i = 0; i < 100; i++) {
			int cnt = 0;
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] != 0) {
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}
		return max;
	}

	public static int col() {
		int max = 0;

		for (int j = 0; j < 100; j++) {
			int cnt = 0;
			for (int i = 0; i < 100; i++) {
				if (arr[i][j] != 0) {
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}
		return max;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}