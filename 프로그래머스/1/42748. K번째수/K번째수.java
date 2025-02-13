import java.util.*;

class Solution {
	static int[] answer;

	public int[] solution(int[] array, int[][] commands) {
		answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int[] copyArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			Arrays.sort(copyArray);

			answer[i] = copyArray[commands[i][2] - 1];
		}

		return answer;
	}
}