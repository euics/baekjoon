import java.util.*;

class Solution {
    static int ans = 0;

    public int solution(int[][] board, int[] moves) {
        Stack<Integer> box = new Stack<>();
        for (int i = 0; i < moves.length; i++) move(board, box, moves[i] - 1);

        return ans;
    }

    public void move(int[][] board, Stack<Integer> box, int col) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] != 0) {
                if (!box.isEmpty()) {
                    if (board[row][col] == box.peek()) {
                        box.pop();
                        ans += 2;
                    } else {
                        box.push(board[row][col]);
                    }
                } else {
                    box.push(board[row][col]);
                }

                board[row][col] = 0;
                break;
            }
        }
    }
}