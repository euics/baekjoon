import java.util.*;

class Solution {
    static int ans = 0;
    static char[][] ch;

    public int solution(String[] storage, String[] requests) {
        ch = new char[storage.length + 2][storage[0].length() + 2];
        for (int i = 0; i < ch.length; i++) Arrays.fill(ch[i], '.');

        for (int i = 1; i < ch.length - 1; i++) {
            for (int j = 1; j < ch[i].length - 1; j++) {
                ch[i][j] = storage[i - 1].charAt(j - 1);
            }
        }

        for (int i = 0; i < requests.length; i++) {
            if (requests[i].length() == 1) {
                lift(requests[i].charAt(0));
            }

            if (requests[i].length() == 2) {
                crane(requests[i].charAt(0));
            }
        }

        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                if (ch[i][j] != '.') {
                    ans++;
                }
            }
        }

        return ans;
    }

    public void crane(char target) {
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                if (ch[i][j] == target) {
                    ch[i][j] = '.';
                }
            }
        }
    }

    public void lift(char target) {
        int[] dix = {0, 0, -1, 1};
        int[] diy = {-1, 1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                if (i == 0 || i == ch.length - 1 || j == 0 || j == ch[i].length - 1) {
                    q.add(new int[]{j, i});
                }
            }
        }

        boolean[][] isOutside = new boolean[ch.length][ch[0].length];
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            isOutside[cur[1]][cur[0]] = true;

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dix[d];
                int ny = cur[1] + diy[d];

                if (nx >= 0 && ny >= 0 && ny < ch.length && nx < ch[ny].length && ch[ny][nx] == '.') {
                    if (!isOutside[ny][nx]) {
                        isOutside[ny][nx] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                if (ch[i][j] == target) {
                    for (int d = 0; d < 4; d++) {
                        int nx = j + dix[d];
                        int ny = i + diy[d];

                        if (nx >= 0 && ny >= 0 && ny < ch.length && nx < ch[ny].length) {
                            if (isOutside[ny][nx]) {
                                ch[i][j] = '.';
                            }
                        }
                    }
                }
            }
        }
    }
}