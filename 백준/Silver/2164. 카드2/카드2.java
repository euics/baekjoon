import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());

		Deque<Integer> dq = new LinkedList<>();
		for (int i = 1; i <= n; i++)
			dq.addLast(i);

		while (!dq.isEmpty() && dq.size() > 1) {
			int remove = dq.pollFirst();
			dq.addLast(dq.pollFirst());
		}

		System.out.println(dq.pollFirst());
	}
}