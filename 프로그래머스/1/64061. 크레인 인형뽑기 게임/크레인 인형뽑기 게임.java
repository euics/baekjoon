import java.util.*;

class Solution {
	static int answer = 0;

	public int solution(int[][] board, int[] moves) {
		int N = board.length;

		for (int i = 0; i < moves.length; i++) {
			moves[i]--;
		}

		Stack<Integer> stack = new Stack<>();
		for (int col : moves) {

			for (int row = 0; row < N; row++) {

				if (board[row][col] != 0) {
					if (!stack.isEmpty() && stack.peek() == board[row][col]) {
						stack.pop();
						board[row][col] = 0;
						answer += 2;
					} else {
						stack.push(board[row][col]);
						board[row][col] = 0;
					}

					break;
				}

			}
		}

		return answer;
	}
}