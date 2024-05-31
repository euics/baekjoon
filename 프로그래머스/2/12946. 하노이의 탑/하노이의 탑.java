import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[][] solution(int n) {
		List<int[]> moves = new ArrayList<>();
		hanoi(n, 1, 2, 3, moves);

		return moves.toArray(new int[moves.size()][]);
	}

	public void hanoi(int n, int from, int aux, int to, List<int[]> moves) {
		if(n == 1) {
			moves.add(new int[]{from, to});

			return;
		}

		hanoi(n - 1, from, to, aux, moves);
		moves.add(new int[]{from, to});
		hanoi(n - 1, aux, from, to, moves);
	}
}