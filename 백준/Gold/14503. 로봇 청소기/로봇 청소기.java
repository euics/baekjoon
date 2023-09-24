import java.util.*;
import java.io.*;

public class Main {
    static int n, m, r, c, d, answer = 0;
    static int[][] arr;
    static int[] dix = {-1, 0, 1, 0};
    static int[] diy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(r, c, d);
        
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int dir) {
        if (!visited[x][y] && arr[x][y] == 0) {
            visited[x][y] = true;
            answer++;
        }
        
        boolean cleaned = false;
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nx = x + dix[dir];
            int ny = y + diy[dir];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && arr[nx][ny] == 0) {
                cleaned = true;
                dfs(nx, ny, dir);
                return;
            }
        }

        if (!cleaned) {
            int backDir = (dir + 2) % 4;
            int nx = x + dix[backDir];
            int ny = y + diy[backDir];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] != 1) {
                dfs(nx, ny, dir);
            }
        }
    }
}
