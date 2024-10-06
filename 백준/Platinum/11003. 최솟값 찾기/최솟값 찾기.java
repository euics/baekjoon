import java.io.*;
import java.util.*;

public class Main {
	static Deque<int[]> dq = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			while (!dq.isEmpty() && i - dq.peekFirst()[0] + 1 > L) {
				dq.pollFirst();
			}

			while (!dq.isEmpty() && dq.peekLast()[1] > num) {
				dq.pollLast();
			}

			dq.addLast(new int[] {i, num});
			sb.append(dq.peekFirst()[1]).append(" ");
		}

		System.out.println(sb.toString().trim());
	}
}