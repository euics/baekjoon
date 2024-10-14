import java.util.*;
import java.io.*;

public class Main {

	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		DFS(0, N, 0);

		StringBuilder sb = new StringBuilder();
		for (int num : list) {
			sb.append(num).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}

		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void DFS(int L, int n, int num) {
		if (L == n) {
			list.add(num);

			return;
		}

		for (int i = 1; i <= 9; i++) {
			int newNum = 10 * num + i;
			if (isPrime(newNum)) {
				DFS(L + 1, n, newNum);
			}
		}
	}
}