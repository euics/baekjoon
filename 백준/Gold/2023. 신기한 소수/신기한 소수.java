import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		List<Integer> answer = new ArrayList<>();

		DFS(0, 0, N, answer);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < answer.size(); i++)
			sb.append(answer.get(i)).append("\n");
		System.out.println(sb.toString());
	}

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;

		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	public static void DFS(int L, int num, int N, List<Integer> answer) {
		if (L == N) {
			answer.add(num);

			return;
		}

		for (int i = 1; i <= 9; i++) {
			int newNum = num * 10 + i;
			if (isPrime(newNum))
				DFS(L + 1, newNum, N, answer);
		}
	}
}