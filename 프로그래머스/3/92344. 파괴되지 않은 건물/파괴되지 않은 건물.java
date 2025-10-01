import java.util.*;

class Solution {
    static int ans = 0;

    public int solution(int[][] board, int[][] skill) {
        int[][] diff = new int[board.length + 1][board[0].length + 1];

        for (int i = 0; i < skill.length; i++) {
            if (skill[i][0] == 1) {
                diff[skill[i][1]][skill[i][2]] -= skill[i][5];
                diff[skill[i][1]][skill[i][4] + 1] += skill[i][5];
                diff[skill[i][3] + 1][skill[i][2]] += skill[i][5];
                diff[skill[i][3] + 1][skill[i][4] + 1] -= skill[i][5];
            } else {
                diff[skill[i][1]][skill[i][2]] += skill[i][5];
                diff[skill[i][1]][skill[i][4] + 1] -= skill[i][5];
                diff[skill[i][3] + 1][skill[i][2]] -= skill[i][5];
                diff[skill[i][3] + 1][skill[i][4] + 1] += skill[i][5];
            }
        }

        for (int i = 0; i < diff.length - 1; i++) {
            for (int j = 1; j < diff[i].length - 1; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        for (int j = 0; j < diff[0].length; j++) {
            for (int i = 1; i < diff.length; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] += diff[i][j];
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] > 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}