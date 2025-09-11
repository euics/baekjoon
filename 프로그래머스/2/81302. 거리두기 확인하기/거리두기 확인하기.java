import java.util.*;

class Solution {
    static List<Integer> ans = new ArrayList<>();

    public int[] solution(String[][] places) {
        for (int i = 0; i < 5; i++) {
            char[][] ch = new char[5][5];
            for (int j = 0; j < 5; j++) for (int k = 0; k < 5; k++) ch[j][k] = places[i][j].charAt(k);

            boolean safe = true;
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (ch[row][col] == 'P') {
                        if (isDistance(ch, row, col)) {
                            safe = false;
                            break;
                        }
                    }
                }
            }

            if (safe) ans.add(1);
            else ans.add(0);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    public boolean isDistance(char[][] ch, int row, int col) {
        int[] dix = new int[]{0, 0, -1, 1};
        int[] diy = new int[]{-1, 1, 0, 0};
        for (int d = 0; d < 4; d++) {
            int nx = col + dix[d];
            int ny = row + diy[d];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) if (ch[ny][nx] == 'P') return true;
        }

        dix = new int[]{0, 0, -2, 2, 1, 1, -1, -1};
        diy = new int[]{-2, 2, 0, 0, -1, 1, -1, 1};
        for (int d = 0; d < 8; d++) {
            int nx = col + dix[d];
            int ny = row + diy[d];

            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && ch[ny][nx] == 'P') {
                if (d < 4) {
                    if (ch[(row + ny) / 2][(col + nx) / 2] != 'X') {
                        return true;
                    }
                } else {
                    if (ch[ny][col] != 'X' || ch[row][nx] != 'X') {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}