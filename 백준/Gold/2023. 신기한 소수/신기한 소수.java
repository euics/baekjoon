import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<Integer> result = new ArrayList<>();

		DFS(0, 0, N, result);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++)
			sb.append(result.get(i)).append("\n");
		System.out.println(sb.toString());
	}

	public static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		if (num == 2)
			return true;
		if (num % 2 == 0)
			return false;

		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0)
				return false;
		}

		return true;
	}

	public static void DFS(int num, int L, int N, List<Integer> result) {
		if (L == N) {
			if (isPrime(num))
				result.add(num);

			return;
		}

		for (int i = 1; i <= 9; i++) {
			int newNum = num * 10 + i;
			if (isPrime(newNum))
				DFS(newNum, L + 1, N, result);
		}
	}
}