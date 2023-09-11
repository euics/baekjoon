import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int[][] originalMap;
    static int n, m;
    static int maxSafeZone = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        originalMap = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        System.out.println(maxSafeZone);
    }

    static void dfs(int x, int y, int wallCount) {
        if(wallCount == 3) {
            bfs();
            return;
        }

        for(int i = x; i < n; i++, y=0) {
            for(int j = y; j < m; j++) {
                if(originalMap[i][j] == 0) {
                    originalMap[i][j] = 1;
                    dfs(i, j, wallCount+1);
                    originalMap[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        int[][] copyMap = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            copyMap[i] = originalMap[i].clone();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copyMap[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for(int k = 0; k < 4; k++) {
                int nx = current[0] + dx[k];
                int ny = current[1] + dy[k];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        
        int safeZone = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copyMap[i][j] == 0) safeZone++;
            }
        }
        
        maxSafeZone = Math.max(maxSafeZone, safeZone);
    }
}
