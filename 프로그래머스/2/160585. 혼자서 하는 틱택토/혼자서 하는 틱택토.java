import java.util.*;

class Solution {
    public int solution(String[] board) {
        char[][] ch = new char[3][3];

        int num1 = 0, num2 = 0;
        for (int i = 0; i < 3; i++) {
            ch[i] = board[i].toCharArray();

            for (int j = 0; j < 3; j++) {
                if (ch[i][j] == 'O') num1++;
                if (ch[i][j] == 'X') num2++;
            }
        }

        if (num1 < num2 || num1 > num2 + 1) return 0;
        if (win(ch, 'O') && num1 <= num2) return 0;
        if (win(ch, 'X') && num1 > num2) return 0;

        return 1;
    }

    public boolean win(char[][] ch, char target) {
        for (int row = 0; row < 3; row++) {
            boolean bool = true;

            for (int col = 0; col < 3; col++) {
                if (ch[row][col] != target) {
                    bool = false;
                    break;
                }
            }
            if (bool) return true;

            bool = true;
            for (int col = 0; col < 3; col++) {
                if (ch[col][row] != target) {
                    bool = false;
                    break;
                }
            }
            if (bool) return true;
        }

        boolean bool = true;
        for (int i = 0; i < 3; i++) {
            if (ch[i][i] != target) {
                bool = false;
                break;
            }
        }
        if (bool) return true;

        bool = true;
        for (int i = 0; i < 3; i++) {
            if (ch[i][2 - i] != target) {
                bool = false;
                break;
            }
        }
        if (bool) return true;

        return false;
    }
}