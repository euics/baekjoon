import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int[] answer = new int[A];

		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < A; i++) {
			int cur = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty() && stack.peek()[1] < cur)
				answer[stack.pop()[0]] = cur;

			stack.push(new int[] {i, cur});
		}

		while (!stack.isEmpty())
			answer[stack.pop()[0]] = -1;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A; i++)
			sb.append(answer[i]).append(" ");
		System.out.println(sb.toString());
	}
}