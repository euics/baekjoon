import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {
	static int[] rules = new int[4];
	static int[] cur = new int[4];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		String DNA = br.readLine();

		rules = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			rules[i] = Integer.parseInt(st.nextToken());

		cur = new int[4];
		for (int i = 0; i < P; i++)
			addCur(DNA.charAt(i));

		int answer = 0;
		if (check(rules, cur))
			answer++;

		int start = 0, end = P;
		while (end < DNA.length()) {
			addCur(DNA.charAt(end));
			removeCur(DNA.charAt(start));

			if (check(rules, cur))
				answer++;

			end++;
			start++;
		}

		System.out.println(answer);
	}

	public static boolean check(int[] rules, int[] cur) {
		for (int i = 0; i < 4; i++) {
			if (cur[i] < rules[i])
				return false;
		}

		return true;
	}

	public static void addCur(char ch) {
		if (ch == 'A')
			cur[0]++;
		if (ch == 'C')
			cur[1]++;
		if (ch == 'G')
			cur[2]++;
		if (ch == 'T')
			cur[3]++;
	}

	public static void removeCur(char ch) {
		if (ch == 'A')
			cur[0]--;
		if (ch == 'C')
			cur[1]--;
		if (ch == 'G')
			cur[2]--;
		if (ch == 'T')
			cur[3]--;
	}
}