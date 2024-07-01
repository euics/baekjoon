import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int pointer = 0;
		for (int num = 1; num <= n; num++) {
			stack.push(num);
			sb.append("+\n");

			while (!stack.isEmpty() && stack.peek() == nums[pointer]) {
				stack.pop();
				pointer++;
				sb.append("-\n");

				if (stack.isEmpty())
					break;
			}
		}

		System.out.println(pointer == n ? sb.toString() : "NO");
	}
}