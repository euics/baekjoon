import java.util.Stack;

class Solution {
    static char[][] arr;
    static boolean[][] bool;

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        initArr(m, n, board);

        while (true) {
            bool = new boolean[m][n];

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (arr[i][j] == ' ') continue;

                    findSameBlock(j, i, arr[i][j]);
                }
            }

            int cnt = countSameBlock(m, n);
            if (cnt == 0) break;
            answer += cnt;

            dropBlock(m, n);
        }

        return answer;
    }

    public void initArr(int m, int n, String[] board) {
        arr = new char[m][n];
        for (int i = 0; i < m; i++) arr[i] = board[i].toCharArray();
    }

    public void findSameBlock(int x, int y, char ch) {
        for (int i = y; i <= y + 1; i++) {
            for (int j = x; j <= x + 1; j++) {
                if (arr[i][j] != ch) return;
            }
        }

        for (int i = y; i <= y + 1; i++) {
            for (int j = x; j <= x + 1; j++) {
                bool[i][j] = true;
            }
        }
    }

    public int countSameBlock(int m, int n) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bool[i][j]) {
                    arr[i][j] = ' ';
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dropBlock(int m, int n) {
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (arr[i][j] != ' ') {
                    stack.push(arr[i][j]);
                    arr[i][j] = ' ';
                }
            }

            int index = m - 1;
            while (!stack.isEmpty()) arr[index--][j] = stack.pop();
        }
    }
}