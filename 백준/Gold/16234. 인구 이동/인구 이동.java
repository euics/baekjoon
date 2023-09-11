import java.io.*;
import java.util.*;

public class Main {
    static int[][] A;
    static int N, L, R;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        A = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        
        while(true) {
            boolean[][] visited = new boolean[N][N];
            boolean moved = false;
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        moved |= bfs(i, j, visited);
                    }
                }
            }
            
            if(!moved) break;
            
            answer++;
        }
        
        System.out.println(answer);
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static boolean bfs(int x, int y, boolean[][] visited) {
        List<int[]> union = new ArrayList<>();
        int sum = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        union.add(new int[] {x, y});
        sum += A[x][y];
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(A[current[0]][current[1]] - A[nx][ny]);
                    if(diff >= L && diff <= R) {
                        queue.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        union.add(new int[] {nx, ny});
                        sum += A[nx][ny];
                    }
                }
            }
        }
        
        if(union.size() > 1) {
            int avg = sum / union.size();
            for(int[] pos : union) {
                A[pos[0]][pos[1]] = avg;
            }
            return true;
        }
        
        return false;
    }
}
