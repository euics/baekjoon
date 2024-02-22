import java.util.Stack;

class Solution {
    public char[][] arr;
    public boolean[][] bool;

    public int solution(int m, int n, String[] board) {
        arr = new char[m][n];
        for (int i = 0; i < m; i++) arr[i] = board[i].toCharArray();

        int answer = 0;
        while (true) {
            bool = new boolean[m][n];

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if(arr[i][j] == ' ') continue;
                    
                    findSameBlock(j, i, arr[i][j]);
                }
            }

            int cnt = removeBlocks(m, n);
            if(cnt == 0) break;
            answer += cnt;

            dropBlock(m, n);
        }

        return answer;
    }

    private void findSameBlock(int x, int y, char ch) {
        for(int i = y; i <= y + 1; i++) {
            for(int j = x; j <= x + 1; j++) {
                if(arr[i][j] != ch) return;
            }
        }

        for(int i = y; i <= y + 1; i++) {
            for(int j = x; j <= x + 1; j++) {
                bool[i][j] = true;
            }
        }
    }

    private int removeBlocks(int m, int n) {
        int cnt = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(bool[i][j] == true) {
                    arr[i][j] = ' ';
                    cnt++;
                }
            }
        }

        return cnt;
    }
    
    private void dropBlock(int m, int n) {
        for(int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < m; j++) {
                if(arr[j][i] != ' ') {
                    stack.push(arr[j][i]);
                    arr[j][i] = ' ';
                }
            }
            
            int index = m - 1;
            while(!stack.isEmpty()) {
                arr[index][i] = stack.pop();
                index--;
            }
        }
    }
}