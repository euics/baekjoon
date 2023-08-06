import java.util.*;
import java.io.*;

public class Main {
    static int R, C, maxCount;
    static char[][] board;
    static boolean[][] visited;
    static boolean[] alphaVisited = new boolean[26]; // 알파벳 'A' ~ 'Z' 까지 방문 체크
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++)
            board[i] = br.readLine().toCharArray();

        DFS(0, 0, 1);  // 시작점에서 카운트는 1
        System.out.println(maxCount);
    }

    private static void DFS(int y, int x, int count) {
        visited[y][x] = true;
        alphaVisited[board[y][x] - 'A'] = true; // 알파벳 방문 체크

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < C && ny < R) {
                if (!visited[ny][nx] && !alphaVisited[board[ny][nx] - 'A']) {
                    DFS(ny, nx, count + 1);
                }
            }
        }

        // 이전 상태로 복원
        visited[y][x] = false;
        alphaVisited[board[y][x] - 'A'] = false;
        maxCount = Math.max(maxCount, count); // 최대 카운트 업데이트
    }
}