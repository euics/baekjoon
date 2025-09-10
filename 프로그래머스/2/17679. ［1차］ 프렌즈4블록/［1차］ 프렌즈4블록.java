import java.util.*;

class Solution {
    static int ans = 0;
    static Map<Character, Integer> map = new HashMap<>();

    static {
        for (int i = 0; i < 26; i++) map.put((char) ('A' + i), i + 1);
    }

    public int solution(int m, int n, String[] board) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) arr[i][j] = map.get(board[i].charAt(j));

        int[] dix = {1, 1, 0};
        int[] diy = {0, 1, 1};

        while (true) {
            boolean[][] bool = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0) continue;

                    boolean same = true;
                    for (int d = 0; d < 3; d++) {
                        int nx = j + dix[d];
                        int ny = i + diy[d];

                        if ((nx >= n || ny >= m) || (arr[i][j] != arr[ny][nx])) {
                            same = false;
                            break;
                        }
                    }

                    if (same) {
                        bool[i][j] = true;

                        for (int d = 0; d < 3; d++) {
                            int nx = j + dix[d];
                            int ny = i + diy[d];

                            bool[ny][nx] = true;
                        }
                    }
                }
            }

            boolean finish = true;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (bool[i][j]) {
                        finish = false;
                        break;
                    }
                }
            }

            if (finish) break;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (bool[i][j]) {
                        arr[i][j] = 0;
                        ans++;
                    }
                }
            }

            for (int col = 0; col < n; col++) {
                Stack<Integer> stack = new Stack<>();

                for (int row = 0; row < m; row++) {
                    if (arr[row][col] != 0) {
                        stack.push(arr[row][col]);
                    }

                    arr[row][col] = 0;
                }

                for (int row = m - 1; row >= 0; row--) {
                    if (stack.isEmpty()) break;

                    arr[row][col] = stack.pop();
                }
            }
        }

        return ans;
    }
}