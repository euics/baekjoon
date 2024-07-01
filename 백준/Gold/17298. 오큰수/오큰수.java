import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				answer[stack.pop()] = arr[i];
			}

			stack.push(i);
		}

		while (!stack.isEmpty())
			answer[stack.pop()] = -1;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(answer[i]).append(" ");
		System.out.println(sb.toString());
	}
}