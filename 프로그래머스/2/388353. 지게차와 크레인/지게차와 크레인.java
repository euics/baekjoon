import java.util.*;

class Solution {
    static int ans = 0;

    public int solution(String[] storage, String[] requests) {
        char[][] ch = new char[storage.length + 2][storage[0].length() + 2];
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length(); j++) {
                ch[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                if (i == 0 || i == ch.length - 1) {
                    ch[i][j] = '0';
                }

                if (j == 0 || j == ch[i].length - 1) {
                    ch[i][j] = '0';
                }
            }
        }

        for (int i = 0; i < requests.length; i++) {
            boolean[][] bool = new boolean[ch.length][ch[0].length];

            if (requests[i].length() == 1) {
                for (int row = 0; row < ch.length; row++) {
                    for (int col = 0; col < ch[row].length; col++) {
                        if (ch[row][col] == '0') continue;

                        if (ch[row][col] == requests[i].charAt(0)) {
                            if (isEdge(ch, col, row)) {
                                bool[row][col] = true;
                            }
                        }
                    }
                }
            } else {
                for (int row = 0; row < ch.length; row++) {
                    for (int col = 0; col < ch[row].length; col++) {
                        if (ch[row][col] == '0') continue;

                        if (ch[row][col] == requests[i].charAt(0)) {
                            bool[row][col] = true;
                        }
                    }
                }
            }

            for (int row = 0; row < bool.length; row++) {
                for (int col = 0; col < bool[row].length; col++) {
                    if (bool[row][col]) {
                        ch[row][col] = '0';
                    }
                }
            }
        }

        for (int row = 1; row < ch.length - 1; row++) {
            for (int col = 1; col < ch[row].length - 1; col++) {
                if (ch[row][col] != '0') {
                    ans++;
                }
            }
        }

        return ans;
    }

    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    public boolean isEdge(char[][] ch, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isOutside = new boolean[ch.length][ch[0].length];
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                if (i == 0 || i == ch.length - 1 || j == 0 || j == ch[i].length - 1) {
                    q.add(new int[]{j, i});
                    isOutside[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dix[d];
                int ny = cur[1] + diy[d];

                if (nx >= 0 && ny >= 0 && ny < ch.length && nx < ch[ny].length && ch[ny][nx] == '0') {
                    if (!isOutside[ny][nx]) {
                        isOutside[ny][nx] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dix[d];
            int ny = y + diy[d];

            if (nx >= 0 && ny >= 0 && ny < ch.length && nx < ch[ny].length && ch[ny][nx] == '0') {
                if (isOutside[ny][nx]) {
                    return true;
                }
            }
        }

        return false;
    }
}