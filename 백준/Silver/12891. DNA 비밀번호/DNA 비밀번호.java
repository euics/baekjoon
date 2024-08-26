import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] DNA = br.readLine().toCharArray();

		int[] sequence = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			sequence[i] = Integer.parseInt(st.nextToken());

		int end = 0;
		int[] result = new int[4];
		for (end = 0; end < P; end++) {
			if (DNA[end] == 'A')
				result[0]++;
			if (DNA[end] == 'C')
				result[1]++;
			if (DNA[end] == 'G')
				result[2]++;
			if (DNA[end] == 'T')
				result[3]++;
		}

		int answer = 0;
		if (isSubString(result, sequence))
			answer++;

		int start = 0;
		while (end < S) {
			if (DNA[end] == 'A')
				result[0]++;
			if (DNA[end] == 'C')
				result[1]++;
			if (DNA[end] == 'G')
				result[2]++;
			if (DNA[end] == 'T')
				result[3]++;

			if (DNA[start] == 'A')
				result[0]--;
			if (DNA[start] == 'C')
				result[1]--;
			if (DNA[start] == 'G')
				result[2]--;
			if (DNA[start] == 'T')
				result[3]--;

			if (isSubString(result, sequence))
				answer++;

			end++;
			start++;
		}

		System.out.println(answer);
	}

	public static boolean isSubString(int[] result, int[] sequence) {
		for (int i = 0; i < 4; i++) {
			if (result[i] < sequence[i])
				return false;
		}

		return true;
	}
}

// A C G T