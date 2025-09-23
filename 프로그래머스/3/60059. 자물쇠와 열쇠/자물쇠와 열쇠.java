import java.util.*;

class Solution {
    static int M, N;

    public boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;
        int[][] board = new int[N + 2 * (M - 1)][N + 2 * (M - 1)];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) board[M - 1 + i][M - 1 + j] = lock[i][j];

        for (int i = 0; i < N + M - 1; i++) {
            for (int j = 0; j < N + M - 1; j++) {
                for (int d = 0; d < 4; d++) {
                    key = rotateRight(key);
                    if (unlock(board, key, j, i)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public int[][] rotateRight(int[][] arr) {
        int[][] rotate = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                rotate[arr.length - j - 1][i] = arr[i][j];
            }
        }

        return rotate;
    }

    public boolean unlock(int[][] board, int[][] rotate, int x, int y) {
        int[][] tmp = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) tmp[i] = board[i].clone();

        for (int i = y; i < y + rotate.length; i++) {
            for (int j = x; j < x + rotate.length; j++) {
                tmp[i][j] += rotate[i - y][j - x];
            }
        }

        for (int i = M - 1; i < M + N - 1; i++) {
            for (int j = M - 1; j < M + N - 1; j++) {
                if (tmp[i][j] != 1) return false;
            }
        }

        return true;
    }
}