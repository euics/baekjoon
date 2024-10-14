import java.util.Arrays;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int idx = 0;

		for (int[] command : commands) {
			int[] copyArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
			Arrays.sort(copyArray);

			answer[idx++] = copyArray[command[2] - 1];
		}

		return answer;
	}
}