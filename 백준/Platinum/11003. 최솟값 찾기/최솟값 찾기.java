import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		Deque<int[]> dq = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());

			while (!dq.isEmpty() && i - dq.peekFirst()[0] + 1 > L)
				dq.pollFirst();

			while (!dq.isEmpty() && dq.peekLast()[1] > now)
				dq.pollLast();

			dq.addLast(new int[] {i, now});

			sb.append(dq.peekFirst()[1]).append(' ');
		}

		System.out.println(sb.toString().trim());
	}
}