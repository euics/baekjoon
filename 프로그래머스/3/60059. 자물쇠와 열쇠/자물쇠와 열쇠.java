import java.util.*;

class Solution {
    static int N, M;

    public boolean solution(int[][] key, int[][] lock) {
        N = key.length;
        M = lock.length;
        int[][] arr = new int[M + 2 * (N - 1)][M + 2 * (N - 1)];
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[i].length; j++) {
                arr[N + i - 1][N + j - 1] = lock[i][j];
            }
        }

        for (int row = 0; row <= arr.length - N; row++) {
            for (int col = 0; col <= arr[row].length - N; col++) {

                for (int d = 0; d < 4; d++) {
                    key = rotate(key);
                    int[][] tmp = new int[M + 2 * (N - 1)][M + 2 * (N - 1)];
                    for (int i = 0; i < tmp.length; i++) tmp[i] = arr[i].clone();

                    for (int i = row; i < row + N; i++) {
                        for (int j = col; j < col + N; j++) {
                            tmp[i][j] += key[i - row][j - col];
                        }
                    }

                    if (solve(tmp)) return true;
                }
            }
        }

        return false;
    }

    public int[][] rotate(int[][] key) {
        int[][] tmp = new int[key.length][key[0].length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                tmp[j][tmp.length - 1 - i] = key[i][j];
            }
        }

        return tmp;
    }

    public boolean solve(int[][] arr) {
        for (int i = N - 1; i < N + M - 1; i++) {
            for (int j = N - 1; j < N + M - 1; j++) {
                if (arr[i][j] != 1) return false;
            }
        }

        return true;
    }
}