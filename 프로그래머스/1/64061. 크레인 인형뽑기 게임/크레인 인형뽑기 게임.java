import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(int[][] board, int[] moves) {
		Stack<Integer> stack = new Stack<>();

		for (int x : moves) {
			x -= 1;
			int y = isEmpty(board, x);

			if (y != -1) {
				if (!stack.isEmpty() && stack.peek() == board[y][x]) {
					stack.pop();
					answer += 2;
				} else {
					stack.push(board[y][x]);
				}

				board[y][x] = 0;
			}
		}

		return answer;
	}

	public int isEmpty(int[][] board, int x) {
		for (int y = 0; y < board.length; y++) {
			if (board[y][x] != 0) {
				return y;
			}
		}

		return -1;
	}
}